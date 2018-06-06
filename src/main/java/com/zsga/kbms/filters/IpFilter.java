package com.zsga.kbms.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.zsga.kbms.utils.IpUtil;

/**
 * 拦截非法IP访问
 * @author admin
 *
 */
public class IpFilter implements Filter {
	
	private String[] allowIps = {
				"10.123.132.103",
				"127.0.0.1",
				"192.168.1.133"
			};
	private List<String> ipAllowList = null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ipAllowList = Arrays.asList(allowIps);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");//设置编码格式  
        RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");//定义错误转向页面  
        //读出本地Ip  
        String remoteIP = IpUtil.getLocalIP();  
        //允许访问的IP列表中包含remoteIP允许访问，否则跳转到错误页面
        if (ipAllowList.contains(remoteIP)) {  
            chain.doFilter(request, response);  
        }else {
        	request.setAttribute("IP", remoteIP);
        	dispatcher.forward(request, response);  
        } 
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
