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
			stmt.executeUpdate("CREATE TABLE Booking (BookingId int NOT NULL,BookingDated varchar(15) NOT NULL,ProductId int NOT NULL,UserId int NOT NULL )");
			stmt.executeUpdate("CREATE TABLE Product (ProductId int NOT NULL,ProductName varchar(50) NOT NULL,ProductDescription varchar(200) NOT NULL,ProductPrice int NOT NULL,ProductPicture varchar(100) NOT NULL,ProductStatus int NOT NULL DEFAULT '0',UserId int NOT NULL )");
			stmt.executeUpdate("CREATE TABLE User (UserId int NOT NULL,UserMail varchar(50) NOT NULL,UserName varchar(10) NOT NULL,UserPassword varchar(20) NOT NULL,UserPhone int NOT NULL,UserAdress varchar(100) NOT NULL,UserProfilePicture varchar(100) NOT NULL )");
			stmt.executeUpdate("CREATE TABLE Weather (WeatherId int NOT NULL,Dated varchar(15) NOT NULL,Degree varchar(10) NOT NULL,Description varchar(50) NOT NULL )");
			// stmt.executeUpdate("");
			// stmt.executeUpdate("");
			// stmt.executeUpdate("");
			// stmt.executeUpdate("");
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
