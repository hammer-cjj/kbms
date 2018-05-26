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
public class JspFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		User currentUser = (User) req.getSession().getAttribute("currentUser");
		if (currentUser == null) {
			res.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
