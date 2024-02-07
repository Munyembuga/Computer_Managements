<%-- 
    Document   : Signup-form
    Created on : Dec 17, 2023, 11:33:05 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <style>
            .loginstyle{
                margin: 5px;
                font-size: 20px;
                display: flex;
                align-items: start;


            }
            .signup{

                top: 100%;
                left: 50%;
               
 display: flex;
  justify-content: center;
  align-items: center;
                font-size: 30px;
               
            }
            .login{
                color: #08C25E;
                margin-left: 10px
            }
        </style>
    </head>
    <body>
        <div class="container col-md-5" >
            <div class="card">
                <div class="card-body">

                    <form action="<%=request.getContextPath()%>/Register" method="post">



                        <caption>
                            <h2 style=" text-align: center;">
                                Register

                            </h2>
                        </caption>



                        <fieldset class="form-group">
                            <label>Name</label> <input type="text"
                                                       class="form-control"
                                                       name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Email</label> <input type="text"
                                                        class="form-control"
                                                        name="email">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Phone Number</label> <input type="text"
                                                               class="form-control"
                                                               name="phone">
                        </fieldset>
                        <input type="" name="role" value="Gateman" />
                         <fieldset class="form-group">
                            <label>Password</label> <input type="text"
                                                           class="form-control"
                                                           name="passwords" value="<%= generateRandomPassword() %>">
                        </fieldset>

                      

                        <button type="submit" class="btn btn-success signup ">Registerr</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
