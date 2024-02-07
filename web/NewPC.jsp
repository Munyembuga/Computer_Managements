<%-- 
    Document   : NewPC
    Created on : Dec 26, 2023, 10:14:50 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <script src="//cdn.jsdelivr.net/npm/chart.js"></script>
        <style>

            <%@include file = "css/css.css" %>
        </style>
        <title>JSP Page</title>
    </head>
    <body>
<%
        jado.com.computer.model.Authentications credential =
        (jado.com.computer.model.Authentications) session.getAttribute("loggedInUser");
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
            <div class="addpc-container">
                <form action="insert" method="POST">
                    <div class="regd">
                        <label for="">Name <a class="important">*</a></label>
                        <input name="username" type="text" placeholder="Enter your name...">
                    </div>
                    <div class="regd">
                        <label for="">Registration Date <a class="important">*</a></label>
                        <input name="date" type="date" placeholder="Enter your date...">
                    </div>
                    <div class="regd">
                        <label for="">Serial Number <a class="important">*</a></label>
                        <input  name="serialnumber" type="text" placeholder="Enter your Serial number...">
                    </div>
                    <div class="regd">
                        <label for="">School <a class="important">*</a></label>
                        <select id="school" name="school" onchange="updateDepartment()">
                            <option value="ict">ICT</option>
                            <option value="engineering">Engineering</option>
                            <option value="science">Science</option>
                            <option value="mining">Mining and Geology</option>
                            <option value="architecture">Architecture and Built Environment</option>
                            <!-- Add more countries as needed -->
                        </select>
                    </div>
                    <div class="regd">
                        <label for="">Department <a class="important">*</a></label>
                        <select id="department"  name="department"></select>
                        <!--                        <select name="department" id="department">
                                                    <option value="">Select your School</option>
                                                    <option value="ICT"></option>
                                                    <option value="ENGINEERING">ENGINEERING</option>
                                                    <option value="SCIENCE">SCIENCE</option>
                                                    <option value="MINING">MINING</option>
                                                </select>-->
                    </div>
                    <div class="regd">
                        <label for="">Gate <a class="important">*</a></label>
                        <select name="gate" id="">
                            <option value="">Select your gate</option>
                            <option value="Muhabura">Muhabura</option>
                            <option value="Ikaze">Ikaze</option>
                            <option value="Camp-kigali">Camp-kigali</option>
                        </select>
                    </div>
                    <div class="regd">
                        <label for="">Get-Man <a class="important">*</a></label>
                        <input  name="gateman" type="text" placeholder="Enter your get-man...">
                    </div>
                    <div class="regd">
                        <label for="">Reg-Number <a class="important">*</a></label>
                        <input name="regnumber" type="text" placeholder="Enter your reg-number...">
                    </div>
                    <div class="regd">
                        <label for="">Identification <a class="important">*</a></label>
                        <input  name="identification"  type="text" placeholder="Enter your Id number...">
                    </div>
                    <div class="regd">
                        <label for="">Phone number <a class="important">*</a></label>
                        <input name="phone" type="text" placeholder="Enter your phone-number...">
                    </div>
                    <div class="regd">
                        <label for="">Email <a class="important">*</a></label>
                        <input name="email"  type="text" placeholder="Enter your Email..">
                    </div>

                    <!--                    <label for="country">Country:</label>
                                        <select id="country" name="school" onchange="updateProvinces()">
                                            <option value="us">United States</option>
                                            <option value="canada">Canada</option>
                                             Add more countries as needed 
                                        </select>
                    
                                        <label for="province">Province:</label>
                                        <select id="province"></select>-->

                    <script>
                        const schoolDropdown = document.getElementById("school");
                        const departmentDropdown = document.getElementById("department");

                        const departmentByschool = {
                            ict: ["Computer Enginnering", "Computer Science ", "Information System ", "Information Technology "],
                            engineering: ["Civil engineering", "Energy engineering", "Water engineering", "Mechanical engineering"],
                            science: ["Mathematics", "Physics", "Biology", "Chemistry"],
                            mining: ["Geology", "Mining"],
                            architecture: ["Construction Management", "architecture:", "Geography and Urban Planning", "Estate Management and Valuation"]
                                    // Add more Department for each country as needed
                        };

                        function updateDepartment() {
                            const selectedSchool = schoolDropdown.value;
                            const departments = departmentByschool[selectedSchool];

                            // Clear previous options
                            departmentDropdown.innerHTML = "";

                            // Add new options based on the selected country
                            departments.forEach(function (department) {
                                const option = document.createElement("option");
                                option.value = department;
                                option.textContent = department;
                                departmentDropdown.appendChild(option);
                            });
                        }

                        // Initialize provinces based on the default country
                        updateDepartment();
                    </script>

                    <div class="cancel-add-btn">
                        <button class="cancel-btn">Cancel</button>
                        <button class="save-btn">Save</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
