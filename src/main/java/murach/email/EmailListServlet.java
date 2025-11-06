/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author baothinh
 */
package murach.email;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import murach.business.User;
import murach.data.UserDB;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";           // default action
        }

        if (action.equals("join")) {
            url = "/index.html";       // trang form
        } else if (action.equals("add")) {
            // get parameters
            String firstName = request.getParameter("firstName");
            String lastName  = request.getParameter("lastName");
            String email     = request.getParameter("email");

            // store data and save
            User user = new User(firstName, lastName, email);
            UserDB.insert(user);       // đảm bảo có class UserDB và method insert

            // set attribute & forward
            request.setAttribute("user", user);
            url = "/thanks.jsp";
        }

        // forward
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        // chuyển GET về POST cho gọn
        doPost(request, response);
    }
}
