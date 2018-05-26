package com.zsga.kbms.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.github.pagehelper.PageInfo;
import com.zsga.kbms.entity.Article;
import com.zsga.kbms.entity.ArticleType;
import com.zsga.kbms.entity.Link;
import com.zsga.kbms.entity.User;
import com.zsga.kbms.lucene.ArticleIndex;
import com.zsga.kbms.service.ArticleService;
import com.zsga.kbms.service.ArticleTypeService;
import com.zsga.kbms.service.LinkService;
import com.zsga.kbms.utils.StringUtil;

/**
 * 管理员文章Controller层
 * @author admin
 *
 */
@Controller
@RequestMapping("/admin/article")
public class ArticleAdminController {
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ArticleTypeService articleTypeService;
	
	//文章索引
	private ArticleIndex articleIndex = new ArticleIndex();
	
	/**
	 * 分页查询文章
	 * @param page
	 * @param rows
	 * @param article
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam(value="page", required=false)String page,
			@RequestParam(value="rows", required=false)String rows, Article s_article,
			HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		//封装搜索时输入的参数
		Map<String,Object> map=new HashMap<String,Object>();
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		if (currentUser.getManage() == 0) {
			map.put("userId", currentUser.getId());
		}
		map.put("title", StringUtil.formatLike(s_article.getTitle()));
		try {
			PageInfo<Article> pageInfo = articleService.findArticle(Integer.parseInt(page), 
					Integer.parseInt(rows), map);
			modelMap.put("success", true);
			modelMap.put("total", pageInfo.getTotal());
			modelMap.put("rows", pageInfo.getList());
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("error", e.getMessage());
		}
		return modelMap;
	}
	
	/**
	 * 添加或者更新文章
	 * @param article
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/save")
	@ResponseBody
	@Transactional
	public Map<String, Object> save(Article article, HttpServletRequest request) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int result = 0;
		if (article.getId() == null) {  //新增
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			article.setUser(currentUser);
			result = articleService.addArticle(article);
			//添加文章索引
			articleIndex.addIndex(article);
		} else { //更新
			result = articleService.editArticle(article);
			//更新文章索引
			articleIndex.updateIndex(article);
		}
		if (result > 0) {
			ServletContext application=RequestContextUtils.getWebApplicationContext(request).getServletContext();
			//获取前五文章信息类别和对应类别下的文章数量
			List<ArticleType> articleTypeTop5List = articleTypeService.countTop5List();
			application.setAttribute("articleTypeTop5List", articleTypeTop5List);
			//获取前五文章发布日期和对应月份下的文章数量
			List<Article> articleTop5List = articleService.countTop5List();
			application.setAttribute("articleTop5List", articleTop5List);
			modelMap.put("success", true);
		} else {
			modelMap.put("success", false);
		}
		return modelMap;
	}
	
	/**
	 * 按照文章ID查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	@ResponseBody
	public Article findById(@RequestParam("id")String id) throws Exception{
		Article article = articleService.findArticleById(Integer.parseInt(id));
		return article;
	}
	
	/**
	 * 删除文章
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("ids")String ids) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String []idsStr=ids.split(",");
		try {
			for(int i=0;i<idsStr.length;i++){
				articleService.removeArticle(Integer.parseInt(idsStr[i]));
				articleIndex.deleteIndex(idsStr[i]); // 删除对应文章的索引
				modelMap.put("success", true);
			}
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("error", e.getMessage());
		}
		return modelMap;
	}
}
