/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package jado.com.computer.web;

import jado.com.computer.dao.UserDao;
import jado.com.computer.model.User;
import jado.com.computer.model.Authentications;
import java.io.IOException;
import java.io.PrintWriter;
//import javax.mail.*;
//import javax.mail.internet.*;
import java.util.Properties;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;

/**
 *
 * @author USER
 */
@WebServlet(urlPatterns = {"/"})
public class ComputerSerlet extends HttpServlet {

    private UserDao userDao;

    public ComputerSerlet() {
        this.userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//          Authentications loggedInUser = (Authentications) request.getSession().getAttribute("loggedInUser");
        jado.com.computer.model.Authentications credential = (jado.com.computer.model.Authentications) request.getSession().getAttribute("loggedInUser");

        if (request.getSession().getAttribute("loggedInUser") == null) {
            // If the user is not logged in, redirect to the login page for secured pages
            String action = request.getServletPath();
//
            if (!action.equals("/Loginformn") && !action.equals("/Login")) {
                response.sendRedirect("Login-form.jsp");
                return;
            }
        }
//       String userRole = null;
//
//        // Check if the user is not null, then get the role
//        if (credential != null) {
//            userRole = credential.getRole();
//        } else {
//            // If the user is null, redirect to the login page
//            response.sendRedirect("Login-form.jsp");
//            return;
//        }

        // Get the requested action
        String action = request.getServletPath();

        switch (action) {
            case "/addNew":
                showNewForm(request, response);
                break;
            case "/newPC":
                NewComputer(request, response);
                break;
            case "/search":
                try {
                searchUser(request, response);
            } catch (Exception e) {
                e.printStackTrace();

            }
            break;
            case "/searchgateman":
                try {
                searchgt(request, response);
            } catch (Exception e) {
                e.printStackTrace();

            }
            break;
            case "/Registergateman":
                try {
                Gateman(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }

            break;
            case "/gateman":
                try {
                listGateman(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }

            break;
            case "/Admin":
                dashboard(request, response);
                break;
            case "/Report":
                showReport(request, response);
                break;
            case "/viewmore":
                try {
                viewMore(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
            case "/Loginformn":
                Loginform(request, response);
                break;
            case "/Profile":
                profile(request, response);
                break;
            case "/insert":
                try {
                inserts(request, response);
            } catch (Exception e) {

                e.printStackTrace();

            }

            break;
            case "/Register":
                try {
                register(request, response);
            } catch (Exception e) {

                e.printStackTrace();

            }

            break;

            case "/Login":
                try {
                loginCheck(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
            case "/edit":
                try {
                ShowEdit(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
            case "/delete":
                 try {
                delete(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }

            break;
            case "/deletepc":
                 try {
                deletepcc(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }

            break;
            case "/deleteAccount":
                 try {
                deleteAccoun(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }

            break;
            case "/UpdatePassword":
                 try {
                updatePassword(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }

            break;
             case "/UpdatePC":
                 try {
                updatePC(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }

            break;
            case "/UpdateCredntials":
                 try {
                updateCredential(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }

            break;
            case "/logout":
                logoutUsers(request, response);
                break;

            default:
                try {
                listUser(request, response);
            } catch (Exception e) {
                e.printStackTrace();

            }
            break;
        }
//switch (userRole) {
//        case "Admin":
//            performAdminActions(action, request, response);
//            break;
//        case "Gateman":
//            performGatemanActions(action, request, response);
//            break;
//        // Add more cases for other roles if needed
//        default:
//            // Handle default actions for other roles or unknown roles
//            response.sendRedirect("Login-form.jsp");
//            break;
//    }

    }
//    private void performAdminActions(String action, HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//    switch (action) {
//        case "/addNew":
//            showNewForm(request, response);
//            break;
//           case "/Register":
//                try {
//                register(request, response);
//            } catch (Exception e) {
//
//                e.printStackTrace();
//
//            }
//
//            break;
//
//            case "/Login":
//                try {
//                loginCheck(request, response);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            break;
//        case "/newPC":
//            NewComputer(request, response);
//            break;
//        // Add more admin actions
//        default:
//            // Handle default actions for admin
//            listUser(request, response);
//            break;
//    }
//}
//
//private void performGatemanActions(String action, HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//    switch (action) {
//        case "/Register":
//            register(request, response);
//            break;
//        case "/gateman":
//            listGateman(request, response);
//            break;
//        // Add more gateman actions
//        default:
//            // Handle default actions for gateman
//            response.sendRedirect("Login-form.jsp");
//            break;
//    }
//}

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("form-computer-registration.jsp");
        dispatcher.forward(request, response);
    }

    private void NewComputer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("NewPC.jsp");
        dispatcher.forward(request, response);
    }

    private void Gateman(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("register-gateman-form.jsp");
        dispatcher.forward(request, response);
    }

    protected void updatePassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpasswords");

        userDao.updatePSA(newpassword, oldpassword);

        response.sendRedirect("list");

    }

    protected void updatePC(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int regnumber = Integer.parseInt(request.getParameter("regnumber"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String serialnumber = request.getParameter("serialnumber");
        String identification = request.getParameter("identification");
        String school = request.getParameter("school");
        String department = request.getParameter("department");
        String gate = request.getParameter("gate");
        String gateman = request.getParameter("gateman");
        String date = request.getParameter("date");
        int id = Integer.parseInt(request.getParameter("id"));


        User newUpdate = new User(id,regnumber, username, email, phone, serialnumber, identification, school, department, gate, gateman, date);

        userDao.updatePC(newUpdate);

        response.sendRedirect("list");

    }

    protected void updateCredential(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ids = Integer.parseInt(request.getParameter("id"));
        String names = request.getParameter("name");
        String emails = request.getParameter("email");
        String phones = request.getParameter("phone");

        userDao.updatecre(names, emails, phones, ids);

        response.sendRedirect("list");

    }

    protected void viewMore(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String regnumber = (request.getParameter("regnumber"));

        List<User> pc = userDao.seclectUserByRegnumber(regnumber);
        for (User user : pc) {
            System.out.println("User: " + user.toString());
        }
        request.setAttribute("pc", pc);
        System.out.println("Daaaaaaaaaaaaaaaaaa" + pc);
        RequestDispatcher dispatch = request.getRequestDispatcher("DetailPC.jsp");
        dispatch.forward(request, response);

    }

    private void showReport(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int totalRecordsICT = userDao.getTotalRecordsPCICT();
        int totalRecordseng = userDao.getTotalRecordsENG();
        int totalRecordssc = userDao.getTotalRecordsPCSC();
        int totalRecordsarch = userDao.getTotalRecordsPCARCH();
        int totalRecordsmin = userDao.getTotalRecordsPCMIN();
        int totalRecordpc = userDao.getTotalRecordsPC();
        request.setAttribute("totalRecordpc", totalRecordpc);
        request.setAttribute("totalRecordsict", totalRecordsICT);
        request.setAttribute("totalRecordseng", totalRecordseng);
        request.setAttribute("totalRecordssc", totalRecordssc);
        request.setAttribute("totalRecordsarch", totalRecordsarch);
        request.setAttribute("totalRecordsmin", totalRecordsmin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Report.jsp");
        dispatcher.forward(request, response);
    }

    private void Loginform(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login-form.jsp");
        dispatcher.forward(request, response);
    }

    private void dashboard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");

        dispatcher.forward(request, response);
    }

    private void profile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Profile.jsp");

        dispatcher.forward(request, response);
    }

    protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        String pass = request.getParameter("passwords");

        Authentications regi = new Authentications(name, email, phone, pass);
        userDao.registergateman(regi);
        request.getSession().setAttribute("SignUpInUser", regi);
        response.sendRedirect("gateman");

    }

    protected void ShowEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Authentications gateman = userDao.seclectGateMan(id);
        request.setAttribute("gateman", gateman);
        System.out.println("Daaaaaaaaaaaaaaaaaa" + gateman);
        RequestDispatcher dispatch = request.getRequestDispatcher("register-gateman-form.jsp");
        dispatch.forward(request, response);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        userDao.deleteGateman(id);

        response.sendRedirect("gateman");

    }

    protected void deletepcc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int regnumber = Integer.parseInt(request.getParameter("regnumber"));

        userDao.deletePC(regnumber);

        response.sendRedirect("list");

    }

    protected void deleteAccoun(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        userDao.deleteGateman(id);

        response.sendRedirect("Login");

    }

    protected void loginCheck(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String password = request.getParameter("passwords");

        Authentications credential = userDao.loginData(phone, password);

        if (credential != null) {
            // If the credentials are valid, redirect to a success page or perform other actions
            // For example, you can set the logged-in user in session for further authentication:
//            credential.setRole("Admin");

            request.getSession().setAttribute("loggedInUser", credential);
            request.setAttribute("loggedInUsers", credential);
            response.sendRedirect("list"); // Redirect to the dashboard or another page
        } else {
            // If the credentials are invalid, redirect back to the login form or show an error message
            request.setAttribute("loginError", "Invalid email or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login-form.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void inserts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int regnumber = Integer.parseInt(request.getParameter("regnumber"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String serialnumber = request.getParameter("serialnumber");
        String identification = request.getParameter("identification");
        String school = request.getParameter("school");
        String department = request.getParameter("department");
        String gate = request.getParameter("gate");
        String gateman = request.getParameter("gateman");
        String date = request.getParameter("date");

        User newUser = new User(regnumber, username, email, phone, serialnumber, identification, school, department, gate, gateman, date);
        userDao.insert(newUser);
        System.out.println("insert sucess");
        response.sendRedirect("list");

    }

    protected void searchUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String regnumber = request.getParameter("regnumber");

        List<User> searchResults = userDao.seclectUserByRegnumber(regnumber);
        request.setAttribute("searchResults", searchResults);

        RequestDispatcher dispatch = request.getRequestDispatcher("search-result-pc.jsp");
        dispatch.forward(request, response);
    }

    protected void searchgt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("gateman");

        List<Authentications> searchResultsgt = userDao.seclectGatemanByname(name);
        request.setAttribute("searchResultsgt", searchResultsgt);

        RequestDispatcher dispatch = request.getRequestDispatcher("search-result-gateman.jsp");
        dispatch.forward(request, response);
    }

    protected void listUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 4; // Change this value to set the number of records per page
        int startingNumber = (page - 1) * recordsPerPage + 1;
        request.setAttribute("startingNumber", startingNumber);
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int offset = (page - 1) * recordsPerPage;
        List<User> listUser = userDao.seclectAllUser(offset, recordsPerPage);
        request.setAttribute("listUser", listUser);
        int totalRecords = userDao.getTotalRecordsPC(); // Get the total number of records

        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
        int totalUser = userDao.getTotalRecords();
        request.setAttribute("totalUser", totalUser);
        request.setAttribute("totalRecords", totalRecords);

        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        RequestDispatcher dispatch = request.getRequestDispatcher("AdminDashboard.jsp");

        dispatch.forward(request, response);

    }

    protected void listGateman(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 4; // Change this value to set the number of records per page
        int startingNumber = (page - 1) * recordsPerPage + 1;

// Set the starting number as an attribute in the request object
        request.setAttribute("startingNumber", startingNumber);
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int offset = (page - 1) * recordsPerPage;
        List<Authentications> listgateman = userDao.seclectAllgateman(offset, recordsPerPage);

        request.setAttribute("listgateman", listgateman);
        int totalRecords = userDao.getTotalRecords(); // Get the total number of records

        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
        int totalgateman = userDao.getTotalRecordsPC();
        request.setAttribute("totalRecords", totalRecords);

        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        RequestDispatcher dispatch = request.getRequestDispatcher("RegisterGateMan.jsp");
        dispatch.forward(request, response);

    }

    protected void logoutUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("Login-form.jsp");

    }
}
//    private void sendPasswordToEmail(String recipientEmail, String generatedPassword) {
//    // Setup mail server properties
//    Properties properties = new Properties();
//    properties.put("mail.smtp.host", "your.smtp.host");
//    properties.put("mail.smtp.port", "your.smtp.port");
//    properties.put("mail.smtp.auth", "true");
//
//    // Create a session with the email credentials
//    Session session = Session.getInstance(properties, new Authenticator() {
//        @Override
//        protected PasswordAuthentication getPasswordAuthentication() {
//            return new PasswordAuthentication("your.email@gmail.com", "your_email_password");
//        }
//    });
//
//    try {
//        // Create a default MimeMessage object
//        Message message = new MimeMessage(session);
//
//        // Set From: header field of the header
//        message.setFrom(new InternetAddress("your.email@gmail.com"));
//
//        // Set To: header field of the header
//        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
//
//        // Set Subject: header field
//        message.setSubject("Your Generated Password");
//
//        // Now set the actual message
//        message.setText("Your generated password is: " + generatedPassword);
//
//        // Send message
//        Transport.send(message);
//
//        System.out.println("Email sent successfully...");
//
//    } catch (MessagingException e) {
//        e.printStackTrace();
//    }
//}
//
//}
