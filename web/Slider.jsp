<%-- 
    Document   : Slider
    Created on : Dec 26, 2023, 10:23:29 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <script src="//cdn.jsdelivr.net/npm/chart.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="sliderbar">
       
      <div class="log"></div>
            <ul class="main">
                <li class="active">
                    <a href="<%= request.getContextPath()%>/Dashboard">
                        <i class="fa-solid fa-chart-line"></i>
                        <span>Dashboard</span></a>
                </li>
                <li>
                    <a href="<%= request.getContextPath()%>/gateman">
                        <i class="fas fa-chart-bar"></i>
                        <span>Gate man</span></a>
                </li>
              
                <li>
                    <a href="<%=request.getContextPath()%>/Report">
                        <i class="fas fa-tachometer-alt"></i>
                        <span>Reports</span>
                    </a>
                        <a href="DashboardGateman.jsp"></a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/Profile">
                        <i class="fas fa-question-circle"></i>
                        <span>Profile</span></a>
                </li>

             
                <li class="logout">
                    <a href="<%=request.getContextPath()%>/logout">
                        <i class="fas fa-sign-out-alt"></i>
                        <span>Logout</span>
                    </a>
                </li>
            </ul>
        </div>
                         
    </body>
</html>
