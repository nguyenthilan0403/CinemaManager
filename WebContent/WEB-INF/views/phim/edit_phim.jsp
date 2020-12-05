<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<div align="center">
	<h2>Chỉnh sửa thông tin phim</h2>
	<form:form action="save" method="post" modelAttribute="phim">
		<table class="table table-striped">
		<tbody>
			<tr>
				<td>Mã </td>
				<td>${phim.ma}
					<form:hidden path="ma"/>
				</td>
			</tr>			
			<tr>
				<td>Tên </td>
				<td><form:input path="ten" /></td>
			</tr>
			<tr>
				<td>Nội dung </td>
				<td><form:input path="noidung" /></td>
			</tr>
			<tr>
				<td>Ảnh </td>
				<td><form:input path="anh" /></td>
			</tr>	
			<tr>
				<td>Thể loại: </td>
				<td><
 					<select name="theloai">
			          <c:forEach var="tl" items="${listTheloai}">
			            <option value="${tl}" 
			            	<c:if test="${tl eq selectedTheloai}">selected="selected"</c:if>>
			            	${tl}
			            </option>
			          </c:forEach>
			        </select>
				</td>
			</tr>		
			<tr>
				<td colspan="2"><input type="submit" value="Save"></td>
			</tr>			
		</tbody>			
		</table>
	</form:form>
</div>