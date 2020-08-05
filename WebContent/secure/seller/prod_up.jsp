<%@page import="vendre.dao.ProductsDAO"%>
<%@page import="vendre.bean.Products"%>
<%@page import="vendre.bean.ComboValue"%>
<%@page import="vendre.dao.ComboValueDAO"%>
<%@page import="java.util.List"%>
<%@include file="/header.jsp" %>
<%
	Products p1 = ProductsDAO.searchById(request.getParameter("id"));
List<ComboValue> res = ComboValueDAO.search("p_status");
List<ComboValue> res2 = ComboValueDAO.search("p_category");
request.setAttribute("p1", p1);	
request.setAttribute("res", res);	
request.setAttribute("res2", res2);
%>
                    <div class="row mt-3">
                    <div class="col-sm-8 offset-sm-2">
                    <h1 class="myhead1">Update Product</h1>
                    <form enctype="multipart/form-data" id="myform" method="post" action="${ctx}/secure/seller/ProdUpSer">
                    <input type="hidden" value="${p1.id}" id="id" name="id" />
                    <input required placeholder="Product Name" class="form-control" value="${p1.name}" type="text" name="name" /><br>
                    <input min="0" required placeholder="Price" class="form-control" value="${p1.price}" type="number" name="price" /><br>
                    <textarea rows="5" required placeholder="Product Desc" class="form-control" name="description" >${p1.itemDesc}</textarea><br>
                    <select required  value="${p1.category}" name="category" class="form-control" id="category" >
                    <option value="">Select Category</option>
                    <c:forEach var="c1" items="${res2}">
					<option>${c1.value}</option>
                    </c:forEach>                    
					</select><br>
                    <select required value="${p1.status}" name="status" class="form-control" id = "status">
                    <option value="">Select Status</option>
                    <c:forEach var="c1" items="${res}">
					<option>${c1.value}</option>
                    </c:forEach>                    
					</select><br>
					<div class="row">
					<div class="col-3">
					Current Image
					</div>
					<div class="col-9">
					<img src="${ctx}/upload/prod/${p1.id}.jpg" class="img-fluid" style="height: 300px;" /><br><br>
					</div>
					</div>
					<div class="row">
					<div class="col-3">
					Select New Image
					</div>
					<div class="col-9">
                    <input placeholder="Attachment" class="form-control" type="file" name="at1" /><br>
					</div>
					</div>
					
                    <button type="submit" class="btn btn-primary btn-block">Submit</button>
                    <a href="${ctx}/secure/seller/prod_add.jsp" class="btn btn-danger btn-block">Reset</a>
                    </form>
                    </div>
                    </div>                    
<a class="btn btn-danger btn-sm" href="${ctx}/secure/seller/seller.jsp">Back</a>
<jsp:include page="/footer.jsp"></jsp:include>
<script>
document.getElementById("category").value = "${p1.category}";
document.getElementById("status").value = "${p1.status}";
</script>
 