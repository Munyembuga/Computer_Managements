<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>User Management Application</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>
    <body>

        <header>
            <nav class="navbar navbar-expand-md navbar-dark"
                 style="background-color: tomato">
                <div>
                    <a href="" class="navbar-brand"> User Management App </a>
                </div>

                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/list"
                           class="nav-link">Users</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                   
                        <c:if test="${user == null}">
                            <form action="insert" method="post">
                            </c:if>

                            <caption>
                                <h2>
                                    <c:if test="${user != null}">
                                        Edit User
                                    </c:if>
                                    <c:if test="${user == null}">
                                        Add New User
                                    </c:if>
                                </h2>
                            </caption>

                          >
                         
                            <fieldset class="form-group">
                                <label>User Name</label> <input type="text"
                                value="<c:out value='${user.username}' />" class="form-control"
                                  name="username" required="required">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>User reg number</label> <input type="text"
                                value="<c:out value='${user.regnumber}' />" class="form-control"
                                name="regnumber">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>User email</label> <input type="text"
                                value="<c:out value='${user.email}' />" class="form-control"
                                name="email">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>User phone</label> <input type="text"
                                value="<c:out value='${user.phone}' />" class="form-control"
                                name="phone" required="required">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>User  serial number</label> <input type="text"
                                value="<c:out value='${user.serialnumber}' />" class="form-control"
                                name="serialnumber">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>User identification</label> <input type="text"
                                value="<c:out value='${user.identification}' />" class="form-control"
                                name="identification">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>User school</label> <input type="text"
                                value="<c:out value='${user.school}' />" class="form-control"
                                name="school" required="required">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>User department </label> <input type="text"
                                value="<c:out value='${user.department}' />" class="form-control"
                                                                       name="department">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>User gate</label> <input type="text"
                                value="<c:out value='${user.gate}' />" class="form-control"
                                name="gate">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>User gate man </label> <input type="text"
                                value="<c:out value='${user.gateman}' />" class="form-control"
                                name="gateman" required="required">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>User date</label> <input type="text"
                                value="<c:out value='${user.date}' />" class="form-control"
                                name="date">
                            </fieldset>



                            <button type="submit" class="btn btn-success">Save</button>
                        </form>
                </div>
            </div>
        </div>
    </body>
</html>
