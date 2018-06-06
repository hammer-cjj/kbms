<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>KBMS-Powered by CF</title>
<%@ include file="foreground/common/common.jspf" %>
<style type="text/css">
	  body {
        padding-top: 10px;
        padding-bottom: 40px;
      }
</style>
</head>
<body>
<div class="container">
	<jsp:include page="/foreground/common/head.jsp"/>
	
	<jsp:include page="/foreground/common/menu.jsp"/>
	
	<div class="row">
		<div class="col-md-9">
			<jsp:include page="${mainPage }"></jsp:include>
		</div>
		<!-- 
		<div class="col-md-3">
			<div class="data_list">
				<div class="data_list_title">
					<img src="${kbms}/static/images/user_icon.png"/>
					作者信息
				</div>
				<div class="user_image">
					<img src="${pageContext.request.contextPath}/static/userImages/${blogger.imageName }"/>
				</div>
				<div class="nickName">${blogger.nickName }</div>
				<div class="userSign">(${blogger.sign })</div>
			</div>
			-->
			<div class="data_list">
				<div class="data_list_title">
					<img src="${kbms}/static/images/byType_icon.png"/>
					文章类别Top5
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="articleType" items="${articleTypeTop5List }">
							<li><span><a href="${kbms}/index.html?typeId=${articleType.id }">${articleType.typeName }(${articleType.articleCount })</a></span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${kbms}/static/images/byDate_icon.png"/>
					文章日期Top5
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="article" items="${articleTop5List }">
							<li><span><a href="${kbms}/index.html?releaseDateStr=${article.releaseDateStr }">${article.releaseDateStr }(${article.articleCount })</a></span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
			<div class="data_list">
				<div class="data_list_title">
					<img src="${kbms}/static/images/link_icon.png"/>
					友情链接
				</div>
				<div class="datas">
					<ul>
						<c:forEach var="link" items="${linkTop5List }">
							<li><span><a href="${link.linkUrl }" target="_blank">${link.linkName }</a></span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
		</div>
		
		
	</div>
	
	<jsp:include page="/foreground/common/foot.jsp"/>
</div>
</body>
</html>