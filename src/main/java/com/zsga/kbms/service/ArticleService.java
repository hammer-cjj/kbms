package com.zsga.kbms.service;


import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.zsga.kbms.entity.Article;

/**
 * 文章Service层
 * @author admin
 *
 */
public interface ArticleService {
	
	/**
	 * //获取前五文章发布日期和对应月份下的文章数量
	 * @return
	 */
	public List<Article> countTop5List();
	
	/**
	 * 分页查询文库列表
	 * @param page
	 * @param rows
	 * @param map
	 * @return
	 */
	public PageInfo<Article> findWenku(Integer page, Integer rows, Map<String, Object> map);
	
	/**
	 * 分页查询文章
	 * @param page
	 * @param rows
	 * @param map
	 * @return
	 */
	public PageInfo<Article> findArticle(Integer page, Integer rows, Map<String, Object> map);
	
	/**
	 * 添加文章
	 * @param article
	 * @return
	 */
	public Integer addArticle(Article article);
	
	/**
	 * 根据ID查询文章信息
	 * @param id
	 * @return
	 */
	public Article findArticleById(Integer id);
	
	/**
	 * 更新文章
	 * @param article
	 * @return
	 */
	public Integer editArticle(Article article);
	
	/**
	 * 删除文章
	 * @param id
	 * @return
	 */
	public Integer removeArticle(Integer id);
	
	/**
	 * 查询上一篇文章
	 * @param id
	 * @return
	 */
	public Article getLastArticle(Integer id);
	
	/**
	 * 查询下一篇文章
	 * @param id
	 * @return
	 */
	public Article getNextArticle(Integer id);
	
	/**
	 * 根据类型ID统计该类型下的文章数量
	 * @param typeId
	 * @return
	 */
	public Integer countByArticleTyId(Integer typeId);
}
