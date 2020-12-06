<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div align="center">
	<h2>Chon gio chieu</h2>
	
	<div>
			<img src="${phim.anh}" />
			<p>${phim.ten}</p>
			<p>${phim.theloai}</p>
			<p>${phim.noidung}</p>
		</div>
	
	<c:forEach items="${danhsachlichchieu}" var="lichchieu">
		<div>
			<p>${lichchieu.ngaychieu} ${lichchieu.giochieu}</p>
			<a href="datve/lichchieu?id=${phim.ma}" class="btn btn-info" role="button">Chọn ghế</a>
		</div>
	</c:forEach>
</div>
