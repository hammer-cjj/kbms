package com.zsga.kbms.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zsga.kbms.entity.ArticleType;
import com.zsga.kbms.entity.Comment;
import com.zsga.kbms.service.CommentService;

/**
 * 管理员评论Controller层
 * @author admin
 *
 */
@Controller
@RequestMapping("/admin/comment")
public class CommentAdminController {
	@Autowired
	private CommentService commentService;
	
	/**
	 * 分页显示评论
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list(@RequestParam(value="page", required=false)String page,
			@RequestParam(value="rows",required=false)String rows,
			@RequestParam(value="state",required=false)String state) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			PageInfo<Comment> pageInfo = commentService.findComments(Integer.parseInt(page), 
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
	 * 删除评论信息
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Map<String, Object> delete(@RequestParam(value="ids")String ids) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String []idsStr=ids.split(",");
		try {
			for(int i=0;i<idsStr.length;i++){
				commentService.delete(Integer.parseInt(idsStr[i]));
			}
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
		}
		return modelMap;
	}
	
	/**
	 * 评论审核
	 * @param ids
	 * @param state
	 * @return
	 */
	@RequestMapping("/review")
	@ResponseBody
	public Map<String, Object> review(@RequestParam(value="ids")String ids,@RequestParam(value="state")Integer state) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			String []idsStr=ids.split(",");
			for(int i=0;i<idsStr.length;i++){
				Comment comment=new Comment();
				comment.setState(state);
				comment.setId(Integer.parseInt(idsStr[i]));
				commentService.update(comment);
			}
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
		}
		return modelMap;
	}
}
