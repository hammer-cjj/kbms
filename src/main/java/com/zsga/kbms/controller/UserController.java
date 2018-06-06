package com.zsga.kbms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zsga.kbms.entity.ArticleType;
import com.zsga.kbms.entity.User;
import com.zsga.kbms.service.ArticleTypeService;
import com.zsga.kbms.service.UserService;

/**
 * 用户Controller层
 * @author admin
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ArticleTypeService articleTypeService;
	
	/**
	 * 用户登录
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) {
		User resultUser = userService.findUserByUserNameAndPassword(user);
		if (resultUser == null) {
			request.setAttribute("user", user);
			request.setAttribute("errorInfo", "用户名或密码错误！");
			return "login";
		} else {
			request.getSession().setAttribute("currentUser", resultUser);
			//查找分类,用于权限控制
			ServletContext application = request.getServletContext();
			List<ArticleType> newArticleTypeList = new ArrayList<ArticleType>();
			List<ArticleType> articleTypeList = articleTypeService.countList();
			User currentUser = (User) request.getSession().getAttribute("currentUser");
			String[] roles = currentUser.getRole().split(",");
			List<String> rolesList = Arrays.asList(roles);
			for (ArticleType articleType: articleTypeList) {
				Integer articleTypeId = articleType.getId();
				if (rolesList.contains(Integer.toString(articleTypeId))) {
					newArticleTypeList.add(articleType);
				}
			}
			application.setAttribute("articleTypeList", newArticleTypeList);
			return "redirect:/index.html";
		}
	}
	
}
