package com.zsga.kbms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zsga.kbms.entity.ArticleType;

/**
 * 文章分类Service接口
 * @author admin
 *
 */
public interface ArticleTypeService {
	
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
	 * 查询文章子类的记录数
	 * @param parentId
	 * @return
	 */
	public Integer findChildrenArticleType(Integer parentId);
	
	/**
	 * 根据编号ID查找文章类别
	 * @param id
	 * @return
	 */
	public ArticleType findArticleTypeById(Integer id);

	/**
	 * 添加文章分类
	 * @param articleType
	 * @return
	 */
	public Integer addArticleType(ArticleType articleType);
	
	/**
	 * 更新文章类别
	 * @param articleType
	 * @return
	 */
	public Integer editArticleType(ArticleType articleType);
	
	/**
	 * 删除文章类别
	 * @param id
	 * @return
	 */
	public Integer removeArticleType(Integer id);
	
	/**
	 * 分类查询文章类别
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<ArticleType> findArticleType(Integer page, Integer rows);
}
