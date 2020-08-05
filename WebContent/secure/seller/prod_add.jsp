<%@page import="vendre.bean.ComboValue"%>
<%@page import="vendre.dao.ComboValueDAO"%>
<%@page import="java.util.List"%>
<%@include file="/header.jsp" %>
<%
	List<ComboValue> res = ComboValueDAO.search("p_status");
List<ComboValue> res2 = ComboValueDAO.search("p_category");
request.setAttribute("res", res);	
request.setAttribute("res2", res2);
%>
                    <div class="row mt-3">
                    <div class="col-sm-8 offset-sm-2">
                    <h1 class="myhead1">Add New Product</h1>
                    <form enctype="multipart/form-data" id="myform" method="post" action="${ctx}/secure/seller/AddProdSer">
                    <input required placeholder="Product Name" class="form-control" type="text" name="name" /><br>
                    <input min="0" required placeholder="Price" class="form-control" type="number" name="price" /><br>
                    <textarea rows="5" required placeholder="Product Desc" class="form-control" name="description" ></textarea><br>
                    <select required name="category" class="form-control" >
                    <option value="">Select Category</option>
                    <c:forEach var="c1" items="${res2}">
					<option>${c1.value}</option>
                    </c:forEach>                    
					</select><br>
                    <select required name="status" class="form-control" >
                    <option value="">Select Status</option>
                    <c:forEach var="c1" items="${res}">
					<option>${c1.value}</option>
                    </c:forEach>                    
					</select><br>
                    <input required placeholder="Attachment" class="form-control" type="file" name="at1" /><br>
                    <button type="submit" class="btn btn-primary btn-block">Submit</button>
                    <a href="${ctx}/secure/seller/prod_add.jsp" class="btn btn-danger btn-block">Reset</a>
                    </form>
                    </div>
                    </div>                    
<a class="btn btn-danger btn-sm" href="${ctx}/secure/seller/seller.jsp">Back</a>
<jsp:include page="/footer.jsp"></jsp:include>