package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
	  /*
	   * precondition id,name,price must be valid
	   */
      public void addBook( String name, int price,int id) throws Exception
      {
    	  try {
			Connection connection = ConnectionUtil.getConnection();
			  String sql = "insert into books(id,name,price)values(?,?,?)";
			  PreparedStatement preparedStatement = connection.prepareStatement(sql);
			  preparedStatement.setString(1, name);
			  preparedStatement.setInt(2, price);
			  int rows = preparedStatement.executeUpdate();
			  System.out.println("Rows affected: " + rows);
			  ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Unable to insert book");
		}
      }
      
      public void updateBook(String name, int id) throws SQLException
      {
    	Connection connection = ConnectionUtil.getConnection();
    	String sql1 = "update books set name = ? where id = ?";
  		PreparedStatement preparedStatement = connection.prepareStatement(sql1);
  		preparedStatement.setString(1, name);
  		preparedStatement.setInt(2, id);
  		int rows = preparedStatement.executeUpdate();
  		System.out.println("Rows affected: " + rows);
  		ConnectionUtil.close(connection, preparedStatement, null);
      }
      
      public void deleteBook(int id) throws SQLException
      {
    	Connection connection = ConnectionUtil.getConnection();
    	String sql2 = "Delete from books where id = ?";
  	    PreparedStatement preparedStatement = connection.prepareStatement(sql2);
  		preparedStatement.setInt(1, id);
  		int rows = preparedStatement.executeUpdate();
  		System.out.println("Rows affected: " + rows);
  		ConnectionUtil.close(connection, preparedStatement, null);
      }
      
      public void findAll() throws SQLException
      {
    	Connection connection = ConnectionUtil.getConnection();
     	String sql3 = "select id,name,price from books";
  	    PreparedStatement preparedStatement = connection.prepareStatement(sql3);
  		ResultSet resultSet = preparedStatement.executeQuery();
  		while (resultSet.next()) {
  			System.out.println();
  			System.out.print(resultSet.getInt("id"));
  			System.out.print(resultSet.getString("name"));
  			System.out.print(resultSet.getInt("price"));
  			
  		}
  		ConnectionUtil.close(connection, preparedStatement, resultSet);
      }
      
      public void findById(int id) throws SQLException 
      {
    	Connection connection = ConnectionUtil.getConnection();
    	String sql4 = "select id,name,price from books where id = ?";
  	    PreparedStatement preparedStatement = connection.prepareStatement(sql4);
  		preparedStatement.setInt(1, id);
  		ResultSet resultSet = preparedStatement.executeQuery();
  		if (resultSet.next()) {
  			System.out.println(resultSet.getInt("id"));
  			System.out.println(resultSet.getString("name"));
  			System.out.println(resultSet.getInt("price"));
  		}
  		 ConnectionUtil.close(connection, preparedStatement, resultSet);
      }
}
