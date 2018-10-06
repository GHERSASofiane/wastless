package com.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import configuration.connection;

/**
 * Servlet implementation class Dessert
 */
public class Dessert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Dessert() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection db = connection.getConnection();
			Statement stmt = db.createStatement();
			stmt.executeUpdate("CREATE TABLE Booking (BookingId int(11) NOT NULL, BookingDated varchar(15) NOT NULL, ProductId int(11) NOT NULL, UserId int(11) NOT NULL )");
	        // stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
	        // stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
		 
			System.out.println("BRAVOOOO !!!!!!!!!!!");
	    //     while (rs.next()) {
	    //         response.getWriter().println("Read from DB: " + rs.getTimestamp("tick"));
	    //    // 	System.out.println("Read from DB: " + rs.getTimestamp("tick"));
	    //     }
			  
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// response.getWriter().println("Read from DB: ");
		// request.getRequestDispatcher("WEB-INF/dessert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
