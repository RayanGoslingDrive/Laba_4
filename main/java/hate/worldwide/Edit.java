package hate.worldwide;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;

import com.mysql.cj.jdbc.Driver;


public class Edit extends HttpServlet {
    Connection connection;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/bands_database", "root", "");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = String.format("select * from bands where index=" + request.getParameter("id"));
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Bands temp = new Bands(resultSet.getString("Bandname"),
                        resultSet.getString("hometown"),
                        resultSet.getString("genre"),
                        resultSet.getString("last_ablbum"),
                        resultSet.getString("Singer"),
                        resultSet.getInt("idInDatabase"));
                request.setAttribute("bands",temp);
            }
            sc.getRequestDispatcher("/edit.html").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}