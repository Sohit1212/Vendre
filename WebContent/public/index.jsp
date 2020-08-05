<%@page import="vendre.dao.ComboValueDAO"%>
<%@page import="vendre.bean.ComboValue"%>
<%@page import="vendre.dao.ProductsDAO"%>
<%@page import="vendre.bean.Products"%>
<%@page import="java.util.List"%>
<%@include file="/header.jsp" %>
<%
List<ComboValue> res2 = ComboValueDAO.search("p_category");
List<Products> res = ProductsDAO.search(request.getParameter("si"), request.getParameter("category"), null);
request.setAttribute("res", res);
request.setAttribute("res2", res2);
%>


<div class="row myhead1">
<div class="col-sm-4">
<h1>Products</h1>
</div>
<div class="col-sm-2 offset-sm-6">
<form class="form-inline ml-auto" style="display:inline">
                    <select onchange="this.form.submit()" name="category" id="category" class="form-control" >
                    <option value="">All</option>
                    <c:forEach var="c1" items="${res2}">
					<option>${c1.value}</option>
                    </c:forEach>                    
					</select><br>
        	<input type="hidden" value="${param.si}" name="si" />					
</form>
</div>
</div>

<div class="row">
<c:forEach var="c1" items="${res}">
<div class="col-sm-4 p-5">
<div class="card mycard">
    <img class="card-img-top img-fluid w-100" style="height: 250px;"  src="${ctx}/upload/prod/${c1.id}.jpg" alt="">
    <div class="card-body">
        <h5 class="card-title">${c1.name}</h5>
        <p class="card-text">${c1.price}</p>
    </div>
</div>
</div>
</c:forEach>
</div>
<jsp:include page="/footer.jsp"></jsp:include>

<script>
document.getElementById("category").value = "${param.category}";
</script>
