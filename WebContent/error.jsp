<%@include file="/header.jsp" %>
<%@page isErrorPage="true" %>
<h1 class="text-danger">Sorry something went wrong!</h1>
<%
exception.printStackTrace();
%>
<jsp:include page="/footer.jsp"></jsp:include>

