package com.zsga.kbms.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.zsga.kbms.entity.Article;
import com.zsga.kbms.entity.ArticleType;
import com.zsga.kbms.entity.Link;
import com.zsga.kbms.service.ArticleService;
import com.zsga.kbms.service.ArticleTypeService;
import com.zsga.kbms.service.LinkService;

/**
 * 管理员系统Controller
 * @author admin
 *
 */
@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {

	@Autowired
	private ArticleTypeService articleTypeService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private LinkService linkService;
	
	/**
	 * 刷新系统缓存
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/refreshSystem")
	@ResponseBody
	public Map<String, Object> refreshSystem(HttpServletRequest request) {
		ServletContext application=RequestContextUtils.getWebApplicationContext(request).getServletContext();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			//获取前五文章信息类别和对应类别下的文章数量
			List<ArticleType> articleTypeTop5List = articleTypeService.countTop5List();
			application.setAttribute("articleTypeTop5List", articleTypeTop5List);
			//获取前五文章发布日期和对应月份下的文章数量
			List<Article> articleTop5List = articleService.countTop5List();
			application.setAttribute("articleTop5List", articleTop5List);
			// 获取排序号前五友情链接
			List<Link> linkTop5List=linkService.findTop5Link(); 
			application.setAttribute("linkTop5List", linkTop5List);
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
		}
		return modelMap;
	}
}
