import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

            // Check if username or email already exists
            PreparedStatement checkUser = con.prepareStatement("SELECT * FROM users WHERE username=? OR email=?");
            checkUser.setString(1, username);
            checkUser.setString(2, email);
            if (checkUser.executeQuery().next()) {
                out.println("<h1>Signup Failed</h1>");
                out.println("<h3>Username or Email already exists. Please choose a different username or email.</h3>");
            } else {
                // Insert new user
                PreparedStatement ps = con.prepareStatement("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");
                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, password);
                int result = ps.executeUpdate();
                if (result > 0) {
                    out.println("<h1>Signup Successful</h1>");
                    out.println("<h3>Welcome, " + username + "!</h3>");
                } else {
                    out.println("<h1>Signup Failed</h1>");
                    out.println("<h3>There was an error processing your request. Please try again.</h3>");
                }
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
