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
<link rel="stylesheet" href="${kbms}/static/dtree/dtree.css">
<script src="${kbms}/static/dtree/dtree.js"></script>

</head>
<body>
<div class="container">
	<jsp:include page="/foreground/common/head.jsp"/>
	
	<jsp:include page="/foreground/common/menu.jsp"/>
	
	<div class="row">
		<div class="col-md-3">
			<div class="data_list">
				<div class="data_list_title">
					<img src="${kbms}/static/images/byType_icon.png"/>
					知识文库
				</div>
				<div>
					<script type="text/javascript">
						tree = new dTree("tree");
						tree.add(1, -1, "", "");
						
						tree.add(101, 1, "日常工作", "", "", "", "plus", "minus");
						
				    	tree.add(10101, 101, "运维工作", "", "", "", "plus", "minus");
				    	
				    	tree.add(1010101, 10101, "基础运维", "${kbms}/wenku/list.html?typeId=12", "", "", "plus");
				    	tree.add(1010102, 10101, "重要信息系统运维", "${kbms}/wenku/list.html?typeId=40", "", "", "plus");
				    	tree.add(1010103, 10101, "实时同步数据监控", "${kbms}/wenku/list.html?typeId=14", "", "", "plus");
				    	tree.add(1010104, 10101, "数据库管理", "${kbms}/wenku/list.html?typeId=15", "", "", "plus");
				    	tree.add(1010105, 10101, "服务器管理", "${kbms}/wenku/list.html?typeId=16", "", "", "plus");
				    	tree.add(1010106, 10101, "虚拟化平台管理", "${kbms}/wenku/list.html?typeId=17", "", "", "plus");
				    	tree.add(1010107, 10101, "DNS管理", "${kbms}/wenku/list.html?typeId=18", "", "", "plus");
				    	tree.add(1010108, 10101, "互联网站（网上办事大厅）", "${kbms}/wenku/list.html?typeId=19", "", "", "plus");
				    	
				    	tree.add(10103, 101, "基础工作", "", "", "", "plus", "minus");
				    	
				    	tree.add(1010301, 10103, "机房管理", "${kbms}/wenku/list.html?typeId=28", "", "", "plus");
				    	tree.add(1010302, 10103, "系统文档管理", "${kbms}/wenku/list.html?typeId=29", "", "", "plus");
				    	tree.add(1010303, 10103, "固定资产管理", "${kbms}/wenku/list.html?typeId=30", "", "", "plus");
				    	
				    	tree.add(10104, 101, "网络管理", "", "", "", "plus", "minus");
				    	
				    	tree.add(1010401, 10104, "公安信息专网", "${kbms}/wenku/list.html?typeId=20", "", "", "plus");
				    	tree.add(1010402, 10104, "内外网接入平台", "${kbms}/wenku/list.html?typeId=21", "", "", "plus");
				    	tree.add(1010403, 10104, "党政内网管理", "${kbms}/wenku/list.html?typeId=22", "", "", "plus");
				    	tree.add(1010404, 10104, "党政外网管理", "${kbms}/wenku/list.html?typeId=23", "", "", "plus");
				    	
				    	tree.add(10105, 101, "安全管理", "", "", "", "plus", "minus");
				    	
				    	tree.add(1010501, 10105, "一机两用管理", "${kbms}/wenku/list.html?typeId=24", "", "", "plus");
				    	tree.add(1010502, 10105, "杀毒软件、移动存储介质管理", "${kbms}/wenku/list.html?typeId=25", "", "", "plus");
				    	tree.add(1010503, 10105, "数字证书管理", "${kbms}/wenku/list.html?typeId=26", "", "", "plus");
				    	tree.add(1010504, 10105, "信息系统共享查询核实工作", "${kbms}/wenku/list.html?typeId=27", "", "", "plus");
				    	
				    	tree.add(10102, 101, "软件开发", "", "", "", "plus", "minus");
				    	
						tree.add(102, 1, "立项工作", "", "", "", "plus", "minus");
						
						tree.add(10201, 102, "2018立项工作", "", "", "", "plus", "minus");
						
						tree.add(1020101, 10201, "数据中心项目", "${kbms}/wenku/list.html?typeId=32", "", "", "plus");
						tree.add(1020102, 10201, "移动警务项目", "${kbms}/wenku/list.html?typeId=33", "", "", "plus");
						tree.add(1020103, 10201, "建用机制项目", "${kbms}/wenku/list.html?typeId=34", "", "", "plus");
						tree.add(1020104, 10201, "信息化应用竞赛", "${kbms}/wenku/list.html?typeId=35", "", "", "plus");
						tree.add(1020105, 10201, "重点人员管控", "${kbms}/wenku/list.html?typeId=36", "", "", "plus");
						tree.add(1020106, 10201, "最多跑一次", "${kbms}/wenku/list.html?typeId=37", "", "", "plus");
						
						document.write(tree);
					</script>
				</div>
			</div>
			
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
		
		<div class="col-md-9">
			<jsp:include page="${mainPage }"></jsp:include>
		</div>
	</div>
	
	<jsp:include page="/foreground/common/foot.jsp"/>
</div>
</body>
</html>