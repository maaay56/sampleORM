<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>welcome!</title>
	</head>
	<body>
		<table>
		<form:form modelAttribute="test">
			<tr>
				<td><form:label path="id">ID</form:label></td>
				<td><form:input path="id" value="${test.id}" readonly="true" /></td>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" size="20" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" /></td>
			</tr>
		</form:form>
		</table>
		<hr />
		<c:if test="${datalist != null}">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>
			<c:forEach var="obj" items="${datalist}" varStatus="status">
				<tr>
					<td><c:out value="${obj.id}" /></td>
					<td><c:out value="${obj.name}" /></td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
	</body>
</html>
