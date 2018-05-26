package com.zsga.kbms.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zsga.kbms.BaseTest;
import com.zsga.kbms.entity.Article;
import com.zsga.kbms.entity.ArticleType;

public class ArticleDaoTest extends BaseTest {

	@Autowired
	private ArticleDao articleDao;
	
	
	@Test
	public void testInsertArticle() {
		Article article = new Article();
		article.setTitle("测试题目");
		ArticleType articleType = new ArticleType();
		articleType.setId(12);
		article.setArticleType(articleType);
		article.setContent("测试内容");
		article.setKeyWord("测试关键字");
		article.setSummary("测试摘要");
		articleDao.insertArticle(article);
	}
	
	@Test
	public void testQueryArticleById() {
		Article article = articleDao.queryArticleById(1);
		System.out.println(article.getTitle());
	}
	
	@Test
	public void testQueryLastArticle() {
		Article article = articleDao.queryLastArticle(2);
		System.out.println(article.getId());
	}
	
	@Test
	public void testQueryNextArticle() {
		Article article = articleDao.queryNextArticle(2);
		System.out.println(article.getId());
	}
}
