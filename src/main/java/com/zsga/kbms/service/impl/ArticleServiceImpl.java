package com.zsga.kbms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsga.kbms.dao.ArticleDao;
import com.zsga.kbms.dao.ArticleTypeDao;
import com.zsga.kbms.entity.Article;
import com.zsga.kbms.entity.ArticleType;
import com.zsga.kbms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	@Autowired ArticleTypeDao articleTypeDao;

	@Override
	public Integer addArticle(Article article) {
		return articleDao.insertArticle(article);
	}

	@Override
	public PageInfo<Article> findArticle(Integer page, Integer rows, Map<String, Object> map) {
		PageHelper.startPage(page, rows);
		List<Article> articleList = articleDao.queryArticle(map);
		PageInfo<Article> pageInfo = new PageInfo<Article>(articleList);
		return pageInfo;
	}

	@Override
	public Article findArticleById(Integer id) {
		return articleDao.queryArticleById(id);
	}

	@Override
	public Integer editArticle(Article article) {
		return articleDao.updateArticle(article);
	}

	@Override
	public Integer removeArticle(Integer id) {
		return articleDao.deleteArticle(id);
	}

	@Override
	public Article getLastArticle(Integer id) {
		return articleDao.queryLastArticle(id);
	}

	@Override
	public Article getNextArticle(Integer id) {
		return articleDao.queryNextArticle(id);
	}

	@Override
	public List<Article> countTop5List() {
		return articleDao.countTop5List();
	}

	@Override
	public Integer countByArticleTyId(Integer typeId) {
		return articleDao.countByArticleTyId(typeId);
	}

	@Override
	public PageInfo<Article> findWenku(Integer page, Integer rows, Map<String, Object> map) {
		PageHelper.startPage(page, rows);
		List<Article> articleList = articleDao.queryWenku(map);
		PageInfo<Article> pageInfo = new PageInfo<Article>(articleList,5);
		return pageInfo;
	}

}
