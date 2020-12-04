<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Manager</title>
</head>
<body>
<div align="center">
	<h2>Film Manager</h2>
	<form method="get" action="search">
		<input type="text" name="keyword" /> &nbsp;
		<input type="submit" value="Search" />
	</form>
	<h3><a href="lichchieu/new">New Film</a></h3>

	<form:form action="save" method="post" modelAttribute="lichchieu">
		<table border="0" cellpadding="5">
			<tr>
				<td>Thoigian </td>
				<td><form:input path="thoigian" /></td>
			</tr>
			<tr>
				<td>Phim </td>
				<td>
<%-- 				    <form:select path="phim">
                      <form:options items="${listPhim}" />
                     </form:select>
 --%>                     
 					<select name="maphim">
			          <c:forEach var="phim" items="${listPhim}">
			            <option value="${phim.ma}">${phim.ten}</option>
			          </c:forEach>
			        </select>
				</td>
			</tr>
			<tr>
				<td>Phong </td>
				<td>
<%-- 				    <form:select path="phong">
                      <form:options items="${listPhong}" />
                       </form:select> --%>
                     <select name="maphong">
			          <c:forEach var="phong" items="${listPhong}">
			            <option value="${phong.ma}">${phong.ten}</option>
			          </c:forEach>
			        </select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save"></td>
			</tr>						
		</table>
	</form:form>
</div>	
</body>
</html>