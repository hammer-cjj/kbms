package com.zsga.kbms.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zsga.kbms.entity.Article;
import com.zsga.kbms.entity.Link;
import com.zsga.kbms.service.LinkService;
import com.zsga.kbms.utils.StringUtil;

/**
 * 友情连接Controller
 * @author admin
 *
 */
@Controller
@RequestMapping("/admin/link")
public class LinkAdminController {
	
	@Autowired
	private LinkService linkService;
	
	/**
	 * 分页查询连接
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
			PageInfo<Link> pageInfo = linkService.findLink(Integer.parseInt(page), 
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
	 * 添加或者修改友情连接
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(Link link) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		int result = 0;
		if (link.getId() == null) {   //新增
			result = linkService.addLink(link);
		} else {  //修改
			result = linkService.editLink(link);
		}
		if (result > 0 ) {
			modelMap.put("success", true);
		} else {
			modelMap.put("success", false);
		}
		return modelMap;
	}
	
	/**
	 * 删除连接
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Map<String, Object> delete(@RequestParam("ids")String ids) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String []idsStr=ids.split(",");
		try {
			for(int i=0;i<idsStr.length;i++){
				linkService.removeLink(Integer.parseInt(idsStr[i]));
				modelMap.put("success", true);
			}
		} catch (Exception e) {
			modelMap.put("success", false);
		}
		return modelMap;
	}
}
