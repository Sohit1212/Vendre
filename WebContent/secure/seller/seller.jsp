<%@page import="vendre.bean.AppUser"%>
<%@page import="vendre.dao.ProductsDAO"%>
<%@page import="vendre.bean.Products"%>
<%@page import="java.util.List"%>
<%@include file="/header.jsp" %>
<c:if test="${msg != null}">
<div class="alert alert-primary alert-dismissible fade show" >
    <button type="button" class="close" data-dismiss="alert" >
        <span>&times;</span>
    </button>
    <strong>Vendre !</strong> ${msg}
</div>
</c:if>
<h1 class="myhead1">Seller</h1>
<a class="btn btn-primary btn-sm" href="${ctx}/secure/seller/prod_add.jsp">Add New Product</a><br><br>

<%
AppUser u1 = (AppUser)session.getAttribute("u1");
List<Products> res = ProductsDAO.search(null, null, u1.getId());
request.setAttribute("res", res);	
%>
<table class="table  table-striped">
    <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Category</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="c1" items="${res}">
        <tr>
            <td>${c1.name}</td>
            <td>${c1.price}</td>
            <td>${c1.category}</td>
            <td>${c1.status}</td>
            <td>
            <a class="btn btn-success btn-sm" href="${ctx}/secure/seller/prod_up.jsp?id=${c1.id}">Edit</a>
            <a class="btn btn-danger btn-sm" href="${ctx}/secure/seller/ProdDelSer?id=${c1.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    
    </tbody>
</table>



<jsp:include page="/footer.jsp"></jsp:include>
            