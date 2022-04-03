package com.example.WebApplicationProject;

import model.User;
import service.HashingPassword;
import service.UserService;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "MainServlet", urlPatterns = "/User")
public class MainServlet extends HttpServlet {

    private String message;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public void init() {
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");

        if (page.equalsIgnoreCase("register")) {
            User user = new User();
            user.setUser_name(request.getParameter("username"));
            String password = request.getParameter("password");
            password = HashingPassword.encode(password);
            user.setPassword(password);
            user.setFull_name(request.getParameter("full_name"));
            UserService userService = new UserService();
            userService.insertUser(user);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("login")) {
            User user = new User();

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            password = HashingPassword.encode(password);
            User userService = new UserService().getUser(username, password);

            if (userService != null) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("username", username);
                httpSession.setAttribute("password", password);
                Cookie user_cookie = new Cookie("username", username);
                response.addCookie(user_cookie);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/dashboard.jsp");
                requestDispatcher.forward(request, response);
            } else {
                out.println("<p class='text-danger bg-dark'> Unable to login! Either Username or Password is incorrect <p>");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.include(request, response);
            }
        }
        // table ko values display hanna ko lagi
        if (page.equalsIgnoreCase("UserLists")) {
            User user = new User();
            UserService userService = new UserService();
            try {
                ArrayList<User> users = (ArrayList<User>) userService.getUserList();
                request.setAttribute("UserTable", users);
                request.setAttribute("user", user);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/list_user.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }

        if (page.equalsIgnoreCase("newUsers")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/register.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("addNewUsers")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/add_user.jsp");
            requestDispatcher.forward(request, response);
        }
        if (page.equalsIgnoreCase("addUsers")) {
            User user = new User();
            user.setUser_name(request.getParameter("username"));
            user.setPassword(HashingPassword.encode(request.getParameter("password")));
            user.setFull_name(request.getParameter("full_name"));

            UserService userService = new UserService();
            userService.insertUser(user);
            try {
                List<User> users = new UserService().getUserList();
                request.setAttribute("UserTable", users);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/list_user.jsp");
            requestDispatcher.forward(request, response);
        }

        // delete Users
        if (page.equalsIgnoreCase("removeUsers")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new UserService().deleteUser(id);
            try {
                //Yo paile users delete handa pheri kina naaako vane
                //uta list_user.jsp file ma users ko arraylist ko name UserTable thiyo
                //so tei name call nagare vayera na ako
                //list_user.jsp ma array list ko name same vaye paxi aauxa
                List<User> users = new UserService().getUserList();
                request.setAttribute("UserTable", users);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/list_user.jsp");
            requestDispatcher.forward(request, response);
        }

        if (page.equalsIgnoreCase("oldUsers")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
        if (page.equalsIgnoreCase("UserDetails")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserService().userDetailsRow(id);
            request.setAttribute("user", user);
            request.setAttribute("id", id);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/user_details.jsp");
            requestDispatcher.forward(request, response);

        }
        if (page.equalsIgnoreCase("EditUsers")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserService().userDetailsRow(id);
            request.setAttribute("user", user);
            request.setAttribute("id", id);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/update_user.jsp");
            requestDispatcher.forward(request, response);

        }
        if (page.equalsIgnoreCase("UpdateUsers")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user =  new UserService().userDetailsRow(id);
            //you chai pheri user details ma jana ko lagi update gare paxi
            user.setUser_name(request.getParameter("user_name"));
            user.setFull_name(request.getParameter("full_name"));
            user.setPassword(HashingPassword.encode(request.getParameter("password")));
            try {
                new UserService().userUpdate(user,id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            request.setAttribute("user", user);
            request.setAttribute("id", id);


            //yo user list ma jana ko lagi
//            try {
//                new UserService().userUpdate(user,id);
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//            List<User> users = null;
//            try {
//                users = new UserService().getUserList();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//            request.setAttribute("UserTable", users);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/user_details.jsp");
            requestDispatcher.forward(request, response);

        }

        if (page.equalsIgnoreCase("logoutUsers")) {
            HttpSession session = request.getSession(false);
            session.invalidate();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);

        }
        if (page.equalsIgnoreCase("goToDashboard")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/dashboard.jsp");
            requestDispatcher.forward(request, response);
        }
        if (page.equalsIgnoreCase("searchUser")) {
            String user_name = request.getParameter("username");
            try {
                User user = new UserService().searchUser(user_name);
                request.setAttribute("user", user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/user_details.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}