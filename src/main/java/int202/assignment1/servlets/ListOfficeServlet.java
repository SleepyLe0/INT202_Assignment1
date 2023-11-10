package int202.assignment1.servlets;

import int202.assignment1.repositories.OfficeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ListOfficeServlet", value = "/office-home")
public class ListOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        if (request.getAttribute("officeList") == null) {
            request.setAttribute("officeList", officeRepository.findAll());
        }
        officeRepository.close();
        request.getRequestDispatcher("/office_home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        OfficeRepository officeRepository = new OfficeRepository();
        request.setAttribute("officeList", officeRepository.search(search));
        request.setAttribute("search", search);
        if (request.getParameter("clear") != null) {
            response.sendRedirect("office-home");
        }else {
            doGet(request, response);
        }
    }
}
