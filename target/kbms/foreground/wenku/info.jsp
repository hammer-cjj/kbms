<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jspf" %>
<div class="data_list">
	<div class="data_list_title">
		<img src="${pageContext.request.contextPath}/static/images/about_icon.png"/>
		知识列表
	</div>
	<div class="datas">
		<div>
			<form class="form-inline" method="post" action="${pageContext.request.contextPath }/wenku/list.html">
			  <div class="form-group">
			    <label for="exampleInputName2">标题</label>
			    <input name="title" style="width:300px;" type="text" id="exampleInputName2" >
			  </div>
			  <div class="form-group" style="width:10px;">	
			  </div>
			  <div class="form-group" style="width:10px;">	
			  </div>
			  <div class="form-group">
			    <label for="starttime">时间从</label>
			    <input style="width:150px;" type="text" name="startTime" id="starttime" >
			  </div>
			  <div class="form-group">
			    <label for="endtime">到</label>
			    <input style="width:150px;" type="text" id="endtime" name="endTime" >
			  </div>
			  <button type="submit" class="btn btn-primary">确&nbsp;&nbsp;定</button>
			</form>
		</div>
		<br/>
		<c:if test="${not empty pageInfo.list}">
		<table  class="table-hover table-condensed">
	 		<tr>
	 			<th width="400px">标题</th>
	 			<th width="150px">来源</th>
	 			<th width="150px">日期</th>
	 			<th width="150px">浏览</th>
	 		</tr>
	 		<c:forEach var="article" items="${pageInfo.list }" >
		 		<tr>
		 			<td>
		 				<a href="${pageContext.request.contextPath}/article/articles/${article.id}.html">
			 				<c:if test="${fn:length(article.title) > 22}">${fn:substring(article.title,0,22)}...</c:if>
			 				<c:if test="${fn:length(article.title) <= 22}">${article.title }</c:if>
		 				</a>
		 			</td>
		 			<td>${article.user.userName }</td>
		 			<td><fmt:formatDate value="${article.releaseDate }" type="date" pattern="yyyy-MM-dd"/></td>
		 			<td>${article.clickHit }</td>
		 		</tr>
	 		</c:forEach>
		</table>
		<div class="row">
			<div class="col-md-6 col-md-offset-6">
				<ul class="pagination pagination-sm">
					<li><a href="${pageContext.request.contextPath }/wenku/list.html?page=1&typeId=${map.typeId}&title=${map.title}&startTime=${map.startTime}&endTime=${map.endTime}">首页</a></li>
					<c:if test="${pageInfo.hasPreviousPage }">
						 <li>
						      <a href="${pageContext.request.contextPath }/wenku/list.html?page=${pageInfo.pageNum-1}&typeId=${map.typeId}&title=${map.title}&startTime=${map.startTime}&endTime=${map.endTime}" aria-label="Previous">
						        <span aria-hidden="true">上一页</span>
						      </a>
						 </li>
					 </c:if>
	
                     <c:forEach var="idx" items="${pageInfo.navigatepageNums }">
	        			<c:choose>
			        		<c:when test="${idx==pageInfo.pageNum }">
			        			<li><span class="current">${idx }</span></li>
			        		</c:when>
			        		<c:otherwise>
			        			<li><a href="${pageContext.request.contextPath }/wenku/list.html?page=${idx}&typeId=${map.typeId}&title=${map.title}&startTime=${map.startTime}&endTime=${map.endTime}">${idx }</a></li>
			        		</c:otherwise>
		        		</c:choose>
	        		</c:forEach>						

				     <c:if test="${pageInfo.hasNextPage }">
					     <li>
					      <a href="${pageContext.request.contextPath }/wenku/list.html?page=${pageInfo.pageNum+1}&typeId=${map.typeId}&title=${map.title}&startTime=${map.startTime}&endTime=${map.endTime}" aria-label="Next">
					        <span aria-hidden="true">下一页</span>
					      </a>
					     </li>
				     </c:if>
				     <li><a href="${pageContext.request.contextPath }/wenku/list.html?page=${pageInfo.pages}&typeId=${map.typeId}&title=${map.title}&startTime=${map.startTime}&endTime=${map.endTime}">尾页</a></li>
				</ul>
			</div>
		</div>
		</c:if>
	</div>
</div>