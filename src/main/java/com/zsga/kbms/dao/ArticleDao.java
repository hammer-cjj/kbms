package com.zsga.kbms.dao;

import java.util.List;
import java.util.Map;

import com.zsga.kbms.entity.Article;

/**
 * 文章Dao层接口
 * @author admin
 *
 */
public interface ArticleDao {
	
	/**
	 * //获取前五文章发布日期和对应月份下的文章数量
	 * @return
	 */
	public List<Article> countTop5List();
	
	/**
	 * 更新文章
	 * @param article
	 * @return
	 */
	public Integer updateArticle(Article article);
	
	/**
	 * 添加文章信息
	 * @param article
	 * @return
	 */
	public Integer insertArticle(Article article);
	
	/**
	 * 查询文库
	 * @param map
	 * @return
	 */
	public List<Article> queryWenku(Map<String, Object> map);

	/**
	 * 查询文章
	 * @param map
	 * @return
	 */
	public List<Article> queryArticle(Map<String, Object> map);
	
	/**
	 * 根据ID查询文章信息
	 * @param id
	 * @return
	 */
	public Article queryArticleById(Integer id);
	
	/**
	 * 根据ID删除文章信息
	 * @param id
	 * @return
	 */
	public Integer deleteArticle(Integer id);
	
	/**
	 * 查询上一篇文章
	 * @param id
	 * @return
	 */
	public Article queryLastArticle(Integer id);
	
	/**
	 * 查询下一篇文章
	 * @param id
	 * @return
	 */
	public Article queryNextArticle(Integer id);
	
	/**
	 * 根据类型ID统计该类型下的文章数量
	 * @param id
	 * @return
	 */
	public Integer countByArticleTyId(Integer id);
}
