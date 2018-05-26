package com.zsga.kbms.utils;

import com.github.pagehelper.PageInfo;
import com.zsga.kbms.entity.Article;

/**
 * 分页工具
 * @author admin
 *
 */
public class PageUtil {

	/**
	 * 
	 * @param targetUrl 目标地址
	 * @param pageInfo 分页信息 
	 * @param currentPage 当前页
	 * @param param 参数    
	 * @return
	 */
	public static String genPagination(String targetUrl,PageInfo<Article> pageInfo, Integer currentPage, String param){
		long totalPage = pageInfo.getPages(); 
		if(totalPage == 0){
			return "未查询到数据";
		}else{
			StringBuffer pageCode=new StringBuffer();
			pageCode.append("<li><a href='"+targetUrl+"?page=1&"+param+"'>首页</a></li>");
			if(currentPage>1){
				pageCode.append("<li><a href='"+targetUrl+"?page="+pageInfo.getPrePage()+"&"+param+"'>上一页</a></li>");			
			}else{
				pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");		
			}
			for(int i=currentPage-2;i<=currentPage+2;i++){
				if(i<1||i>totalPage){
					continue;
				}
				if(i==currentPage){
					pageCode.append("<li class='active'><a href='"+targetUrl+"?page="+i+"&"+param+"'>"+i+"</a></li>");	
				}else{
					pageCode.append("<li><a href='"+targetUrl+"?page="+i+"&"+param+"'>"+i+"</a></li>");	
				}
			}
			if(currentPage<totalPage){
				pageCode.append("<li><a href='"+targetUrl+"?page="+pageInfo.getNextPage()+"&"+param+"'>下一页</a></li>");		
			}else{
				pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");	
			}
			pageCode.append("<li><a href='"+targetUrl+"?page="+totalPage+"&"+param+"'>尾页</a></li>");
			return pageCode.toString();
		}
	}
	

	
	
}
