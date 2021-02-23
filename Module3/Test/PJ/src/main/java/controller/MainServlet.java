package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainServlet",urlPatterns = {"","/MainServlet"})
public class MainServlet extends HttpServlet {
    String actionUser;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//
//        actionUser = request.getParameter("actionUser");
//
//        if (actionUser == null) {
//            actionUser = "";
//        }
        request.getRequestDispatcher("MainPage.jsp").forward(request, response);
    }
}
