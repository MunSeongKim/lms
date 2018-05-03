<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>lms</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/admin/rent.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/admin/include/header.jsp" />
		<div id="wrapper">
			<div id="content">
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>타이틀</th>
						<th>카테고리</th>
						<th>예약자</th>
						<th>순번</th>
					</tr>
					<c:forEach items="${reserves.content }" var="reserve" varStatus="status">
					<tr>
						<td>${(reserves.totalElements - (reserves.number * elementSize)) - status.index }</td>
						<td>${reserve.item.title }</td>
						<td>${reserve.item.category.name }(${reserve.item.category.subName })</td>
						<td>${reserve.user.name }</td>
						<td>${reserve.priority }</td>
					</tr>
					</c:forEach>
				</table>
				<div class="pager">
					<ul>
						<c:if test="${ (startPage / pageSize) gt 0 }">
							<li><a href="${pageContext.servletContext.contextPath }/admin?page=${startPage-1}">◀</a></li>
						</c:if>
						<c:forEach begin="${startPage}" end="${endPage-1 }" var="i" step="1">
							<c:choose>
							<c:when test="${i eq reserves.number }">
								<li class="selected">${i+1 }</li>
							</c:when>
							<c:when test="${i lt reserves.totalPages }">
								<li><a href="${pageContext.servletContext.contextPath }/admin?page=${i}">${i +1}</a></li>
							</c:when>
							<c:otherwise>
								<li>${i +1 }</li>
							</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${endPage ne reserves.totalPages }">
							<li><a href="${pageContext.servletContext.contextPath }/admin?page=${endPage}">▶</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<c:import url="/WEB-INF/views/admin/include/navigation.jsp">
				<c:param name="menu" value="reserve" />
			</c:import>
		</div>
	</div>
</body>
</html>