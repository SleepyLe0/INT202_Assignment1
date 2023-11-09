package int202.assignment1.servlets;

import int202.assignment1.repositories.OfficeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteOfficeServlet", value = "/delete-office")
public class DeleteOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeCode = request.getParameter("officeCode");
        request.setAttribute("deleteOffice", officeCode);
        if (request.getParameter("confirm") != null) {
            doPost(request, response);
        }else {
            request.getRequestDispatcher("office-home").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteOfficeCode = request.getParameter("officeCode");
        OfficeRepository officeRepository = new OfficeRepository();
        officeRepository.delete(deleteOfficeCode);
        officeRepository.close();
        response.sendRedirect("office-home");
    }
}
