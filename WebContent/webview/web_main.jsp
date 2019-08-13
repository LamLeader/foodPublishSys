<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>吃货天堂后台管理系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/openresource/layui/css/layui.css">
 	<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/images/web_icon.png"/>
  	<script src="${pageContext.request.contextPath}/openresource/layui/layui.js"></script>
</head>
<body>
	<!-- 引入LayUI框架 -->
	<!-- 内容区域 -->
	<div class="layui-layout layui-layout-admin">
	  <div class="layui-header">
	    <div class="layui-logo">吃货天堂后台管理系统</div>
	    <!-- 头部区域（可配合layui已有的水平导航） -->
	   <%--  <ul class="layui-nav layui-layout-left">
	      <li class="layui-nav-item">
	        <img src="${pageContext.request.contextPath}/static/images/web_icon.png" class="layui-nav-img" >
	      </li>
	    </ul> --%>
	    <ul class="layui-nav layui-layout-right">
	      <li class="layui-nav-item">
	        <a href="javascript:;">
	          <img src="${pageContext.request.contextPath}/static/images/community_icon.png" class="layui-nav-img">
	        </a>
	        <dl class="layui-nav-child">
	          
	        </dl>
	      </li>
	      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/exitLogin.do">退出</a></li>
	    </ul>
	  </div>
	  
	  <div class="layui-side layui-bg-green" id="left_tree">
	    <div class="layui-side-scroll">
	      <!-- 左侧导航区域（可配合已有的垂直导航） -->
	       <c:if test="${type=='用户'}">
		      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
		        <li class="layui-nav-item">
		          <a href="javascript:;"><img src="${pageContext.request.contextPath}/static/images/web_icon.png" class="layui-nav-img">系统管理</a>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/queryUserInfoByName.do" target="mainFrame">我的信息</a></dd>
		          </dl>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/queryPublishInfo.do?pub_type=1" target="mainFrame">我的美食发布</a></dd>
		          </dl>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/queryPublishInfo.do?pub_type=2" target="mainFrame">我的美食圈发布</a></dd>
		          </dl>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/queryPublishInfo.do?pub_type=3" target="mainFrame">我的美食小知识</a></dd>
		          </dl>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/querySingnByUserName.do?type=2" target="mainFrame">我的签到</a></dd>
		          </dl>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/initIndex.do" target="mainFrame">美食兑换</a></dd>
		          </dl>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/queryOrderInfoByUserName.do?type=2" target="mainFrame">我的兑换订单</a></dd>
		          </dl>
		        </li>
		      </ul>
		    </c:if>
		    <c:if test="${type=='管理员'}">
		      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
		        <li class="layui-nav-item">
		          <a href="javascript:;"><img src="${pageContext.request.contextPath}/static/images/web_icon.png" class="layui-nav-img">系统管理</a>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/queryUserInfoByName.do" target="mainFrame">用户管理</a></dd>
		          </dl>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/queryPublishInfo.do?pub_type=1" target="mainFrame">美食发布管理</a></dd>
		          </dl>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/queryPublishInfo.do?pub_type=2" target="mainFrame">美食圈发布管理</a></dd>
		          </dl>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/queryPublishInfo.do?pub_type=3" target="mainFrame">美食小知识管理</a></dd>
		          </dl>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/querySingnByUserName.do?type=1" target="mainFrame">签到管理</a></dd>
		          </dl>
		          <dl class="layui-nav-child">
		             <dd><a href="${pageContext.request.contextPath}/queryOrderInfoByUserName.do?type=1" target="mainFrame">兑换订单查看</a></dd>
		          </dl>
		        </li>
		      </ul>
		   </c:if>
	    </div>
	  </div>
	  
	  <div class="layui-body" >
	  	<ul class="layui-tab-title site-demo-title">
	  		<li>
	  			<!-- <div >style="overflow: hidden;"
					<div class="layui-inline">
					   <input class="layui-input"  style="width: 300px;" height="10px;">
					</div>
				 	<div class="layui-inline">
					   <button class="layui-btn layui-btn-radius" style="padding-left: 30px;padding-right: 30px;">搜索</button>
					</div>
				</div> -->
	  		</li>
	    </ul>
	    <!-- 内容主体区域 -->
	    <!---->
	    <iframe src="${pageContext.request.contextPath}/queryUserInfoByName.do"  frameborder="0" name="mainFrame" id="mainFrame" style="width: 100%; height: 100%;"></iframe> 
	  </div>
	  
	  <div class="layui-footer">
	    <!-- 底部固定区域 -->
	    © 欢迎访问
	    
	  </div>
	</div>
</body>
<script>
	//JavaScript代码区域
	layui.use('element', function(){
	  var element = layui.element;
	  
	});
	
	
</script>

</html>