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
						<th>대여일</th>
						<th>반납일</th>
					</tr>
					<tr>
						<td>5</td>
						<td>세상의 중심에서 사랑을 외친 짐승</td>
						<td>도서(소설)</td>
						<td>2018년 5월 2일</td>
						<td>2018년 5월 9일</td>
					</tr>
					<tr>
						<td>4</td>
						<td>AC/DC: Fly On The Wall</td>
						<td>음반(락)</td>
						<td>2018년 5월 2일</td>
						<td>2018년 5월 9일</td>
					</tr>						
					<tr>
						<td>3</td>
						<td>Java의 정석 [3판]</td>
						<td>도서(IT)</td>
						<td>2018년 5월 2일</td>
						<td>2018년 5월 9일</td>
					</tr>
					<tr>
						<td>2</td>
						<td>파리로 가는 길</td>
						<td>DVD(영화-드라마)</td>
						<td>2018년 5월 2일</td>
						<td>2018년 5월 9일</td>
					</tr>				
					<tr>
						<td>1</td>
						<td>브루크너: 교향곡 7번</td>
						<td>음반(클래식)</td>
						<td>2018년 5월 2일</td>
						<td>2018년 5월 9일</td>
					</tr>				
				</table>
				<div class="pager">
					<ul>
						<li><a href="${pageContext.servletContext.contextPath }/rent">◀</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/rent">6</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/rent">7</a></li>
						<li class="selected">8</li>
						<li>9</li>
						<li>10</li>
						<li>▶</li>
					</ul>
				</div>
			</div>
			<c:import url="/WEB-INF/views/admin/include/navigation.jsp" />
		</div>
	</div>
</body>
</html>