<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web_css/amazeui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/web_css/style.css">
<script src="${pageContext.request.contextPath}/static/js/web_js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/web_js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/web_js/scroll.js"></script>
</head>
<body>
	<div class="layui-row">
		<div class="layui-col-xs12">
			<div class="grid-demo grid-demo-bg1">
				<table>
					<!-- 分页 -->
					<c:if test="${pageBean.list.size()!=0}">
						<tr align="center" height="30" class="STYLE1">
							<td colspan="10">共<c:out value="${pageBean.allRow}"></c:out>条数据
								&nbsp;分成<c:out value="${pageBean.totalPage}"></c:out>页 &nbsp;当前第<c:out
									value="${pageBean.currentPage}"></c:out>页 <c:if
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
								</c:if> <%-- <input name="page" id="page" type="text" size="3"  style="width:60px;height:20px;" value="${pageBean.currentPage}" /> --%>
								跳转到第 <input name="pageNum" id="pageNum" type="text" size="3"
								value="${pageNum}" style="width: 60px; height: 20px;"
								onblur="pageSwitch()" /> 页 <%-- <input type="button" name="chaxun" class="btn" style="width:60px;height:32px;" onclick="pagination(${pageBean.totalPage})" value="GO"> --%>
							</td>
						</tr>
					</c:if>
				</table>
			</div>
		</div>
	</div>
</body>
</html>