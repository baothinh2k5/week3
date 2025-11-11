/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.email;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import murach.business.User;
import murach.data.UserDB;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // hỗ trợ Unicode
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String url = "/index.html";

        // lấy action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join"; // mặc định quay về form
        }

        if ("join".equals(action)) {
            url = "/index.html";
        } else if ("add".equals(action)) {
            // ====== lấy hết tham số từ form ======
            // text inputs
            String firstName = request.getParameter("firstName");
            String lastName  = request.getParameter("lastName");
            String email     = request.getParameter("email");

            // date (có thể để trống)
            String dob       = request.getParameter("dob"); // yyyy-MM-dd hoặc null/"" 

            // radio
            String source    = request.getParameter("source"); // Search engine / Word of mouth / ...

            // checkboxes: nếu không tick sẽ = null
            // chấp nhận cả 2 tên để tránh lệch name ở HTML
            String likeAnnouncementsParam  = request.getParameter("likeAnnouncements");
            if (likeAnnouncementsParam == null) {
                likeAnnouncementsParam = request.getParameter("announcements");
            }
            String emailAnnouncementsParam = request.getParameter("emailAnnouncements");

            // select
            String contact   = request.getParameter("contact");

            // ====== lưu DB (nếu User chỉ có 3 trường như sách Murach) ======
            User user = new User(firstName, lastName, email);
            try {
                UserDB.insert(user);
            } catch (Exception ex) {
                // không để app chết nếu DB demo chưa cấu hình
                // có thể log ra server log nếu cần
            }

            // ====== chuẩn hoá chuỗi hiển thị ======
            String dobText = (dob == null || dob.isBlank()) ? "—" : dob;
            String sourceText = (source == null || source.isBlank()) ? "—" : source;
            String likeAnnouncementsText  = (likeAnnouncementsParam  != null) ? "YES, I'd like that." : "No";
            String emailAnnouncementsText = (emailAnnouncementsParam != null) ? "YES, please send me email announcements." : "No";
            String contactText = (contact == null || contact.isBlank()) ? "—" : contact;

            // ====== đẩy attribute sang JSP ======
            request.setAttribute("user", user);                // firstName, lastName, email
            request.setAttribute("dob", dobText);
            request.setAttribute("source", sourceText);
            request.setAttribute("likeAnnouncements", likeAnnouncementsText);
            request.setAttribute("emailAnnouncements", emailAnnouncementsText);
            request.setAttribute("contact", contactText);

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
        // gom GET về POST
        doPost(request, response);
    }
}
