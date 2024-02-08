package ru.mixer.javaenterprisepractice.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LibraryServlet", value = "/LibraryServlet")
public class LibraryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaeepractice",
                    "root", "165268");


            Statement s = c.createStatement();
            String sql = "SELECT title from books";
            ResultSet rs = s.executeQuery(sql);
            PrintWriter pw = response.getWriter();
            while (rs.next()){
                pw.println(rs.getString("title"));
            }
            s.close();
            pw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
