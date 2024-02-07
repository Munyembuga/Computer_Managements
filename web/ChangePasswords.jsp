<%-- 
    Document   : ChangePasswords
    Created on : Jan 17, 2024, 10:03:59 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <style>
                 <%@include file = "css/css2.css" %>
             </style><!-- comment -->
       <title>Change Password</title>
</head>

<body>
      <%@include file = "Slider.jsp" %>
    <div class='cattles-manage-wrapper'>
        <div class="changepass">
            <p class='change-pwd-p'> Do you want change password ?</p>
            <form action="<%=request.getContextPath()%>/UpdatePassword"  method="POST"class='change-pwd-form'>
                <label htmlFor="currentPassword"> Current Password<span class="require">*</span></label>
                <input type="text" name="oldpassword"  />
                <div class="error"></div>
                <label htmlFor="newPassword">New Password <span class="require">*</span></label>
                <input type="text" name="newpasswords"  />
                <div class="error"> </div>
                <div class="btn_chpass">
                   
                        <a href="Profile.jsp" class="cancel-btn">cancel</a>
                    <button class="save-btn">Save</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>
