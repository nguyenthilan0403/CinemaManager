<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div align="center">
	<h2>Dat ve</h2>
	<c:forEach items="${danhsachphim}" var="phim">
		<div>
			<img src="${phim.anh}" />
			<p>${phim.ten}</p>
			<p>${phim.theloai}</p>
			<p>${phim.noidung}</p>
			<a href="datve/phim?id=${phim.ma}" class="btn btn-info" role="button">Datve</a>
		</div>
	</c:forEach>
</div>

