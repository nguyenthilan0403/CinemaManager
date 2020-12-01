<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>
	<div align="center">
		<h2>Edit Customer</h2>
		<form:form action="save" method="post" modelAttribute="phim">
			<table border="0" cellpadding="5">
				<tr>
					<td>Ma: </td>
					<td>${phim.ma}
						<form:hidden path="ma"/>
					</td>
				</tr>			
				<tr>
					<td>Ten: </td>
					<td><form:input path="ten" /></td>
				</tr>
				<tr>
					<td>Noidung: </td>
					<td><form:input path="noidung" /></td>
				</tr>
				<tr>
					<td>Anh: </td>
					<td><form:input path="anh" /></td>
				</tr>	
				<tr>
					<td>The loai: </td>
					<td><form:input path="theloai" /></td>
				</tr>		
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>						
			</table>
		</form:form>
	</div>
</body>
</html>