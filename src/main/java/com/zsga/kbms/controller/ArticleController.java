package com.zsga.kbms.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zsga.kbms.entity.Article;
import com.zsga.kbms.entity.User;
import com.zsga.kbms.lucene.ArticleIndex;
import com.zsga.kbms.service.ArticleService;
import com.zsga.kbms.service.CommentService;
import com.zsga.kbms.utils.StringUtil;

/**
 * 文章Controller
 * @author admin
 *
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CommentService commentService;
	
	//文章索引
	private ArticleIndex articleIndex = new ArticleIndex();
	
	/**
	 * 请求文章信息
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id")Integer id,HttpServletRequest request) throws Exception {
		ModelAndView mav=new ModelAndView();
		Article article = articleService.findArticleById(id);
		//获取文章类型ID
		Integer articleTypeId = article.getArticleType().getId();
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		String role = currentUser.getRole();
		if (role.contains(Integer.toString(articleTypeId))) {  //有权查看
			String keyWords=article.getKeyWord();
			if(StringUtil.isNotEmpty(keyWords)){
				String arr[]=keyWords.split(" ");
				mav.addObject("keyWords",StringUtil.filterWhite(Arrays.asList(arr)));			
			}else{
				mav.addObject("keyWords",null);			
			}
			mav.addObject("article", article);
			article.setClickHit(article.getClickHit()+1); // 文章点击次数加1
			articleService.editArticle(article);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("articleId", article.getId());
			//map.put("state", 1); // 查询审核通过的评论
			mav.addObject("commentList", commentService.list(map)); 
			mav.addObject("pageCode", this.genUpAndDownPageCode(articleService.getLastArticle(id),articleService.getNextArticle(id),request.getServletContext().getContextPath()));
			mav.addObject("mainPage", "foreground/article/view.jsp");
			mav.addObject("pageTitle",article.getTitle()+"_知识库系统");
			mav.setViewName("mainTemp");
		} else { //无权限查看
			mav.setViewName("noaccess");
		}
		
		return mav;
	}
	
	/**
	 * 获取下一篇文章和下一篇文章代码
	 * @param lastArticle
	 * @param nextArticle
	 * @param projectContext
	 * @return
	 */
	private String genUpAndDownPageCode(Article lastArticle,Article nextArticle,String projectContext){
		StringBuffer pageCode = new StringBuffer();
		if(lastArticle == null || lastArticle.getId() == null){
			pageCode.append("<p>上一篇：没有了</p>");
		}else{
			pageCode.append("<p>上一篇：<a href='"+projectContext+"/article/articles/"+lastArticle.getId()+".html'>"+lastArticle.getTitle()+"</a></p>");
		}
		if(nextArticle == null || nextArticle.getId() == null){
			pageCode.append("<p>下一篇：没有了</p>");
		}else{
			pageCode.append("<p>下一篇：<a href='"+projectContext+"/article/articles/"+nextArticle.getId()+".html'>"+nextArticle.getTitle()+"</a></p>");
		}
		return pageCode.toString();
	}
	
	/**
	 * 根据关键字查询相关文章信息
	 * @param q
	 * @param page
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/q")
	public ModelAndView search(@RequestParam(value="q", required=false)String q, @RequestParam(value="page", required=false)String page,
			HttpServletRequest request) throws Exception {
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		ModelAndView mav=new ModelAndView();
		mav.addObject("mainPage", "foreground/article/result.jsp");
		List<Article> articleList=articleIndex.searchArticle(q.trim());
		Integer toIndex=articleList.size()>=Integer.parseInt(page)*10?Integer.parseInt(page)*10:articleList.size();
		mav.addObject("articleList",articleList.subList((Integer.parseInt(page)-1)*10, toIndex));
		mav.addObject("pageCode",this.genUpAndDownPageCode(Integer.parseInt(page), articleList.size(), q,10,request.getServletContext().getContextPath()));
		mav.addObject("q",q);
		mav.addObject("resultTotal",articleList.size());
		mav.addObject("pageTitle","搜索关键字'"+q+"'结果页面_知识库系统");
		mav.setViewName("mainTemp");
		return mav;
	}
	
	/**
	 * 获取上一页，下一页代码 查询文章用到
	 * @param page 当前页
	 * @param totalNum 总记录数
	 * @param q 查询关键字
	 * @param pageSize 每页大小
	 * @param projectContext
	 * @return
	 */
	private String genUpAndDownPageCode(Integer page,Integer totalNum,String q,Integer pageSize,String projectContext){
		long totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		StringBuffer pageCode=new StringBuffer();
		if(totalPage==0){
			return "";
		}else{
			pageCode.append("<nav>");
			pageCode.append("<ul class='pager' >");
			if(page>1){
				pageCode.append("<li><a href='"+projectContext+"/article/q.html?page="+(page-1)+"&q="+q+"'>上一页</a></li>");
			}else{
				pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
			}
			if(page<totalPage){
				pageCode.append("<li><a href='"+projectContext+"/article/q.html?page="+(page+1)+"&q="+q+"'>下一页</a></li>");				
			}else{
				pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");				
			}
			pageCode.append("</ul>");
			pageCode.append("</nav>");
		}
		return pageCode.toString();
	}
	
}
