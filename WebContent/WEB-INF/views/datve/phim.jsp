<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div align="center">
	<h2>Chi tiết phim</h2>
	<div class="media">
		<img src="${phim.anh}" class="" alt="...">
		<div class="media-body">
			<h5 class="mt-0">
				<b>${phim.ten}</b>
			</h5>
			<p>
				<b>Thể loại : </b>${phim.theloai}</p>
			<p class="mb-0">
				<b> Tóm tắt phim :</b>${phim.noidung}</p>
		</div>
	</div>
	<h2>Thời gian chiếu</h2>
	<div class="row align-items-center">
		<c:forEach items="${danhsachlichchieu}" var="lichchieu">
			<div class="col-4">
				<p>${lichchieu.ngaychieu}${lichchieu.giochieu}</p>
				<a href="datve/seat?id=${phim.ma}" class="btn btn-info"
					role="button">Chọn ghế</a>
			</div>
		</c:forEach>
	</div>
</div>
