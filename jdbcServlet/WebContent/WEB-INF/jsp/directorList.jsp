<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>監督情報一覧</title>
</head>
<body>
	<h1>監督情報一覧</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>監督名</th>
			<th>誕生日</th>
		</tr>
		<c:forEach items="${directorList}" var="director">
			<tr>
				<td><c:out value="${director.id}" /></td>
				<td><c:out value="${director.name}" /></td>
				<td><fmt:formatDate value="${director.birth}" pattern="yyyy年MM月dd日" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

