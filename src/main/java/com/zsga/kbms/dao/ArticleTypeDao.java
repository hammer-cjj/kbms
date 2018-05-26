package com.zsga.kbms.dao;

import java.util.List;

import com.zsga.kbms.entity.ArticleType;

/**
 * 文章分类Dao接口
 * @author admin
 *
 */
public interface ArticleTypeDao {
	
	/**
	 * 查询文章类别和文章数量
	 * @return
	 */
	public List<ArticleType> countList();
	
	/**
	 * 查询前五的文章类别和对应类别下的文章数量
	 * @return
	 */
	public List<ArticleType> countTop5List();
	
	/**
	 * 查询文章子类别
	 * @param parentId
	 * @return
	 */
	public Integer queryChildrenArticleType(Integer parentId);
	
	/**
	 * 根据编号ID查找文章类别
	 * @param id
	 * @return
	 */
	public ArticleType queryArticleTypeById(Integer id);
	 
	/**
	 * 添加文章分类
	 * @param articleType
	 * @return
	 */
	public Integer insertArticleType(ArticleType articleType);
	
	/**
	 * 更新文章类别
	 * @param articleType
	 * @return
	 */
	public Integer updateArticleType(ArticleType articleType);
	
	
	/**
	 * 删除文章类别
	 * @param id
	 * @return
	 */
	public Integer deleteArticleType(Integer id);
	
	/**
	 * 分页查询文章分类
	 * @return
	 */
	public List<ArticleType> queryArticleType();
}
