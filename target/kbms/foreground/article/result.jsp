<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="data_list">
		<div class="data_list_title">
		<img src="${pageContext.request.contextPath}/static/images/search_icon.png"/>
		搜索&nbsp;<font color="red">${q }</font>&nbsp;的结果 &nbsp;(总共搜索到&nbsp;${resultTotal}&nbsp;条记录) </div>
		<div class="datas search">
			<ul>
				<c:choose>
					<c:when test="${articleList.size()==0 }">
						<div align="center" style="padding-top: 20px">未查询到结果，请换个关键字试试看！</div>
					</c:when>
					<c:otherwise>
						<c:forEach var="article" items="${articleList }">
					  	  <li style="margin-bottom: 20px">
						  	<span class="title"><a href="${pageContext.request.contextPath}/article/articles/${article.id}.html" target="_blank">${article.title }</a></span>
						  	<span class="summary">摘要: ${article.content }...</span>
						  	<span class="link"><a href="${pageContext.request.contextPath}/article/articles/${article.id}.html">http://127.0.0.1:8080/kbms/article/articles/${article.id}.html</a>&nbsp;&nbsp;&nbsp;&nbsp;发布日期：${article.releaseDateStr }</span>
						  </li>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		${pageCode }
   </div>