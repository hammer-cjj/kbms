<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章管理页面</title>
<%@include file="./common/head.jspf" %>

<script type="text/javascript">

	function formatUser(val, row) {
		return val.userName;
	}

	function formatArticleType(val,row){
		return val.typeName;
	}
	
	function formatTitle(val,row){
		return "<a target='_blank' href='${kbms}/article/articles/"+row.id+".html'>"+val+"</a>";
	}
	
	//按照文章标题搜索
	function searchArticle(){
		$("#dg").datagrid('load',{
			"title":$("#s_title").val() 
		});
	}
	
	//重载页面
	function reloadArticle() {
		$("#dg").datagrid("reload");
	}
	
	//删除文章
	function deleteArticle(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length==0){
			 $.messager.alert("系统提示","请选择要删除的数据！");
			 return;
		 }
		 var strIds=[];
		 for(var i=0;i<selectedRows.length;i++){
			 strIds.push(selectedRows[i].id);
		 }
		 var ids=strIds.join(",");
		 $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
				if(r){
					$.post("${kbms}/admin/article/delete.do",{ids:ids},function(result){
						if(result.success){
							 $.messager.alert("系统提示","数据已成功删除！");
							 $("#dg").datagrid("reload");
						}else{
							$.messager.alert("系统提示","数据删除失败！");
						}
					},"json");
				} 
	   });
	}
	
	//更新文章
	function openArticleModifyTab(){
		 var selectedRows=$("#dg").datagrid("getSelections");
		 if(selectedRows.length!=1){
			 $.messager.alert("系统提示","请选择一个要修改的文章！");
			 return;
		 }
		 var row=selectedRows[0];
		 window.parent.openTab('修改文章','modifyArticle.jsp?id='+row.id,'icon-writeblog');
	}
	
</script>
</head>
<body style="margin: 1px">
<table id="dg" title="文章管理" class="easyui-datagrid" fitColumns="true" 
   pagination="true" pageList="[10,20]" pageSize="10" rownumbers="true"
   url="${kbms}/admin/article/list.do" fit="true" toolbar="#tb">
   <thead>
   	<tr>
   		<th field="cb" checkbox="true" align="center"></th>
   		<th field="id" width="20" align="center">编号</th>
   		<th field="title" width="100" align="center" formatter="formatTitle">标题</th>
   		<th field="releaseDate" width="50" align="center">发布日期</th>
   		<th field="articleType" width="50" align="center" formatter="formatArticleType">文章类别</th>
   		<th field="user" width="50" align="center" formatter="formatUser" >作者</th>
   	</tr>
   </thead>
 </table>
 <div id="tb">
 	<div>
 		<a href="javascript:openArticleModifyTab()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
 		<a href="javascript:deleteArticle()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
 		<a href="javascript:reloadArticle()" class="easyui-linkbutton" iconCls="icon-reload" plain="true">刷新</a>
 	</div>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
 	<div>
 		&nbsp;标题：&nbsp;<input type="text" id="s_title" size="20" onkeydown="if(event.keyCode==13) searchBlog()"/>
 		<a href="javascript:searchArticle()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
 	</div>
 </div>
</body>
</html>