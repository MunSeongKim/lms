<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>LMS</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="${pageContext.request.contextPath }" method="get">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>타이틀</th>
						<th>카테고리</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${items.content }" var="item" varStatus="status">
					<tr>
						<td>${(items.totalElements - (items.number * elementSize)) - status.index }</td>
						<td>${item.title }</td>
						<td>${item.category.name }(${item.category.subName })</td>
						<td>
							<c:choose>
								<c:when test="${item.isRent eq true }">
									<a href="${pageContext.servletContext.contextPath }/rent/${item.no}" class="btn">대여</a>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.servletContext.contextPath }/reserve/${item.no}" class="btn">예약</a>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					</c:forEach>
				</table>
				<div class="pager">
					<ul>
						<c:if test="${ (startPage / pageSize) gt 0 }">
							<li><a href="${pageContext.servletContext.contextPath }?page=${startPage-1}">◀</a></li>
						</c:if>
						<c:forEach begin="${startPage}" end="${endPage-1 }" var="i" step="1">
							<c:choose>
							<c:when test="${i eq items.number }">
								<li class="selected">${i+1 }</li>
							</c:when>
							<c:when test="${i lt items.totalPages }">
								<li><a href="${pageContext.servletContext.contextPath }?page=${i}">${i +1}</a></li>
							</c:when>
							<c:otherwise>
								<li>${i +1 }</li>
							</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${endPage ne items.totalPages }">
							<li><a href="${pageContext.servletContext.contextPath }?page=${endPage}">▶</a></li>
						</c:if>
					</ul>
				</div>				
				<div class="bottom">
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>