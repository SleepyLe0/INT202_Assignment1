package int202.assignment1.servlets;

import int202.assignment1.entities.Office;
import int202.assignment1.repositories.OfficeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateOfficeServlet", value = "/update-office")
public class UpdateOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("cancel") != null) {
            response.sendRedirect("office-home");
        }else {
            String officeCode = request.getParameter("officeCode");
            OfficeRepository officeRepository = new OfficeRepository();
            Office updateOffice = officeRepository.findByOfficeCode(officeCode);
            request.setAttribute("updateOffice", updateOffice);
            request.getRequestDispatcher("/update_office.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Office newOffice = createOfficeFromRequest(request);
        System.out.println(newOffice);
        OfficeRepository officeRepository = new OfficeRepository();
        officeRepository.update(newOffice);
        officeRepository.close();
        response.sendRedirect("office-home");
    }
    public Office createOfficeFromRequest(HttpServletRequest request) {
        String officeCode = request.getParameter("officeCode");
        String city = validateOfficeNotNull(request.getParameter("city"));
        String phone = validateOfficeNotNull(request.getParameter("phone"));
        String addressLine1 = validateOfficeNotNull(request.getParameter("addressLine1"));
        String addressLine2 = validateOfficeNull(request.getParameter("addressLine2"));
        String state = validateOfficeNull(request.getParameter("state"));
        String country = validateOfficeNotNull(request.getParameter("country"));
        String postalCode = validateOfficeNotNull(request.getParameter("postalCode"));
        String territory = validateOfficeNotNull(request.getParameter("territory"));
        return new Office(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory);
    }
    public String validateOfficeNotNull(String parameter) {
        return parameter.equals("") || parameter.isBlank() ? null : parameter.trim();
    }
    public String validateOfficeNull(String parameter) {
        return parameter.equals("") ? null : parameter.trim();
    }
}
