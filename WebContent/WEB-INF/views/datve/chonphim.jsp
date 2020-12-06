<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div align="center">
	<h2>Danh sách phim</h2>
	<div class="container">
  <div class="row align-items-center">
  	<c:forEach items="${danhsachphim}" var="phim"> 
    <div class="col-4">
 			<img src="${phim.anh}" /> 
			<p><b>${phim.ten}</b></p> 
 			<p><b>Thể loại : </b>${phim.theloai}</p> 
 			<a href="datve/phim?id=${phim.ma}" class="btn btn-info" role="button">Đặt vé</a>
   </div> 
 	</c:forEach>
 </div> 
</div>
</div>



