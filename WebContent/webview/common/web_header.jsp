<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/openresource/aui/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/openresource/aui/css/homelogin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web_css/web_head.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web_css/amazeui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web_css/style.css">
<script src="${pageContext.request.contextPath}/static/js/web_js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/web_js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/web_js/scroll.js"></script>
<title>先锋人力资源</title>
  <style type="text/css">
       
  </style>
  
</head>
<body>
	<header class="am-topbar header">
	<div class="am-container-1">
		<div class="left hw-logo" style="padding-top: 15px;margin-left:50px;">
		  <img class="logo" src="${pageContext.request.contextPath}/static/images/conlogo.png" style="">
    </div>
 	 <div class="am-collapse am-topbar-collapse right" id="doc-topbar-collapse">
    <div class=" am-topbar-left am-form-inline am-topbar-right" role="search">
      <ul class="am-nav am-nav-pills am-topbar-nav hw-menu">
     		 <li><a href="${pageContext.request.contextPath}/webview/web_index.jsp">首页</a></li>
         	<li><a href="${pageContext.request.contextPath}/webview/web_aboutUs/web_aboutUs.jsp">公司介绍</a></li>
      		<li><a href="${pageContext.request.contextPath}/newsInfoByNewstypeOfFront.action?news_type=NEWS">公司动态</a></li>
        	<li><a href="${pageContext.request.contextPath}/newsInfoByNewstypeOfFront.action?news_type=PROJECT">项目工程</a></li>
        	<li><a href="${pageContext.request.contextPath}/newsInfoByNewstypeOfFront.action?news_type=CASE">成功案例</a></li>
        	<li><a href="${pageContext.request.contextPath}/newsInfoByNewstypeOfFront.action?news_type=ERPINFO">名企招聘</a></li>
        	<li><a href="${pageContext.request.contextPath}/queryBasicInfoForeground.action">报名及联系方式</a></li> 
        	<li style="margin-left:30px;"><a href="${pageContext.request.contextPath}/webview/web_login.jsp">登录</a></li>
    </ul>
    </div>
  </div>
  </div>
</header>
</body>
</html>