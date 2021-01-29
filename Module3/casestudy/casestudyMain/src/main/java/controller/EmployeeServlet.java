package controller;

import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "update":
//                Integer id = Integer.parseInt(request.getParameter("id"));
//                User user = userService.findById(id);
//
//                request.setAttribute("userInfo", user);
//                request.getRequestDispatcher("update.jsp").forward(request, response);
                break;
//            case "create":
////                showCreateForm(request, response);
//                break;
//            case "delete":
////                showDeleteForm(request, response);
//                break;
//            case "search":
////                viewCustomer(request, response);
//                break;
//            case "search_id":
////                viewCustomerId(request, response);
//                break;
            default:
                loadList(request, response);
        }
    }

    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employeeListFromServlet", employeeService.findAll());
        request.getRequestDispatcher("MainPage.jsp").forward(request, response);
    }
}
