import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple validation (static username & password)
        if ("admin".equals(username) && "1234".equals(password)) {
            out.println("<h2>Login Successful!</h2>");
            out.println("<a href='logout.html'>Logout</a>");
        } else {
            out.println("<h2>Invalid Username or Password</h2>");
            out.println("<a href='login.html'>Try Again</a>");
        }

        out.close();
    }
}
