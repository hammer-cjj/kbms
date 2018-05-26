package com.zsga.kbms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zsga.kbms.entity.User;
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
			return "redirect:/admin/main.jsp";
		}
	}
	
}
