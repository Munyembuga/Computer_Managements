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
        <div class="container col-md-5" style="margin-top: 100px" >
            <div class="card">
                <div class="card-body">

                    <form action="<%=request.getContextPath()%>/Login" method="post">



                        <caption>
                            <h2 style=" text-align: center;">
                                Log in

                            </h2>
                        </caption>




                        <fieldset class="form-group">
                            <label>Phone Number</label> <input type="text"
                                                               class="form-control"
                                                               name="phone">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Password</label> <input type="text"
                                                           class="form-control"
                                                           name="passwords">
                        </fieldset>

                      

                        <button type="submit" class="btn btn-success signup ">Log in</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
