<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="productModel" method="POST" action="product" >
	<table>
				<tr>
					<td>Product ID:</td>
					<td><form:input path="productid" /></td>
					<td><form:errors path="productid" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Product Name:</td>
					<td><form:input path="productname" /></td>
					<td><form:errors path="productname" cssClass="error" /></td>
				</tr>
				<tr>
				
				<tr>
					<td colspan="3"><input type="submit" value="Submit" /></td>
				</tr>
	</table>
</form:form>



</body>
</html>