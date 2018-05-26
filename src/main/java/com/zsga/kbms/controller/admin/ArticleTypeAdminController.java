package com.zsga.kbms.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zsga.kbms.entity.ArticleType;
import com.zsga.kbms.service.ArticleService;
import com.zsga.kbms.service.ArticleTypeService;

/**
 * 管理员文章类别Controller层
 * @author admin
 *
 */
@Controller
@RequestMapping("/admin/articleType")
public class ArticleTypeAdminController {
	@Autowired
	private ArticleTypeService articleTypeService;
	
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 分页查询文章类别
	 * @param page 当前页
	 * @param rows 每页显示多少行
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Map<String, Object> list(@RequestParam(value="page", required=false)String page,
			@RequestParam(value="rows",required=false)String rows) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			PageInfo<ArticleType> pageInfo = articleTypeService.findArticleType(Integer.parseInt(page), 
					Integer.parseInt(rows));
			modelMap.put("success", true);
			modelMap.put("total", pageInfo.getTotal());
			modelMap.put("rows", pageInfo.getList());
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("error", e.getMessage());
		}
		return modelMap;
	}
	
	/**
	 * 添加或修改文章类别信息
	 * @param articleType
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(ArticleType articleType){
		Map<String, Object> modelMap = new HashMap<String, Object>(); 
		int result = 0;
		try {
			if (null == articleType.getId()) { 
				if (null != articleType.getParentId()) {  //添加子类
					//获取父类
					ArticleType parentAritcleType =  articleTypeService.findArticleTypeById(articleType.getParentId());
					articleType.setLevel(parentAritcleType.getLevel()+1);
					result = articleTypeService.addArticleType(articleType);
				} else { //添加
					result = articleTypeService.addArticleType(articleType);
				}
			} else {  //更新
				result = articleTypeService.editArticleType(articleType);
			}
			if (result > 0) {
				modelMap.put("success", true);
			} else {
				modelMap.put("success", false);
			}
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("error", e.getMessage());
		}
		return modelMap;
	}
	
	/**
	 * 删除多条文章类别 
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@Transactional
	public Map<String, Object> delete(@RequestParam("ids")String ids) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String []idsStr=ids.split(",");
		for (int i=0; i<idsStr.length; i++) {
			try {
				ArticleType articleType = articleTypeService.findArticleTypeById(Integer.parseInt(idsStr[i]));
				if (articleTypeService.findChildrenArticleType(articleType.getId()) > 0 ||     //层级大于0，说明有子类型
						articleService.countByArticleTyId(Integer.parseInt(idsStr[i])) > 0) {  //类别下有文章
					modelMap.put("exist", "文章类型下有子类型或者文章类型下有文章，不能删除！");
				} else { //删除文章类型
					articleTypeService.removeArticleType(Integer.parseInt(idsStr[i]));
				}
				modelMap.put("success", true);
			} catch (Exception e) {
				modelMap.put("success", false);
				modelMap.put("error", e.getMessage());
			}
		}
		return modelMap;
	}
}
