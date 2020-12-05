<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<div align="center">
	<h2>Thêm lịch chiếu</h2>
	<form method="get" action="search">
		<input type="text" name="keyword" /> &nbsp;
		<input type="submit" value="Search" />
	</form>
	<h3><a href="lichchieu/new">Tạo lịch chiếu mới</a></h3>

	<form:form action="save" method="post" modelAttribute="lichchieu">
		<table class="table table-striped">
		<tbody>
			<tr>
				<td>Ngày chiếu</td>
				<td><input type="date" name="ngaychieu"></td>
<%-- 				<td><form:input path="giochieu" /></td> --%>
			</tr>
			<tr>
				<td>Giờ chiếu</td>
				<td><input type="time" name="giochieu"></td>
<%-- 				<td><form:input path="giochieu" /></td> --%>
			</tr>
			<tr>
				<td>Phim </td>
				<td>
 					<select name="maphim">
			          <c:forEach var="phim" items="${listPhim}">
			            <option value="${phim.ma}">${phim.ten}</option>
			          </c:forEach>
			        </select>
				</td>
			</tr>
			<tr>
				<td>Phòng </td>
				<td>
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
		</tbody>				
		</table>
	</form:form>
</div>	