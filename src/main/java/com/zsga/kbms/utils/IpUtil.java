package com.zsga.kbms.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP相关的工具类
 * @author quadcopter
 *
 */
public class IpUtil {
	
	private static InetAddress addr;
	
	/**
	 * 获取IP地址
	 * @return
	 */
	public static String getLocalIP() {
		String ip = "";
		String hostName = "";
		try {
			addr = InetAddress.getLocalHost();
			ip=addr.getHostAddress().toString(); //获取本机ip  
			hostName=addr.getHostName().toString(); //获取本机计算机名称  
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		return ip;
	}
}
