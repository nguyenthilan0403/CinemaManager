<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<div align="center">
	<h2>Thông tin hóa đơn</h2>
	<table class="table table-striped">
		<tbody>
			<tr>
				<td>Mã </td>
				<td>${hoadon.ma}</td>
			</tr>			
			<tr>
				<td>Phim</td>
				<td>${hoadon.lichchieu.phim.ten}</td>
			</tr>	
			<tr>
				<td>Thời gian</td>
				<td><b>${hoadon.lichchieu.ngaychieu} - ${hoadon.lichchieu.giochieu}</b></td>
			</tr>
			<tr>
				<td>Vé</td>
				<td>
				<c:forEach items="${listVe}" var="ve">  
					<div>Ghế ngồi: <b>${ve.ghe.ten }</b></div>
				</c:forEach>
				</td>
			</tr>
			
			
		</tbody>			
	</table>
</div>