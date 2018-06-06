package com.zsga.kbms.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zsga.kbms.entity.ArticleType;
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
	 * 添加用户权限
	 * @param id
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saveRoles")
	public Map<String, Object> saveRoles(@RequestParam(value="id", required=true)String id,
			String roles) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setRole(roles);
		int result = userService.addRoles(user);
		if (result > 0) {
			modelMap.put("success", true);
		} else {
			modelMap.put("success", false);
		}
		return modelMap;
	}
	
	/**
	 * 根据用户ID获取用户权限
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRoles")
	public Map<String, Object> getRoles(@RequestParam(value="id", required=true)String id,
			HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			String roles = userService.findUserById(Integer.parseInt(id)).getRole();
//			request.getServletContext().setAttribute("roles", roles);
			List<ArticleType> articleTyleList = (List<ArticleType>) request.getServletContext().getAttribute("articleTypeList");
			modelMap.put("articleTyleList", articleTyleList);
			modelMap.put("roles", roles);
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
		}
		return modelMap;
	}
	
	/**
	 * 分页显示用户信息
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Map<String, Object> list(@RequestParam(value="page", required=false)String page,
			@RequestParam(value="rows",required=false)String rows) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			PageInfo<User> pageInfo = userService.getUsers(Integer.parseInt(page), 
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
