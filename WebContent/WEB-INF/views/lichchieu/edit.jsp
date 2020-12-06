<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<div align="center">
	<h2>Sửa thông tin lịch chiếu</h2>
		<form:form action="save" method="post" modelAttribute="lichchieu">
		<table class="table table-striped">
		<tbody>
			<tr>
				<td>Mã: </td>
				<td>${lichchieu.ma}
					<form:hidden path="ma"/>
				</td>
			</tr>	
			<tr>
				<td>Ngày chiếu</td>
				<td><input type="date" name="ngaychieu" value="${lichchieu.ngaychieu}"></td>
			</tr>
			<tr>
				<td>Giờ chiếu</td>
				<td><input type="time" name="giochieu" value="${lichchieu.giochieu}" ></td>
<%-- 				<td><form:input path="giochieu" /></td> --%>
			</tr>
			<tr>
				<td>Phim</td>
				<td>
 					<select name="maphim">
			          <c:forEach var="phim" items="${listPhim}">
			            <option value="${phim.ma}" 
			            	<c:if test="${phim.ma eq selectedPhimId}">selected="selected"</c:if>>
			            	${phim.ten}
			            </option>
			          </c:forEach>
			        </select>
				</td>
			</tr>
			<tr>
				<td>Phòng</td>
				<td>
 					<select name="maphong">
			          <c:forEach var="phong" items="${listPhong}">
			            <option value="${phong.ma}" 
			            	<c:if test="${phong.ma eq selectedPhongId}">selected="selected"</c:if>>
			            	${phong.ten}
			            </option>
			          </c:forEach>
			        </select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="btn btn-primary" value="Lưu"></td>
			</tr>		
		</tbody>				
		</table>
	</form:form>
</div>