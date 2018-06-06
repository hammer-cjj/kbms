package com.zsga.kbms.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsga.kbms.entity.User;

/**
 * 拦截admin下的jsp
 * @author admin
 *
 */
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resq = (HttpServletResponse) response;
		User currentUser = (User) req.getSession().getAttribute("currentUser");
		//session是否存在用户，如果存在，放行
		if (currentUser != null) {
			chain.doFilter(request, response);
			return;
		} 
		//获取请求资源
		String url = req.getRequestURI();
		//1.静态资源或者login.jsp放行
		if (url.contains("static/") || url.contains("login")) {
			chain.doFilter(request, response);
			return;
		}
		
		resq.sendRedirect(req.getContextPath() + "/login.jsp");
		return;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
