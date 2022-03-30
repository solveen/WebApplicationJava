package com.example.WebApplicationProject;

import model.User;
import service.UserService;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
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
            if (username != null) {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("username", username);
                httpSession.setAttribute("password", password);

                Cookie user_cookie = new Cookie("username", username);
                response.addCookie(user_cookie);


                RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/dashboard.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.include(request, response);
            }
        }
// table ko values display hanna ko lagi
        if (page.equalsIgnoreCase("UserLists")) {
            ArrayList<User> users = new ArrayList<>();
            User user = new User();
            UserService userService = new UserService();
            try {
                users = (ArrayList<User>) userService.getUserList();
                request.setAttribute("UserTable", users);
                request.setAttribute("user", user);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/list_user.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e){
                e.printStackTrace();

            }
//            try{
//                List<User> ArraylistUser = new ArrayList<>();
//
//            }catch (SQLException e)

        }
        if (page.equalsIgnoreCase("newUsers")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/register.jsp");
            requestDispatcher.forward(request,response);
        }
        if (page.equalsIgnoreCase("oldUsers")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }
        if (page.equalsIgnoreCase("EditUsers")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/update_user.jsp");
            requestDispatcher.forward(request,response);

        }
        if (page.equalsIgnoreCase("DeleteUsers")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("list_user.jsp");
            requestDispatcher.forward(request,response);
        }
        if (page.equalsIgnoreCase("logoutUsers")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
            HttpSession session = request.getSession(false);
            session.invalidate();
        }
        if(page.equalsIgnoreCase("goToDashboard")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/dashboard.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}