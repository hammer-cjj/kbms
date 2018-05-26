package com.zsga.kbms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsga.kbms.dao.ArticleTypeDao;
import com.zsga.kbms.entity.ArticleType;
import com.zsga.kbms.service.ArticleTypeService;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {
	
	@Autowired
	private ArticleTypeDao articleTypeDao;

	@Override
	public Integer addArticleType(ArticleType articleType) {
		return articleTypeDao.insertArticleType(articleType);
	}

	@Override
	public PageInfo<ArticleType> findArticleType(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<ArticleType> articleTypeList = articleTypeDao.queryArticleType();
		PageInfo<ArticleType> pageInfo = new PageInfo<ArticleType>(articleTypeList);
		return pageInfo;
	}

	@Override
	public ArticleType findArticleTypeById(Integer id) {
		return articleTypeDao.queryArticleTypeById(id);
	}

	@Override
	public Integer editArticleType(ArticleType articleType) {
		return articleTypeDao.updateArticleType(articleType);
	}

	@Override
	public Integer removeArticleType(Integer id) {
		return articleTypeDao.deleteArticleType(id);
	}

	@Override
	public Integer findChildrenArticleType(Integer parentId) {
		return articleTypeDao.queryChildrenArticleType(parentId);
	}

	@Override
	public List<ArticleType> countList() {
		return articleTypeDao.countList();
	}

	@Override
	public List<ArticleType> countTop5List() {
		return articleTypeDao.countTop5List();
	}

}
