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
						<th>대여자</th>
						<th>대여일</th>
						<th>반납일</th>
					</tr>
					<c:forEach items="${rents.content }" var="rent" varStatus="status">
					<tr>
						<td>${(rents.totalElements - (rents.number * elementSize)) - status.index }</td>
						<td>${rent.item.title }</td>
						<td>${rent.item.category.name }(${rent.item.category.subName })</td>
						<td>${rent.user.name }</td>
						<td>${rent.rentDate }</td>
						<td>${rent.returnDate }</td>
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
							<c:when test="${i eq rents.number }">
								<li class="selected">${i+1 }</li>
							</c:when>
							<c:when test="${i lt rents.totalPages }">
								<li><a href="${pageContext.servletContext.contextPath }/admin?page=${i}">${i +1}</a></li>
							</c:when>
							<c:otherwise>
								<li>${i +1 }</li>
							</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${endPage ne rents.totalPages }">
							<li><a href="${pageContext.servletContext.contextPath }/admin?page=${endPage}">▶</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<c:import url="/WEB-INF/views/admin/include/navigation.jsp">
				<c:param name="menu" value="main" />
			</c:import>
		</div>
	</div>
</body>
</html>