import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListServlet", urlPatterns = {""})
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Kiên", "25/01/2021", "Kiên", "img/img_fjords.jpg"));
        customerList.add(new Customer("Sơn", "26/01/2021", "Sơn", "img/img_forest.jpg"));
        customerList.add(new Customer("Tuấn", "27/01/2021", "Tuấn", "img/img_lights.jpg"));
        customerList.add(new Customer("Dũng", "28/01/2021", "Dũng", "img/img_mountains.jpg"));

        request.setAttribute("customerListFromServlet", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
