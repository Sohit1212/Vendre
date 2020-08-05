<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>						 
<%@page isELIgnored="false" %>
<%@page errorPage="/error.jsp" %>
<c:set var="ctx" value="/vendre" scope="request"/>
<html>
<head>
        <link rel="stylesheet" href="${ctx}/vender/bs/css/bootstrap.min.css">
        <link rel="stylesheet" href="${ctx}/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <header id="head1">

        <div id="carouselId" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselId" data-slide-to="0" class="active"></li>
                <li data-target="#carouselId" data-slide-to="1"></li>
                <li data-target="#carouselId" data-slide-to="2"></li>
                <li data-target="#carouselId" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner h-100 w-100" role="listbox">
                <div class="carousel-item active">
                    <img src="${ctx}/images/a1.jpg" class="img-fluid  h-100 w-100">
                </div>
                <div class="carousel-item">
                        <img src="${ctx}/images/a2.jpg" class="img-fluid  h-100 w-100">
                </div>
                <div class="carousel-item">
                        <img src="${ctx}/images/a3.jpg" class="img-fluid  h-100 w-100">
                </div>
                <div class="carousel-item">
                        <img src="${ctx}/images/a4.jpg" class="img-fluid  h-100 w-100">
                </div>                
            </div>
        </div>


    </header>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark sticky-top">
        <a class="navbar-brand" href="${ctx}/public/index.jsp">Vendre</a>
        <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavId">
            <ul class="navbar-nav mt-2 mt-lg-0">
                <li class="nav-item active mx-3">
                        <a class="nav-link" href="${ctx}/public/index.jsp">Home</a>
                    </li>
                    <c:if test="${u1.role == 'Seller'}">
                    <li class="nav-item  mx-3">
                            <a class="nav-link" href="${ctx}/secure/seller/seller.jsp">Seller</a>
                    </li>    
                    </c:if>
                <li class="nav-item  mx-3">
                    <a class="nav-link" href="${ctx}/public/about.jsp">About</a>
                </li>
                <li class="nav-item  mx-3">
                        <a class="nav-link" href="${ctx}/public/contact.jsp">Contact</a>
                </li>
                <c:choose>
	                <c:when test="${u1 ==null }">
		                <li class="nav-item  mx-3">
		                        <a class="nav-link" href="${ctx}/public/login.jsp">Login <i class="fa fa-sign-in"></i></a>
		                </li>
	                </c:when>
					<c:otherwise>
		                <c:if test="${u1.role == 'admin'}">
			                <li class="nav-item  mx-3">
			                        <a class="nav-link" href="${ctx}/secure/admin/admin.jsp">Admin</a>
			                </li>					
		                </c:if>
		                <li class="nav-item  mx-3">
		                        <a class="nav-link" href="${ctx}/LogoutSer">Logout <i class="fa fa-sign-out"></i></a>
		                </li>					
					</c:otherwise>                
                </c:choose>
            </ul>
        
        
        <form action="${ctx}/public/index.jsp" class="form-inline ml-auto my-2 my-lg-0">
        	<input type="hidden" value="${param.category}" name="category" />
            <input class="form-control mr-sm-2" type="text" placeholder="Search" value="${param.si}" name="si" id="si">
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
        </form>
        
        
        </div>
    </nav>    
    <main class="container-fluid p-4">