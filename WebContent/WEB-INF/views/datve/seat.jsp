<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<div align="center">
	<h2>Chọn ghế ngồi</h2>
		<a href="lichchieu/new" class="btn btn-primary" role="button">Tạo lịch chiếu mới</a>
	<br/>
	<h1>Vao seat roi nhe1</h1>

	<c:set var="hanghientai" value=""/>
	<c:forEach items="${listVe}" var="ve">
<!-- 		Kiem tra xem ghe nay co phai ghe cua hang tiep theo khong -->
		<c:if test="${ve.ghe.hangghe.ten ne hanghientai }">
<!-- 			Neu khong phai hang dau tien thi chen the </div> vao -->
			<c:if test="${not empty ve.ghe.hangghe.ten}"> </div> </c:if>
<!-- 			Chen the div moi vao dat lai bien kiem tra -->
			<div align="center" style="padding-top: 5px;">
			<c:set var="hanghientai" value="${ve.ghe.hangghe.ten}"/>
		</c:if>
<%-- 		<button id="${ve.ma}" class="btn btn-secondary">${ve.ghe.ten}</button> --%>

		<c:choose>
		  <c:when test="${empty ve.hoadon}">
			<button id="${ve.ma}" value="" class="btn" onclick="handleClick(this.id, ${ve.giatien});">${ve.ghe.ten}</button>
		  </c:when>
		  <c:otherwise>
		  	<button id="${ve.ma}" value="" class="btn btn-warning" disabled>${ve.ghe.ten}</button>
<%-- 		    <button id="${ve.ma}" class="btn btn-dark">${ve.ghe.ten}</button> --%>
		  </c:otherwise>
		</c:choose>
		
	</c:forEach>

</div>	

<script type="text/javascript">
		var tongtien = 0;
		var listVe = [];
	  function handleClick(clickedId, price)
	  {
// 		  if ($("#" + clickedId).val() == '')
// 			alert('RONG NHA')
			  
	// 		$("#" + clickedId).attr('value', 'Save');
	// 		$("#" + clickedId).html('Savewww');
	// 		$("#" + clickedId).removeClass('btn-primary');
			$("#" + clickedId).addClass('active');
			$("#" + clickedId).css("font-weight","Bold");
			alert("gia tien = " + price)

			listVe.push(clickedId)
			
	}
</script>