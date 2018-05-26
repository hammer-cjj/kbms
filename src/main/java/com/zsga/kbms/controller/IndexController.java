package com.zsga.kbms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zsga.kbms.entity.Article;
import com.zsga.kbms.service.ArticleService;
import com.zsga.kbms.utils.PageUtil;
import com.zsga.kbms.utils.StringUtil;

/**
 * 主页Controller
 * @author admin
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 请求主页
	 * @param page
	 * @param typeId
	 * @param releaseDateStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(value="page",required=false)String page,
			@RequestParam(value="typeId",required=false)String typeId,
			@RequestParam(value="releaseDateStr",required=false)String releaseDateStr,
			HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("typeId", typeId);
		map.put("releaseDateStr", releaseDateStr);
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		PageInfo<Article> pageInfo=articleService.findArticle(Integer.parseInt(page), 10, map);
		List<Article> articleList = pageInfo.getList();
		for(Article article:articleList) {
			List<String> imagesList=article.getImagesList();
			String articleInfo=article.getContent();
			Document doc=Jsoup.parse(articleInfo);
			Elements jpgs=doc.select("img[src$=.jpg]"); //　查找扩展名是jpg的图片
			for(int i=0;i<jpgs.size();i++){
				Element jpg=jpgs.get(i);
				imagesList.add(jpg.toString());
				if(i==2){
					break;
				}
			}
		}
		mav.addObject("articleList", articleList);
		StringBuffer param=new StringBuffer(); // 查询参数
		if(StringUtil.isNotEmpty(typeId)){
			param.append("typeId="+typeId+"&");
		}
		if(StringUtil.isNotEmpty(releaseDateStr)){
			param.append("releaseDateStr="+releaseDateStr+"&");
		}
		mav.addObject("pageCode",PageUtil.genPagination(request.getContextPath()+"/index.do", pageInfo, Integer.parseInt(page), param.toString()));
		mav.addObject("mainPage", "foreground/article/list.jsp");
		mav.addObject("pageTitle","知识库系统");
		mav.setViewName("mainTemp");
		return mav;
	}
	
	/**
	 * 请求文库
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wenku")
	public ModelAndView wenku()throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.addObject("mainPage", "foreground/wenku/info.jsp");
		mav.addObject("pageTitle","文库_知识库系统");
		mav.setViewName("mainTempWenku");
		return mav;
	}
	
	/**
	 * 
	 * @param typeId
	 * @param page
	 * @param title
	 * @param userId
	 * @param stratTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wenku/list")
	public ModelAndView wenkuList(@RequestParam(value="typeId", required=false)String typeId,
			@RequestParam(value="page", required=false)String page, @RequestParam(value="title", required=false)String title,
			@RequestParam(value="startTime", required=false)String startTime,
			@RequestParam(value="endTime", required=false)String endTime) throws Exception {
		ModelAndView mav = new ModelAndView();
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		//封装搜索时输入的参数
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("title", title);
		if (StringUtil.isNotEmpty(typeId)) {
			map.put("typeId", typeId);
		}
		if (StringUtil.isNotEmpty(startTime)) {
			map.put("startTime", startTime);
		}
		if (StringUtil.isNotEmpty(endTime)) {
			map.put("endTime", endTime);
		}
 		PageInfo<Article> pageInfo = articleService.findWenku(Integer.parseInt(page), 
				10, map);
 		mav.addObject("map", map);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("mainPage", "foreground/wenku/info.jsp");
		mav.addObject("pageTitle","文库_知识库系统");
		mav.setViewName("mainTempWenku");
		return mav;
	}
	
}
