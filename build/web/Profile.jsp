<%-- 
    Document   : Profile
    Created on : Jan 17, 2024, 9:51:34 PM
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
        %>         <div class='cattles-manage-wrapper'>
        <div class='edit-profile'>
            <nav class='profile'>Profile</nav>
            /
            <nav class='edit-btn'> Edit</nav>
        </div>
        <div class="profile-preferences">
            <div class='profile-h'>Profile</div>
            <div class='profile-pref'>Preferences</div>
        </div>
        <div class="profile-container">
            <nav class='profile-title'>
                My Profile
            </nav>
            <div class="input-label">
                
                <form action="<%=request.getContextPath()%>/UpdateCredntials" method="POST" class='form-profile-container'>
                       
                        <input type="hidden" name="id"  value="<c:out value='${loggedInUser.id}' />"/>
                    
                    <nav id='cont'>
                        <label htmlFor="" id='lab' class='names-ordered'>
                            Fullname
                            <nav class='ordered'>
                                *
                            </nav>
                        </label>
                        <input type="text"
                           name="name"    value="<c:out value='${loggedInUser.name}' />"
                              />
                    </nav>
                    <nav id='cont'>
                        <label htmlFor="" id='lab'>
                            Email
                        </label>
                        <input type="email" id='lab' name="email"  value="<c:out value='${loggedInUser.email}' />" />
                    </nav>
                    <nav id='cont'>
                        <label htmlFor="" id='lab'>
                            Role
                        </label>
    <input type="text" name="Role" value="<c:out value='${loggedInUser.role}' />" readonly />
                    </nav>
                    <nav id='cont'>
                        <label htmlFor="" id='lab' class='names-ordered'>
                            Phone Number
                            <nav class='ordered'>
                                *
                            </nav>
                        </label>
                        <input type="text" name="phone"  value="<c:out value='${loggedInUser.phone}' />" />
                    </nav> 
                   
                    <div class='change-pwd'>
                        <p>Want to change Password?</p>
                        <a href='ChangePasswords.jsp'>Change!</a>
                    </div>
                
         
                    <div class="all-form-btn" style="margin-top:3rem">
                    <div class="delete-form-btn" style="background: red">
                        <a  href="deleteAccount?id=<c:out value='${loggedInUser.id}'/>" style="color: white;text-decoration: none">Delete Account</a>
                    </div>
                    <div class="save-form-btn" >
                        <button style="color: white;background: black">save</button> 
                    </div>
                </div>
                    </form>
            </div>
        </div>
    </div>
    </body>
</html>
