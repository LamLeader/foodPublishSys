<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>
<meta name="description" content="">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="apple-mobile-web-app-title" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/openresource/AmazeUI-2.7.2/assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/openresource/AmazeUI-2.7.2/assets/css/admin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/openresource/layui/css/layui.css">
<script src="${pageContext.request.contextPath}/static/js/web_js/jquery.min.js"></script>

<script type="text/javascript">
     //分页
    function pagination(page){
    var pub_title=$("#pub_title").val();
    var userName=$("#userName").val();
	window.location.href="${pageContext.request.contextPath}/queryPublishInfo.do?pageNum="+page+"&pub_title="+pub_title+"&userName="+userName;
	 }
	 //分页=》跳转到哪一个
    function pageSwitch(){
    var validateNum= /^[0-9]*$/;
    var pageNum=$("#pageNum").val();
    if(pageNum==""){
    	return false;
    }
    if(!validateNum.test(pageNum)){
    	alert("页码只能输入数字！！！");
    	document.getElementById("pageNum").value="";//清空输入
    	return;
    }
    var pub_title=$("#pub_title").val();
    var userName=$("#userName").val();
	window.location.href="${pageContext.request.contextPath}/newsInfoByNewstypeMG.action?pageNum="+pageNum+"&pub_title="+pub_title+"&userName="+userName;
	 }
   //美食上传
   function uploadFoods(){
	   
   }
  </script>
</head>
<body>
	<div>

		<div class="listbiaoti am-cf">

			<dl class="am-icon-home">
				当前位置： 首页 >
				<a href="#">美食信息管理</a>
			</dl>
		</div>
         <br/>
         <br/>
         <c:if test="${pub_type==1}">
               <a href="${pageContext.request.contextPath}/openPublishInfoAdd.do" class="layui-btn"  style="margin-left:32px;">美食发布</a>  <br/> <br/>
         </c:if>
         <c:if test="${pub_type==2}">
               <a href="${pageContext.request.contextPath}/openPublishInfoAdd.do" class="layui-btn"  style="margin-left:32px;">美食圈发布</a>  <br/> <br/>
         </c:if>
          <c:if test="${pub_type==3}">
               <a href="${pageContext.request.contextPath}/openPublishInfoAdd.do" class="layui-btn"  style="margin-left:32px;">美食小知识发布</a>  <br/> <br/>
         </c:if>
		<form class="am-form am-g" method="post"  name="form" 
		action="${pageContext.request.contextPath}/queryPublishInfo.do">
		    <div class="layui-form-item" style="margin-left:2%;">
		     <div class="layui-input-inline">
				<input type="text" name="userName" id="userName"
					 placeholder="请输入发布人" autocomplete="off" value="${userName}"
					class="layui-input"  >
					
			 </div>
			 <div class="layui-input-inline">
				<input type="text" name="pub_title" id="pub_title"
					 placeholder="请输入标题" autocomplete="off" value="${pub_title}"
					class="layui-input"   >
			 </div>
			 
			 <div class="layui-input-block" >
			     <input type="submit" class="layui-btn"  value="查询"/>
			 </div>
		   </div>
			<table width="100%"
				class="am-table am-table-bordered am-table-radius am-table-striped">
				<thead>
					<tr class="am-success">
						<th class="table-title">标题</th>
						<!-- <th class="table-title">内容</th> -->
						<th class="table-type">价格</th>
						<th class="table-type">发布人</th>
						<th class="table-type">美食</th>
						<th class="table-type">发布时间</th>
						<th width="130px" class="table-set">操作</th>
					</tr>
				</thead>
				<tbody>
				 <c:forEach items="${pageBean.list}" var="item">
					<tr>
						<td>${item.pub_title}</td>
						<%-- <td>${item.pub_content}</td> --%>
						<td>${item.price}</td>
						<td>${item.userName}</td>
						<td>
						  <img alt="吃货天堂" src="${item.picture}" style="width: 120px;height: 78px;">  
						</td>
						<td>${item.create_date}</td>
						<td>
							<div class="am-btn-toolbar">
								<div class="am-btn-group am-btn-group-xs">
								    <a href="${pageContext.request.contextPath}/getPublishById.do?id=${item.id}" class="am-btn am-btn-default am-btn-xs am-text-danger am-round">
										详情
									</a>
									 <a href="${pageContext.request.contextPath}/deletePublishById.do?id=${item.id}"
						   onclick="javascript:if(!confirm('确认删除该信息吗？'))
			               {return false};"
										class="am-btn am-btn-default am-btn-xs am-text-danger am-round"
										title="删除">
										<span class="am-icon-trash-o"></span>
									</a>
								</div>
							</div>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<div class="layui-row">
			<div class="layui-col-xs12">
				<div class="grid-demo grid-demo-bg1">
					<table>
						<!-- 分页 -->
						<c:if test="${pageBean.list.size()!=0}">
							<tr align="center" height="30" class="STYLE1">
								<td colspan="10">共<c:out value="${pageBean.allRow}"></c:out>条数据
									&nbsp;分成<c:out value="${pageBean.totalPage}"></c:out>页
									&nbsp;当前第<c:out value="${pageBean.currentPage}"></c:out>页 <c:if
										test="${pageBean.currentPage == 1}">
										<font color="#000">首页</font>
									</c:if> <c:if test="${pageBean.currentPage > 1}">
										<a onclick="pagination(1)">首页</a>
									</c:if> <c:if test="${pageBean.currentPage == 1}">
										<font color="#000">上一页</font>
									</c:if> <c:if test="${pageBean.currentPage>1}">
										<a onclick="pagination(${pageBean.currentPage - 1})">上一页</a>
									</c:if> <c:forEach begin="1" end="${pageBean.totalPage}" var="num">
										<c:choose>
											<c:when test="${pageBean.totalPage == num}">
												<font color="#000">${num}</font>
											</c:when>
											<c:otherwise>
												<a onclick="pagination(${num})">${num}</a>
											</c:otherwise>
										</c:choose>
									</c:forEach> <c:if test="${pageBean.currentPage == pageBean.totalPage}">
										<font color="#000">下一页</font>
									</c:if> <c:if test="${pageBean.currentPage < pageBean.totalPage}">
										<a onclick="pagination(${pageBean.currentPage + 1})">下一页</a>
									</c:if> <c:if test="${pageBean.currentPage == pageBean.totalPage}">
										<font color="#000">末页</font>
									</c:if> <c:if test="${pageBean.currentPage < pageBean.totalPage}">
										<a onclick="pagination(${pageBean.totalPage})">末页</a>
									</c:if> 跳转到第 <input name="pageNum" id="pageNum" type="text" size="3"
									value="${pageNum}" style="width: 60px; height: 20px;"
									onblur="pageSwitch()" /> 页
								</td>
							</tr>
						</c:if>
					</table>
					<c:if test="${pageBean.list.size()<=0}">
                                                                                 没有查询到数据！！！
                          <input type="button" onClick="history.go(-1);"
							class="btn" value="返回" />
					</c:if>
				</div>
			</div>
		</div>
	</div>

</body>
</html>