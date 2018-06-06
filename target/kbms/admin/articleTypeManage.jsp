<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章类别管理页面</title>
<%@ include file="common/head.jspf" %>
<script type="text/javascript">

	var url;

	//删除文章类型
	function deleteArticleType(){
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
					$.post("${kbms}/admin/articleType/delete.do",{ids:ids},function(data){
						if(data.success){
							if(data.exist){
								 $.messager.alert("系统提示",data.exist);
							}else{
								 $.messager.alert("系统提示","数据已成功删除！");								
							}
							 $("#dg").datagrid("reload");
						}else{
							$.messager.alert("系统提示","数据删除失败！");
						}
					},"json");
				} 
	   });
	}
	
	//打开添加文章类别信息对话框
	function openArticleTypeAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加文章类别信息");
		url="${kbms}/admin/articleType/save.do";
	}
	
	//打开添加文章子类别信息对话框
	function openArticleTypeChildrenAddDialog(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条数据！");
			return;
		 }
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","添加文章子类别信息");
		url="${kbms}/admin/articleType/save.do?parentId="+row.id;
	}
	
	//打开更新文章类别对话框
	function openArticleTypeModifyDialog(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		 }
		 var row=selectedRows[0];
		 $("#dlg").dialog("open").dialog("setTitle","编辑文章类别信息");
		 $("#fm").form("load",row);
		 url="${kbms}/admin/articleType/save.do?id="+row.id;
	 }
	
	//保存文章类别
	function saveArticleType(){
		 $("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
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
		 $("#typeName").val("");
		 $("#orderNo").val("");
	 }
	
	 function closeArticleTypeDialog(){
		 $("#dlg").dialog("close");
		 resetValue();
	 }
	 
	 
</script>
</head>
<body style="margin: 1px">
<table id="dg" title="文章类别管理" class="easyui-datagrid"
   fitColumns="true" pagination="true" pageList="[10,20]" pageSize="10"  rownumbers="true"
   url="${kbms}/admin/articleType/list.do" fit="true" toolbar="#tb">
   <thead>
   	<tr>
   		<th field="cb" checkbox="true" align="center"></th>
   		<th field="id" width="20"  align="center">ID编号</th>
   		<th field="typeName" width="50"   align="center">文章类型名称</th>
   		<th field="orderNo" width="50"  align="center">排序序号</th>
   		<th field="level" width="50"  align="center">层级(0,1,2)</th>
   		<th field="parentId" width="50"  align="center">上级类型</th>
   	</tr>
   </thead>
 </table>
 <div id="tb">
 	<div>
 	    <a href="javascript:openArticleTypeAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
 		<a href="javascript:openArticleTypeModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
 		<a href="javascript:deleteArticleType()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
 		<a href="javascript:openArticleTypeChildrenAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加子类</a>
 	</div>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
 </div>
 
 
 <div id="dlg" class="easyui-dialog" style="width:500px;height:180px;padding: 10px 20px"
   closed="true" buttons="#dlg-buttons">
   
   <form id="fm" method="post">
   	<table cellspacing="8px">
   		<tr>
   			<td>文章类别名称：</td>
   			<td><input type="text" id="typeName" name="typeName" class="easyui-validatebox" required="true"/></td>
   		</tr>
   		<tr>
   			<td>文章类别排序：</td>
   			<td><input type="text" id="orderNo" name="orderNo" class="easyui-numberbox" required="true" style="width: 60px"/>&nbsp;(类别根据排序序号从小到大排序)</td>
   		</tr>
   	</table>
   </form>
 </div>
 
 <div id="dlg-buttons">
 	<a href="javascript:saveArticleType()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
 	<a href="javascript:closeArticleTypeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
 </div>
</body>
</html>