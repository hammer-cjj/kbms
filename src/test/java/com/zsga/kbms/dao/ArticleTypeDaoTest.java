package com.zsga.kbms.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zsga.kbms.BaseTest;
import com.zsga.kbms.entity.ArticleType;

public class ArticleTypeDaoTest extends BaseTest {

	@Autowired
	private ArticleTypeDao articleTypeDao;
	
	@Test
	public void testInsertArticleType() {
		ArticleType articleType = new ArticleType();
		articleType.setTypeName("日常工作");
		articleType.setOrderNo(1);
		articleTypeDao.insertArticleType(articleType);
	}
	
	@Test
	public void testQueryArticleTypeById() {
		ArticleType articleType = articleTypeDao.queryArticleTypeById(1);
		System.out.println(articleType.getTypeName());
	}
	
	@Test
	public void testUpdateArticleType() {
		ArticleType articleType = articleTypeDao.queryArticleTypeById(5);
		articleType.setArticleCount(100);
		articleType.setOrderNo(20);
		articleType.setTypeName("更改后的测试");
		articleTypeDao.updateArticleType(articleType);
	}
	
	@Test
	public void testDeleteArticleType() {
		articleTypeDao.deleteArticleType(6);
	}
	
	@Test
	public void testQueryChildrenArticleType() {
		int count = articleTypeDao.queryChildrenArticleType(1);
		assertEquals(5, count);
	}
}
