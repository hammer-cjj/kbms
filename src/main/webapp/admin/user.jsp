<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户权限管理页面</title>
<%@ include file="common/head.jspf" %>
<script type="text/javascript">

	var url;
	var tempHtml;
	
	//打开添加用户权限对话框
	function openUserRoleDialog(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		 }
		 var row=selectedRows[0];
		 $.ajax({
		 	type:"post",
		 	data:{"id":row.id},
		 	url:"${kbms}/admin/user/getRoles.do",
		 	success:function(data){
		 		if (data.success) {
		 			tempHtml = "<tr>";
		 			data.articleTyleList.map(function(item,index){
		 				if ((index+1)%2 != 0) {
		 					tempHtml += "<td><input name='roles' type='checkbox' value='"+item.id+"'"; 
		 					if (data.roles.indexOf(item.id) >= 0) {
		 						tempHtml += "checked /></td>";
		 					} else {
		 						tempHtml += "/></td>";
		 					}
		 					tempHtml += "<td>"+item.typeName+"</td>";
		 				}
		 				if ((index+1)%2 == 0) {
		 					tempHtml += "<td><input name='roles' type='checkbox' value='"+item.id+"'";
		 					if (data.roles.indexOf(item.id) >= 0) {
		 						tempHtml += "checked /></td>";
		 					} else {
		 						tempHtml += "/></td>";
		 					}
		 					tempHtml += "<td>"+item.typeName+"</td></tr><tr>";
		 				}
		 			});
		 			tempHtml += "</tr>";
		 			$("#role").empty();
					$("#role").append(tempHtml);
					$("#dlg").dialog("open").dialog("setTitle","添加用户权限");
					$("#fm").form("load",row);
		 		}
		 	}
		 });
		 
		 url="${kbms}/admin/user/saveRoles.do?id="+row.id;
	 }
	
	//保存用户权限
	function saveUserRole(){
		 $("#fm").form("submit",{
			url:url,
			/* onSubmit:function(){
				return $(this).form("validate");
			}, */
			success:function(data){
				// change the JSON string to javascript object
				var data=eval('('+data+')');
				if(data.success){
					$.messager.alert("系统提示","保存成功！");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}else{
					$.messager.alert("系统提示","保存失败！");
					return;
				}
			}
		 });
	 }
	 
	function resetValue(){
		 $("#role").empty();
	 }
	
	 function closeUserRoleDialog(){
		 $("#dlg").dialog("close");
		 resetValue();
	 }
	 
	 
</script>
</head>
<body style="margin: 1px">
<table id="dg" title="用户权限管理" class="easyui-datagrid"
   fitColumns="true" pagination="true" pageList="[10,20]" pageSize="10"  rownumbers="true"
   url="${kbms}/admin/user/list.do" fit="true" toolbar="#tb">
   <thead>
   	<tr>
   		<th field="cb" checkbox="true" align="center"></th>
   		<th field="id" width="50"  align="center">ID编号</th>
   		<th field="userName" width="50"   align="center">用户名称</th>
   		<th field=password width="50"  align="center">用户密码</th>
   	</tr>
   </thead>
 </table>
 <div id="tb">
 	<div>
 	    <!-- <a href="javascript:openArticleTypeAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a> -->
 		<a href="javascript:openUserRoleDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加权限</a>
 	</div>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
 </div>
 
 
 <div id="dlg" class="easyui-dialog" style="width:500px;height:400px;padding: 10px 20px"
   closed="true" buttons="#dlg-buttons">
   
   <form id="fm" method="post">
   	<table cellspacing="8px" id="role">
   	<%-- 
   	<tr>
   	<c:forEach var="articleType" items="${articleTypeList }" varStatus="status">
		<c:if test="${status.count%2 != 0 }">
			<td><input type="checkbox" value="${articleType.id }" <c:if test="${fn:contains(roles,articleType.id)}">checked</c:if> /></td>
			<td>${articleType.typeName }</td>
		</c:if>
		<c:if test="${status.count%2 == 0 }">
			<td><input type="checkbox" value="${articleType.id }" <c:if test="${fn:contains(roles,articleType.id)}">checked</c:if> /></td>
			<td>${articleType.typeName }</td>
			</tr><tr>
		</c:if>
	</c:forEach>
   	</tr>	
   	 --%>
   	</table>
   </form>
 </div>
 
 <div id="dlg-buttons">
 	<a href="javascript:saveUserRole()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
 	<a href="javascript:closeUserRoleDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
 </div>
</body>
</html>