package com.sehir.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import sehir.com.model.RequestCustomer;
import sehir.com.model.ResponseCustomer;

public class CustomerService {
	
	public ResponseCustomer createCustomer(RequestCustomer request){
		ResponseCustomer response = new ResponseCustomer();
		Connection conn = getConnection();
		String id = idGenerator();
		String sql = "INSERT INTO Customer (id, name, surname, city) VALUES (?, ?, ?, ?)"; 
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, request.getName());
			statement.setString(3, request.getSurname());
			statement.setString(4, request.getCity());
			
			int rowsInserted = statement.executeUpdate();			
			
			if (rowsInserted > 0) {
				response.setId(id);
				System.out.println("A new user was inserted successfully!" + "New user id :" + response.getId());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public String idGenerator(){

		Random r = new Random();
		int Low = 10;
		int High = 100;
		int id = r.nextInt(High-Low) + Low;
		return String.valueOf(id);
	}		
    		
	public Connection getConnection(){
       	String dbURL = "jdbc:mysql://localhost:3306/customer";
		String username = "root";
		String password = "root";
		Connection conn = null;
        try {
			conn = DriverManager.getConnection(dbURL,username, password);
		} catch (SQLException e) {

			e.printStackTrace();
		}
        return conn;
	}
}
