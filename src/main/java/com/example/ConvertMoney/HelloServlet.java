package com.example.ConvertMoney;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/convert")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Convert";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));

        float vnd = rate * usd;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Rate: " + rate+ "</h1>");
        writer.println("<h1>USD: " + usd+ "</h1>");
        writer.println("<h1>VND: " + vnd+ "</h1>");
        writer.println("</html>");
    }

    public void destroy() {
    }
}