<%-- 
    Document   : DetailPC
    Created on : Jan 17, 2024, 10:08:57 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            <%@include file = "css/css2.css" %>
        </style><!-- comment -->
    </head>
    <body>
        <%
    jado.com.computer.model.Authentications credential
                    = (jado.com.computer.model.Authentications) session.getAttribute("loggedInUser");
        %>

        <%
            //    Logger logger = Logger.getLogger("YourJSPPageName");
            String role = credential.getRole();
            //    logger.log(Level.INFO, "User Role: {0}", role);

            if ("Admin".equals(role)) {
                // Admin content
        %><%@include file="Slider.jsp" %><%
        } else if ("Gateman".equals(role)) {
            // Gateman content
        %><%@include file="SliderBarGateman.jsp" %><%
        } else {
            // Default content or handle other roles
        %><%@include file="sliderbar.jsp" %><%
            }
        %>

        <div class="addpc-container">
            <div class="details-title">
                Details of persons and his Identifications
            </div>
            <c:forEach var="comp" items="${pc}">
                <form  action="<%=request.getContextPath()%>/updatePC"  method="POST">
                    

                    <div class="regd">
                        <label for="">Registration Date <a class="important">*</a></label>
                        <input type="date" name="date" value="<c:out value='${comp.date}' />">
                    </div>
                    <div class="regd">
                        <label for="">Serial Number <a class="important">*</a></label>
                        <input type="text" name="serialnumber" value="<c:out value='${comp.serialnumber}' />" >
                    </div>

                    <div class="regd">
                        <label for="">School <a class="important">*</a></label>
                        <input type="text" name="school" value="<c:out value='${comp.school}' />">
                    </div>
                    <div class="regd">
                        <label for="">Department <a class="important">*</a></label>
                        <input type="text" name="department" value="<c:out value='${comp.department}' />">
                    </div>
                    <div class="regd">
                        <label for="">Gate <a class="important">*</a></label>
                        <input type="text" name="gate" value="<c:out value='${comp.gate}' />">
                    </div>
                    <div class="regd">
                        <label for="">Reg-Number <a class="important">*</a></label>
                        <input type="text" name="regnumber" value="<c:out value='${comp.regnumber}' />">
                    </div>
                    <div class="regd">
                        <label for="">Identification <a class="important">*</a></label>
                        <input type="text" name="identification" value="<c:out value='${comp.identification}' />">
                    </div>
                    <div class="regd">
                        <label for="">Phone number <a class="important">*</a></label>
                        <input type="text"  name="phone" value="<c:out value='${comp.phone}' />">
                    </div>
                    <div class="regd">
                        <label for="">Email <a class="important">*</a></label>
                        <input type="text"name="email" value="<c:out value='${comp.email}' />">
                    </div>
                    <div class="all-form-btn">
                        <div class="delete-form-btn" style="background:red; margin-top: 5rem ">
                            <a  href="deletepc?regnumber=<c:out value='${comp.regnumber}' />" style="text-decoration:none;align-items: center;color: white; text-align: center">Delete Account</a>
                        </div>
<!--                        <div class="save-form-btn">
                            <a  href="updatePC?id=<c:out value='${comp.id}' />">edit Account</a>

                        </div>-->
                    </div>
                </form>
            </c:forEach>



        </div>
    </body>
</html>
