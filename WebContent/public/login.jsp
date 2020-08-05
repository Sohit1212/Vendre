<%@include file="/header.jsp" %>
            <div class="row mt-3">
                <div class="col-sm-8 offset-sm-2">
                <h3 style="color:red;">${msg}</h3>
                 <h1 class="myhead1">Login</h1>
                <form id="myform" method="post" action="${ctx}/LoginSer">
                <input required placeholder="EMail" class="form-control" type="email" name="email" /><br>
                <input mypass="true" required placeholder="Password" class="form-control mypass" type="password" name="pass" id="pass"/><br>
                <p style="color:red;">${err}</p>
                <button type="submit" class="btn btn-success btn-block">Login</button>
                <div class="text-right mt-3">
                    <a href="${ctx}/public/forgot.jsp">Forgot Password</a>
                    <a href="${ctx}/public/register.jsp" class="ml-4">Register</a>    
                </div>
                </form>
                </div>
                </div>
<jsp:include page="/footer.jsp"></jsp:include>
                