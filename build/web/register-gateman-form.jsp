<%-- 
    Document   : register-gateman-form
    Created on : Dec 31, 2023, 11:38:15 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <style>

            * {
                margin: 0;
                padding: 0;
                border: none;
                outline: none;
                box-shadow: border-box;
                font-family: Verdana, Geneva, Tahoma, sans-serif;

            }

            body {
                display: flex;
            }

            .sliderbar {
                position: sticky;
                top: 0;
                left: 0;
                bottom: 0;
                width: 240px;
                height: 100vh;
                padding: 0 1.7rem;
                color: #000000;
                overflow: hidden;
                transition: all 0.5s linear;
            }

            .logo {
                height: 80px;
                padding: relative;

            }

            .main {
                height: 88%;
                position: relative;
                list-style: none;
                padding: 0;
            }

            .main li {
                padding: 1rem;
                margin: 8px 0;
                border-radius: 8px;
                transition: all 0.5s ease-in-out;
                cursor: pointer;
            }

            .main li:hover,
            .active {
                background-color: #e0e0e058;
            }

            .main a {
                color: black;
                font-size: 14px;
                text-decoration: none;
                display: flex;
                align-items: center;
                gap: 1.5rem;

            }

            .main a span {
                overflow: hidden;
            }

            .main a i {
                font-size: 1.2rem;
            }

            .logout {
                position: absolute;
                bottom: 0;
                left: 0;
                width: 100%;

            }

            .maincontent {
                position: relative;
                width: 100%;
                padding: 1rem;

            }

            .headerwrapper img {
                width: 50px;
                height: 50px;
                cursor: pointer;
                border-radius: 50%;
            }

            .headerwrapper {
                display: flex;
                justify-content: space-between;
                align-items: center;
                flex-wrap: wrap;
                border-radius: 10px;
                padding: 10px 2rem;
                margin-bottom: 1rem;
                border: 1px solid grey;

            }

            .headertitle {
                color: rgba(113, 99, 186, 255);

            }

            .userinformation {
                display: flex;
                align-items: center;
                gap: 1rem;

            }

            .searchbox {
                border-radius: 15px;
                color: rgba(113, 99, 186, 255);
                display: flex;
                align-items: center;
                gap: 10px;
                padding: 10px;
            }

            .searchbox input {
                background-color: transparent;
                padding: 10px;

            }

            .searchbox i {
                font-size: 1.2rem;
                cursor: pointer;
                transition: all 0.5s ease-out;

            }

            .searchbox i:hover {
                transform: scale(1, 2);
            }

            .cardcontainer {
                padding: 10px;
                border-radius: 10px;
            }

            .cardwrapper {
                display: flex;
                flex-wrap: wrap;
                gap: 1rem;
            }

            .managepc {
                display: flex;
                margin-bottom: 1rem;
                justify-content: space-between;
            }

            .addpc {
                border: 1px solid grey;
                background-color: #000000;
                padding: 10px 20px;
                color: white;
                border-radius: 10px;
            }

            .search-student {
                display: flex;
                justify-content: space-between;
            }

            .search-btn {
                border: 1px solid grey;
                padding: 8px 10px;
                border-radius: 10px;
                height: 20px;
            }

            .search-btn:hover {
                background-color: #000000;
                color: white;
            }

            .school-container {
                display: flex;
                padding: 10px 20px;
                flex-wrap: wrap;
                gap: 20px;
                align-items: center;
            }

            .school1 {
                width: 10rem;
                height: 5rem;
                margin-top: 1rem;
                border: 1px solid grey;
                border-radius: 10px;
                text-align: center;
            }

            .paymentcard {
                border-radius: 10px;
                padding: 10px 20px;
                display: flex;
                width: 150px;
                flex-direction: column;
                border: 1px solid black;
                transition: all 0.5s ease-in-out;
                align-items: center;
                justify-content: center;
            }

            .paymentcard:hover {
                transform: translateY(-5px);
            }

            .cardheader {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .amount {
                display: flex;
                flex-direction: column;
            }



            .search {
                width: 42rem;
                border: 1px solid grey;
                border-radius: 10px;
                padding: 10px 20px;
            }

            .addpc-container form {

                display: block;
                /*  grid-template-columns: 1fr;*/
                margin-top: 20px;
                width: 40%;
                justify-content: center;





            }

            .regd {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-content: center;
                align-self: center;

            }

            form label {
                font-size: 13px;
            }

            select {
                margin-bottom: 20px;
                width: 80%;
                padding: 8px;
                background: none;
                color: #000000;
                outline: none;
                font-size: 15px;
                border-radius: 8px;
                border: 1px solid grey;
            }

            input {
                margin-bottom: 20px;
                width: 75%;
                padding: 8px;
                background: none;
                color: #000000;
                outline: none;
                font-size: 15px;
                border-radius: 8px;
                border: 1px solid grey;
            }

            .important {
                color: red;
            }

            .cancel-add-btn {
                margin-top: 8rem;
                gap: 10px;
                display: flex;
                /*flex-direction: flex-end;*/
                /*justify-content: space-between;*/
            }

            .save-btn {
                border: 1px solid grey;
                padding: 5px 20px;
                border-radius: 10px;
                background-color: #000000;
                color: white;
                cursor: pointer;
            }
            .report-title{
                text-align: center;
                color: #111010;
            }

            .cancel-btn {
                border: 1px solid grey;
                padding: 5px 20px;
                border-radius: 10px;
                cursor: pointer;
            }

            /* Style for the table */
            table{
                width: 100%;
            }
            table tbody{
                border-collapse: collapse;
                margin-top: 20px;
                border: 2px solid #ddd;
            }
            .view-more{
                color: rgb(21, 0, 255);
                text-align: center;
                cursor: pointer;
            }

            table th {
                background-color: #111010;
                color: white;
                padding: 8px;
                text-align: left;
                font-weight: bold;
            }
            table tr:nth-child(odd) {
                background-color: #eae9e9;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file ="Slider.jsp" %>
        <div class="maincontent">
            <div class="headerwrapper">
                <div class="headertitle">
                    <span>PC MANAGEMENT SYSTEM</span>

                </div>
                <div class="userinformation">
                    RGL LTD
                    <img src="profile.jpg" alt="RGL ltd">
                </div>

            </div>

            <div class="addpc-container"  style="margin-left:20rem">






                <form action="<%=request.getContextPath()%>/Register" method="post" >

                        <h2>
          
                                Add New User
                          
                        </h2>
                 


                    <!--                            <div class="regd">
                    
                                                    <input value="<c:out value='${gateman.id}' />"
                                                           name="name" type="text" placeholder="Enter your name...">
                                                </div>      -->

                    <div class="regd">
                        <label for=""> Name <a class="important">*</a></label>
                               <input value="<c:out value='${gateman.name}' />"
                               name="name" type="text" placeholder="Enter your name...">
                    </div>


                    <div class="regd">
                        <label for="">Phone number <a class="important">*</a></label>
                        <input value="<c:out value='${gateman.phone}'/> "
                               name="phone" type="text" placeholder="Enter your phone-number...">
                    </div>
                    <div class="regd">
                        <label for="">Email <a class="important">*</a></label>
                        <input value="<c:out value='${gateman.email}'/>"
                               name="email"  type="text" placeholder="Enter your Email..">
                    </div>
                    <div class="regd">
                        <label for="">Passwords <a class="important">*</a></label>
                        <input value="<%= generateRandomPassword()%>"
                               name="passwords"  type="text" placeholder="Enter passwords...">
                    </div>

                    <div class="cancel-add-btn" style="margin-top: -1px;">
                        <button class="cancel-btn">Cancel</button>
                        <button class="save-btn">Save</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
<%!
    private String generateRandomPassword() {
        // Use Random class to generate a random number and a random character
        Random random = new Random();

        // Generate a random number between 1000 and 9999
        int randomNumber = random.nextInt(9000) + 1000;

        // Generate a random character using ASCII values for letters (65-90 for uppercase, 97-122 for lowercase)
        char randomCharacter = (char) (random.nextInt(26) + 'A');

        // Combine the random number and character
        return String.valueOf(randomCharacter) + randomNumber;
    }
%>
