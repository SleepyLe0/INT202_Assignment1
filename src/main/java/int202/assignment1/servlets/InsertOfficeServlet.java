package int202.assignment1.servlets;

import int202.assignment1.entities.Office;
import int202.assignment1.repositories.OfficeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "OfficeServlet", value = "/insert-office")
public class InsertOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("cancel") != null) {
            response.sendRedirect("office-home");
        } else {
            request.getRequestDispatcher("/insert_office.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Office newOffice = createOfficeFromRequest(request);
        OfficeRepository officeRepository = new OfficeRepository();
        if (!officeRepository.insert(newOffice)) {
            request.setAttribute("error", "Please enter all information correctly!!!");
            doGet(request, response);
        }else {
            response.sendRedirect("office-home");
        }
    }

    public Office createOfficeFromRequest(HttpServletRequest request) {
        String officeCode = validateOffice(request.getParameter("officeCode"));
        String city = validateOffice(request.getParameter("city"));
        String phone = validateOffice(request.getParameter("phone"));
        String addressLine1 = validateOffice(request.getParameter("addressLine1"));
        String addressLine2 = validateOffice(request.getParameter("addressLine2"));
        String state = validateOffice(request.getParameter("state"));
        String country = validateOffice(request.getParameter("country"));
        String postalCode = validateOffice(request.getParameter("postalCode"));
        String territory = validateOffice(request.getParameter("territory"));
        return new Office(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory);
    }

    public String validateOffice(String parameter) {
        return parameter.equals("") ? null : parameter.trim();
    }

}
