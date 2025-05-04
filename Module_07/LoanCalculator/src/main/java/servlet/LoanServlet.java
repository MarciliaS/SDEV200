package servlet;

import model.Loan;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/LoanServlet")
public class LoanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Read user input from the form
        double amount = Double.parseDouble(request.getParameter("amount"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        int years = Integer.parseInt(request.getParameter("years"));

        // Calculate loan payments
        Loan loan = new Loan(rate, years, amount);
        double monthly = loan.getMonthlyPayment();
        double total = loan.getTotalPayment();

        // Generate HTML response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Loan Payment Results</h2>");
        out.println("<p>Monthly Payment: $" + String.format("%.2f", monthly) + "</p>");
        out.println("<p>Total Payment: $" + String.format("%.2f", total) + "</p>");
        out.println("</body></html>");
    }
}

