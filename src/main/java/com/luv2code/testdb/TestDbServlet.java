package com.luv2code.testdb;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.PrintWriter;
import java.sql.*;

import java.io.IOException;

@WebServlet(name = "TestDbServlet", value = "/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //setup connection variable
        String name = "springstudent";
        String pass = "springstudent";
        String url= "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=FALSE&serverTimezone=UTC";
        String driver= "com.mysql.cj.jdbc.Driver";
        try {
            PrintWriter out= response.getWriter();
            out.println("Connecting to database......"+url);
            Class.forName(driver);
            Connection connection= DriverManager.getConnection(url,name,pass);

            out.println("Connection successful");


        }catch (Exception e){
            e.printStackTrace();
        }

        //get connetion to database
    }


}
