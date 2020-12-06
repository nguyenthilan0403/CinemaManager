<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<div align="center">
	<h2>Quản lý lịch chiếu phim</h2>
	
<!-- 	<div class="container"> -->
<!-- 	  <div class="row"> -->
<!-- 	    <div class="col-6"> -->
<!--  			<form method="get" action="search"> --> 
<!--  				<input type="text" name="keyword" /> &nbsp; --> 
<!--  				<input type="submit" value="Search" /> --> 
<!--  			</form> --> 
<!-- 			ehehehe -->
<!-- 		</div> -->
<!-- 	    <div class="col-6"> -->
<!-- 			ehe22hehe21222 -->
<!-- 	    	<a href="lichchieu/new" class="btn btn-primary" role="button">Tạo lịch chiếu mới</a> -->
<!-- 	    </div> -->
<!-- 	  </div> -->
<!-- 	</div> -->
	<a href="lichchieu/new" class="btn btn-primary" role="button">Tạo lịch chiếu mới</a>
	<br/>
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
			<td style="vertical-align:middle;">${lich.ma}</td>
			<td style="vertical-align:middle;">${lich.phim.ten}</td>
			<td style="vertical-align:middle;">${lich.ngaychieu}</td>
			<td style="vertical-align:middle;">${lich.giochieu}</td>
			<td style="vertical-align:middle;">${lich.phong.ten}</td>
			<td>
				<a href="lichchieu/edit?id=${lich.ma}" class="btn btn-info" role="button">Chỉnh sửa</a>
				<a href="lichchieu/delete?id=${lich.ma}" class="btn btn-danger" role="button">Xóa</a>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>	