package com.example.WebApplicationProject;

import model.User;
import service.UserService;

import java.io.*;
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

    public void init() {
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");

        if (page.equalsIgnoreCase("register")) {
            User user = new User();
            user.setUser_name(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
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
                out.print("Unable to login! Either username or password is incorrect");
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
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/register.jsp");
            requestDispatcher.forward(request, response);
        }
        if (page.equalsIgnoreCase("addUsers")) {
            User user = new User();
            user.setUser_name(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setFull_name(request.getParameter("full_name"));

            UserService userService = new UserService();
            userService.insertUser(user);

            out.print("User successfully added!!!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/add_user.jsp");
            requestDispatcher.forward(request, response);
        }


        if (page.equalsIgnoreCase("removeUsers")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new UserService().deleteUser(id);
            try {
                List<User> arraylist = new UserService().getUserList();
                request.setAttribute("arrayList", arraylist);

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
        if (page.equalsIgnoreCase("UpdateUsers")) {

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

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}