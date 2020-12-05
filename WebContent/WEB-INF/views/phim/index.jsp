<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<div class="container">
	<h2>Quản lý phim</h2>
	
	<form method="get" action="search">
		<input type="text" name="keyword" /> &nbsp;
		<input type="submit" value="Search" />
	</form>
	<a href="phim/new" class="btn btn-primary d-flex flex-row" role="button">Thêm phim mới</a>
	
	<table class="table table-striped">
		<thead>
		<tr>
			<th>Mã</th>
			<th>Tên</th>
			<th>Nội dung</th>
			<th>Ảnh</th>
			<th>Thể loại</th>
			<th>Hành động</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${listPhim}" var="phim">
		<tr>
			<td>${phim.ma}</td>
			<td>${phim.ten}</td>
			<td>${phim.noidung}</td>
			<td>${phim.anh}</td>
			<td>${phim.theloai}</td>
			<td>
				<a href="phim/edit?id=${phim.ma}">Edit</a>
				&nbsp;&nbsp;&nbsp;
				<a href="phim/delete?id=${phim.ma}">Delete</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>	