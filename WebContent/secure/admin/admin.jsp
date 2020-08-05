<%@page import="vendre.dao.AppUserDAO"%>
<%@page import="vendre.bean.AppUser"%>
<%@page import="java.util.List"%>
<%@include file="/header.jsp" %>
<h1 class="myhead1">Admin</h1>
<%
List<AppUser> res = AppUserDAO.search();
request.setAttribute("res", res);	
%>
<c:if test="${msg != null}">
<div class="alert alert-primary alert-dismissible fade show" >
    <button type="button" class="close" data-dismiss="alert" >
        <span>&times;</span>
    </button>
    <strong>Vendre !</strong> ${msg}
</div>
</c:if>

<table class="table  table-striped">
    <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>Phone No</th>
            <th>EMail</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="c1" items="${res}">
        <tr>
            <td>${c1.userName}</td>
            <td>${c1.phoneNo}</td>
            <td>${c1.email}</td>
            <td>
			<c:if test="${c1.status != 'approved'}">
            <a class="btn btn-success btn-sm" href="${ctx}/secure/admin/UserUpSer?id=${c1.id}&status=approved">Approve</a>
			</c:if>            
			<c:if test="${c1.status != 'rejected'}">
            <a class="btn btn-danger btn-sm" href="${ctx}/secure/admin/UserUpSer?id=${c1.id}&status=rejected">Reject</a>
			</c:if>            
            </td>
        </tr>
    </c:forEach>
    
    </tbody>
</table>


<jsp:include page="/footer.jsp"></jsp:include>