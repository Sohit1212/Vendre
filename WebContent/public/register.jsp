<%@page import="vendre.bean.ComboValue"%>
<%@page import="vendre.dao.ComboValueDAO"%>
<%@page import="java.util.List"%>
<%@include file="/header.jsp" %>
<%
	List<ComboValue> res = ComboValueDAO.search("sec_q");
	request.setAttribute("res", res);
%>
            <script>
                    $(function(){
                        $("#myform").validate({
                            messages: {
                                cpass:{
                                    equalTo: "Password and confirm password should match!"
                                },
                                uname:{
                                    required: "Please type your Name!!"
                                }
                            }
                        });
                        $("[type=reset]").click(function(){
                            $("label.error").remove();
                            }
                        );
                        $("#spass").click(function(){
                            $("#pass").attr("type", "text");
                            }
                        );
                    $.validator.addMethod("inphone", 
                                function(v){
                                    if(v.match(/^(0|\+91)?[6-9]{1}\d{9}$/)){
                                        return true;
                                    }
                                    else {
                                        return false;
                                    }
                                }, 
                                "Invalid Phone No");
                    $err = "Invalid Password!";
                    $.validator.addMethod("mypass", 
                                function(v){
                                    if(!v.match(/[A-Z]{1}/)){
                                        $err = "Atleast One Capital Char is Req!";
                                        return false;
                                    }
                                    else if(!v.match(/[a-z]{1}/)){
                                        $err = "Atleast One Small Char is Req!";
                                        return false;
                                    }
                                    else if(!v.match(/[0-9]{1}/)){
                                        $err =  "Atleast One Digit is Req!";
                                        return false;
                                    }
                                    else if(!v.match(/[^\w\s\d]{1}/)){
                                         $err = "Atleast One Special Char is Req!";
                                         return false;
                                    }
                                    else {
                                        return true;
                                    }
                                }, 
                                function(){return $err});
                    })
                    
                    </script>
                    <style>
                    label.error{
                        color: red;
                        font-weight: 500;
                    }
                    </style>
                    <div class="row mt-3">
                    <div class="col-sm-8 offset-sm-2">
                            <h1 class="myhead1">Register</h1>
                    <form id="myform" method="post" action="${ctx}/RegSer">
                    <input required placeholder="User Name" class="form-control" type="text" name="uname" /><br>
                    <input required placeholder="EMail" class="form-control" type="email" name="email" /><br>
                    <input mypass="true" minlength=8 required placeholder="Password" class="form-control mypass" type="password" name="pass" id="pass"/><br>
                    <input required equalTo="#pass" placeholder="Confirm Password" class="form-control mypass" type="password" name="cpass" /><br>
					
					<select required name="role" class="form-control" >
					<option selected="">Buyer</option>
					<option>Seller</option>
					</select><br>
					                    
                    <input inphone="true" type="tel" required class="form-control"   name="pn" placeholder="PN" /><br>    

                    <textarea required placeholder="Address" class="form-control"  name="address" ></textarea><br>
                    
                    <select required name="sec_q" class="form-control" >
                    <option value="">Security Question</option>
                    <c:forEach var="c1" items="${res}">
					<option>${c1.value}</option>
                    </c:forEach>
					</select><br>
                   
                    
                    <input required placeholder="Security Answer" class="form-control" type="text" name="sec_a" /><br>

                    <button type="submit" class="btn btn-primary btn-block">Submit</button>
                    <button type="reset" class="btn btn-danger btn-block">Reset</button>
                    </form>
                    </div>
                    </div>
                    
<jsp:include page="/footer.jsp"></jsp:include>
                    