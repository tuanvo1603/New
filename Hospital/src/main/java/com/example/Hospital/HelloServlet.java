package com.example.Hospital;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("text/html");

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phoneNumber = request.getParameter("phoneNumber");
            String emergencyContact = request.getParameter("emergencyContact");
            String depositAmount = request.getParameter("depositAmount");
            String admittedTime = request.getParameter("admittedTime");
            String insurance = request.getParameter("insurance");
            String dischargeTime = request.getParameter("dischargeTime");
            String patientType = request.getParameter("patientType");

            // Process the form data as required (e.g., store in a database)

            // Generate the HTML response
            String htmlResponse = "<html><body><h2>Patient Information:</h2>"
                    + "<table>"
                    + "<tr><td>First Name:</td><td>" + firstName + "</td></tr>"
                    + "<tr><td>Last Name:</td><td>" + lastName + "</td></tr>"
                    + "<tr><td>Phone Number:</td><td>" + phoneNumber + "</td></tr>"
                    + "<tr><td>Emergency Contact:</td><td>" + emergencyContact + "</td></tr>"
                    + "<tr><td>Deposit Amount:</td><td>" + depositAmount + "</td></tr>"
                    + "<tr><td>Admitted Time:</td><td>" + admittedTime + "</td></tr>"
                    + "<tr><td>Insurance:</td><td>" + insurance + "</td></tr>"
                    + "<tr><td>Discharge Time:</td><td>" + dischargeTime + "</td></tr>"
                    + "<tr><td>Patient Type:</td><td>" + patientType + "</td></tr>"
                    + "</table></body></html>";

            response.getWriter().println(htmlResponse);
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doGet(request, response);
    }

    public void destroy() {
    }
}