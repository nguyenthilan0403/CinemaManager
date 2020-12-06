<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<div align="center">
	<h1>Chọn ghế ngồi</h1>
	<br/>
	<input id="malichchieu" value="${lichchieu.ma}" hidden/>
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
			<button id="${ve.ma}" value="" class="btn btn-warning" onclick="handleClick(this.id, ${ve.giatien});">${ve.ghe.ten}</button>
		  </c:when>
		  <c:otherwise>
		  	<button id="${ve.ma}" value="" class="btn btn-dark" disabled>${ve.ghe.ten}</button>
<%-- 		    <button id="${ve.ma}" class="btn btn-dark">${ve.ghe.ten}</button> --%>
		  </c:otherwise>
		</c:choose>
		
	</c:forEach>
	</div>
	
	<button class="btn btn-primary" id="btnThanhToan" disabled>Thanh toán</button>
	<h3>Tổng tiền: <span id="Tongtien">0 ₫</span></h3>

</div>	

<script type="text/javascript">
	var tongtien = 0;
	var listVe = [];
	var malichchieu = $("#malichchieu").val();
	
	function handleClick(clickedId, price)
	{	
		if ($("#" + clickedId).val() == '')
		{
			$('#btnThanhToan').removeAttr("disabled");
			$("#" + clickedId).val("selected")
			listVe.push(clickedId)
			$("#" + clickedId).addClass('active');
			$("#" + clickedId).css("font-weight","Bold");
			tongtien += price;
			$("#Tongtien").html(tongtien + " ₫");
		}
		else {
			$("#" + clickedId).val("")
			listVe.remove(clickedId)
			$("#" + clickedId).removeClass('active');
			$("#" + clickedId).css("font-weight","Normal");
			tongtien -= price;
			$("#Tongtien").html(tongtien + " ₫");

			if (tongtien == 0) 
				$('#btnThanhToan').attr("disabled", true);
		}
			  			
// 			for (i = 0; i < listVe.length; i++) {
// 			  alert(listVe[i])
// 			}
	};
	 
	$('#btnThanhToan').on('click', function() {
	    $.ajax({
	        url : 'thanhtoan?giatien=' + tongtien + '&lichchieu=' + malichchieu,
// 	        dataType : 'json',
// 	        contentType: "application/json",
	        type: 'POST',
	        data : {selectedVe : listVe},
	        success: function(response) {
	            //my success function     
// 	            alert("response = " + response)
// 	            alert("string = " + response.Result)       
	            location.href = 'hoadon'
	        },
	        error: function(e) {
	            //my error function 
// 	            			for (i = 0; i < listVe.length; i++) {
// 			  alert(listVe[i])

// 			}
	            alert("Fail roi nhe")
// 	            alert("response = " + e)
// 	            alert("string = " + e.Result)   
// 	            alert("stringnify = " + JSON.stringify(e))       
// 	            alert(JSON.stringify(listVe));
// 	            alert(listVe);
// 	            alert(JSON.stringify(e));
	        }});
	})
	
	Array.prototype.remove = function() {
	    var what, a = arguments, L = a.length, ax;
	    while (L && this.length) {
	        what = a[--L];
	        while ((ax = this.indexOf(what)) !== -1) {
	            this.splice(ax, 1);
	        }
	    }
	    return this;
	};
		
</script>