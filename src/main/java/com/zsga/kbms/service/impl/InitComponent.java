package com.zsga.kbms.service.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.zsga.kbms.entity.Article;
import com.zsga.kbms.entity.ArticleType;
import com.zsga.kbms.entity.Link;
import com.zsga.kbms.service.ArticleService;
import com.zsga.kbms.service.ArticleTypeService;
import com.zsga.kbms.service.LinkService;

/**
 * 初始化组件 把用户信息 根据文章类别分类信息 根据日期归档分类信息 存放到application中，用以提供页面请求性能
 * @author admin
 *
 */
@Component
public class InitComponent implements ServletContextListener,ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		//获取servlet上下文
		ServletContext application = servletContextEvent.getServletContext();
		
		ArticleTypeService articleTypeService = applicationContext.getBean(ArticleTypeService.class);
		//获取全部文章信息类别和对应类别下的文章数量
//		List<ArticleType> articleTypeList = articleTypeService.countList();
//		application.setAttribute("articleTypeList", articleTypeList);
		
		//获取前五文章信息类别和对应类别下的文章数量
		List<ArticleType> articleTypeTop5List = articleTypeService.countTop5List();
		application.setAttribute("articleTypeTop5List", articleTypeTop5List);
		
		//获取前五文章发布日期和对应月份下的文章数量
		ArticleService articleService=(ArticleService) applicationContext.getBean(ArticleService.class);
		List<Article> articleTop5List=articleService.countTop5List();
		application.setAttribute("articleTop5List", articleTop5List);
		
		// 查询所有的友情链接信息
		LinkService linkService=(LinkService) applicationContext.getBean(LinkService.class);
		List<Link> linkTop5List=linkService.findTop5Link(); 
		application.setAttribute("linkTop5List", linkTop5List);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
