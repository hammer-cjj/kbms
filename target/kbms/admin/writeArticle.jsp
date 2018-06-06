<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>写文章页面</title>
<%@include file="./common/head.jspf" %>
<script type="text/javascript" charset="utf-8" src="${kbms}/static/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${kbms}/static/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="${kbms}/static/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">

	// 重置数据
	function resetValue(){
		$("#title").val("");
		$("#articleTypeId").combobox("setValue","");
		UE.getEditor('editor').setContent("");
		$("#keyWord").val("");
	}
	
	function submitData(){
		var title=$("#title").val();
		var articleTypeId=$("#articleTypeId").combobox("getValue");
		var content=UE.getEditor('editor').getContent();
		var keyWord=$("#keyWord").val();
		
		if(title==null || title==''){
			alert("请输入标题！");
		}else if(articleTypeId==null || articleTypeId==''){
			alert("请选择文章类别！");
		}else if(content==null || content==''){
			alert("请输入内容！");
		}else{
			$.post("${kbms}/admin/article/save.do",{'title':title,'articleType.id':articleTypeId,'content':content,'contentNoTag':UE.getEditor('editor').getContentTxt(),'summary':UE.getEditor('editor').getContentTxt().substr(0,155),'keyWord':keyWord},function(result){
				if(result.success){
					alert("文章发布成功！");
					resetValue();
				}else{
					alert("文章发布失败！");
				}
			},"json");
		}
	}
	
</script>
</head>
<body style="margin: 10px">
<div id="p" class="easyui-panel" title="编写文章" style="padding: 10px">
 	<table cellspacing="20px">
   		<tr>
   			<td width="80px">文章标题：</td>
   			<td><input type="text" id="title" name="title" style="width: 400px;"/></td>
   		</tr>
   		<tr>
   			<td>所属类别：</td>
   			<td>
   				<select class="easyui-combobox" style="width: 154px" id="articleTypeId" name="articleType.id" editable="false" panelHeight="auto" >
					<option value="">请选择文章类别...</option>	
				    <c:forEach var="articleType" items="${articleTypeList }">
				    	<option value="${articleType.id }">${articleType.typeName }</option>
				    </c:forEach>			
                </select>
   			</td>
   		</tr>
   		<tr>
   			<td valign="top">文章内容：</td>
   			<td>
				   <script id="editor" type="text/plain" style="width:100%;height:500px;"></script>
   			</td>
   		</tr>
   		<tr>
   			<td>关键字：</td>
   			<td><input type="text" id="keyWord" name="keyWord" style="width: 400px;"/>&nbsp;(多个关键字中间用空格隔开)</td>
   		</tr>
   		<tr>
   			<td></td>
   			<td>
   				<a href="javascript:submitData()" class="easyui-linkbutton" data-options="iconCls:'icon-submit'">发布文章</a>
   			</td>
   		</tr>
   	</table>
 </div>
 
 <script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
	UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;    
	UE.Editor.prototype.getActionUrl = function(action) {    
	    if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadvideo' || action == 'uploadfile') {    
	        return '/kbms/uploadImage.do';    
	    } else {    
	        return this._bkGetActionUrl.call(this, action);    
	    }    
	} 

</script>
</body>
</html>