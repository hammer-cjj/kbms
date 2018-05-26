package com.zsga.kbms.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsga.kbms.entity.User;
import com.zsga.kbms.service.UserService;

/**
 * 管理员用户Controller层
 * @author admin
 *
 */
@Controller
@RequestMapping("/admin/user")
public class UserAdminController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 修改用户密码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/modifyPassword")
	@ResponseBody
	public Map<String, Object> modifyPassword(String newPassword, HttpServletRequest request) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		currentUser.setPassword(newPassword);
		int result = userService.editUser(currentUser);
		if (result > 0) {
			modelMap.put("success", true);
		} else {
			modelMap.put("success", false);
		}
		return modelMap;
	}
	
	/**
	 * 注销
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String  logout(HttpServletRequest request)throws Exception{
		request.getSession().removeAttribute("currentUser");
		return "redirect:/login.jsp";
	}
}
