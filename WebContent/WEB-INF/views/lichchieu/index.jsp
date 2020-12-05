<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<div align="center">
	<h2>Quản lý lịch chiếu phim</h2>
	<form method="get" action="search">
		<input type="text" name="keyword" /> &nbsp;
		<input type="submit" value="Search" />
	</form>
	<a href="lichchieu/new" class="btn btn-primary" role="button">Tạo lịch chiếu mới</a>
	
	<table class="table table-striped">
		<thead>
		<tr>
			<th>Mã</th>
			<th>Phim</th>
			<th>Ngày chiếu</th>
			<th>Giờ chiếu</th>
			<th>Phòng</th>
			<th>Hành động</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${listLichchieu}" var="lich">
		<tr>
			<td>${lich.ma}</td>
			<td>${lich.phim.ten}</td>
			<td>${lich.ngaychieu}</td>
			<td>${lich.giochieu}</td>
			<td>${lich.phong.ten}</td>
			<td>
				<a href="lichchieu/edit?id=${lich.ma}" class="btn btn-info" role="button">Chỉnh sửa</a>
				<a href="lichchieu/delete?id=${lich.ma}" class="btn btn-danger" role="button">Xóa</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>	