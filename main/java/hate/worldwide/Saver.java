package hate.worldwide;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.jdbc.Driver;


public class Saver extends HttpServlet {
    Connection connection;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/bands_database", "Admin", "12345678");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String data = request.getReader().readLine();
        Bands bands = gson.fromJson(data, Bands.class);
        String query = String.format("update bands set Bandname='%s', hometown='%s', genre='%s', last_ablbum='%s', Singer='%s' where idInDatabase='%d'",
                bands.getBandname(),
                bands.getHometown(),
                bands.getGenre(),
                bands.getlast_ablbum(),
                bands.getSinger(),
                bands.getIdInDatabase());
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.getRequestDispatcher("/read.html").forward(request, response);
    }
}