package murach.business;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/survey")
public class SurveyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // Lấy 6 tham số từ form
        String email      = request.getParameter("email");
        String firstName  = request.getParameter("firstName");
        String lastName   = request.getParameter("lastName");
        String heardFrom  = request.getParameter("heardFrom");
        String updates    = request.getParameter("updates");
        String contactVia = request.getParameter("contactVia");

        if (updates == null) {
            updates = "No";
        }

        // Tạo đối tượng User
        User user = new User(email, firstName, lastName, heardFrom, updates, contactVia);

        // Đưa object sang JSP
        request.setAttribute("user", user);

        // Forward sang survey.jsp
        getServletContext()
                .getRequestDispatcher("/survey.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
