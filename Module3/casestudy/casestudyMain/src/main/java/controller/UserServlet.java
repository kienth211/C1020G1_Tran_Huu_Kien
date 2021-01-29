package controller;

import bean.User;
import service.EmployeeService;
import service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = {"", "/MainServlet"})
public class UserServlet extends HttpServlet {

    private EmployeeService employeeService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser.equals("update")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String country = request.getParameter("country");

            User user = new User(id, name, email, country);
            employeeService.save(user);

            loadList(request, response);
        }

        switch (actionUser) {
            case "create":
                createUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            default:
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "update":
                Integer id = Integer.parseInt(request.getParameter("id"));
                User user = employeeService.findById(id);

                request.setAttribute("userInfo", user);
                request.getRequestDispatcher("update.jsp").forward(request, response);
                break;
            case "create":
                showCreateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "search":
                viewCustomer(request, response);
                break;
            case "search_id":
                viewCustomerId(request, response);
                break;
            default:
                loadList(request, response);
        }

    }

    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userListFromServlet", employeeService.findAll());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User product = new User(name, email, country);
        employeeService.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        request.setAttribute("message", "New user added");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = employeeService.findById(id);

        request.setAttribute("userInfo", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("name"));
        User user = this.employeeService.findById(id);
        RequestDispatcher dispatcher;
        if (user == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            employeeService.deleteById(id);
            dispatcher = request.getRequestDispatcher("delete.jsp");
            request.setAttribute("message", "User deleted");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        User user = this.employeeService.findByName(name);
        RequestDispatcher dispatcher;
        String messenger;
        if(user.getName() == null){
            messenger = "not found";
            request.setAttribute("messenger", messenger);
            dispatcher = request.getRequestDispatcher("view.jsp");
        } else {
            messenger = "";
            request.setAttribute("messenger", messenger);
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewCustomerId(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = this.employeeService.getUserById(id);
        RequestDispatcher dispatcher;
        String messenger;
        if(user.getName() == null){
            messenger = "not found";
            request.setAttribute("messenger", messenger);
            dispatcher = request.getRequestDispatcher("view.jsp");
        } else {
            messenger = "";
            request.setAttribute("messenger", messenger);
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
