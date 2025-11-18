package murach.test;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
        throws ServletException, IOException {

        System.out.println("DEBUG: TestServlet GET called");
        log("LOG: TestServlet GET called");

        response.getWriter().println("<h1>TestServlet Get</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
        throws ServletException, IOException {

        System.out.println("DEBUG: TestServlet POST called");
        log("LOG: TestServlet POST called");

        response.getWriter().println("<h1>TestServlet Post</h1>");
    }
}
