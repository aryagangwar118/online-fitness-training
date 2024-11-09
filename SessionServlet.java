import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            try {
                Connection con = DBConnection.getConnection();
                String query = "SELECT s.session_id, s.session_name, s.description, s.date, s.time, t.name AS trainer_name FROM sessions s INNER JOIN trainers t ON s.trainer_id = t.trainer_id";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                ArrayList<Session> sessions = new ArrayList<>();
                while (rs.next()) {
                    Session session = new Session(
                        rs.getInt("session_id"),
                        rs.getString("session_name"),
                        rs.getString("description"),
                        rs.getDate("date").toString(),
                        rs.getTime("time").toString(),
                        rs.getString("trainer_name")
                    );
                    sessions.add(session);
                }
                con.close();

                String json = new Gson().toJson(sessions);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            int userId = Integer.parseInt(request.getParameter("user_id"));
            int sessionId = Integer.parseInt(request.getParameter("session_id"));

            try {
                Connection con = DBConnection.getConnection();
                String query = "INSERT INTO registrations (user_id, session_id) VALUES (?, ?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, userId);
                ps.setInt(2, sessionId);
                ps.executeUpdate();
                con.close();

                response.sendRedirect("sessions.html");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
