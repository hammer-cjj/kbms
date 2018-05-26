package com.zsga.kbms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsga.kbms.entity.Article;
import com.zsga.kbms.entity.Comment;
import com.zsga.kbms.service.ArticleService;
import com.zsga.kbms.service.CommentService;

/**
 * 评论Controller层
 * @author admin
 *
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(Comment comment,@RequestParam("imageCode") String imageCode,
			HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String sRand=(String) request.getSession().getAttribute("sRand"); // 获取系统生成的验证码
		int result = 0;
		if (!imageCode.equals(sRand)) {
			modelMap.put("success", false);
			modelMap.put("errorInfo", "验证码填写错误！");
		} else {
			//获取用户IP
			String userIp = request.getRemoteAddr();
			comment.setUserIp(userIp);
			if (comment.getId() == null) {
				result = commentService.add(comment);
				// 该文章的回复次数加1
				Article article = articleService.findArticleById(comment.getArticle().getId());
				article.setReplyHit(article.getReplyHit() + 1);
				articleService.editArticle(article);
			}
			if (result > 0) {
				modelMap.put("success", true);
			} else {
				modelMap.put("success", false);
			}
		}
		return modelMap;
	}
}
