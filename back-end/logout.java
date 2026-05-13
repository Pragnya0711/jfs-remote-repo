import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Logout extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Get current session (if exists)
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate(); // destroy session
        }

        // Redirect to logout page
        response.sendRedirect("logout.html");
    }
}
