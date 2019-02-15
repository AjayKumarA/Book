package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import oracle.net.aso.b;

public class BookDOA1 {
	  /*
	   * precondition id,name,price must be valid
	   */
      public  void addBook(Book book) throws Exception
      {
    	  try {
			Connection connection = ConnectionUtil.getConnection();
			  String sql = "insert into books(id,name,price,publishedDate)values(?,?,?,?)";
			  PreparedStatement preparedStatement = connection.prepareStatement(sql);
			  preparedStatement.setInt(1, book.id);
			  preparedStatement.setString(2, book.name);
			  preparedStatement.setInt(3, book.price);
			  preparedStatement.setDate(4, Date.valueOf(book.publishedDate));
			  int rows = preparedStatement.executeUpdate();
			  System.out.println("Rows affected: " + rows);
			  ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Unable to insert book");
		}
      }
      
      public void updateBook(Book book) throws SQLException
      {
    	Connection connection = ConnectionUtil.getConnection();
    	String sql1 = "update books set name = ? where id = ?";
  		PreparedStatement preparedStatement = connection.prepareStatement(sql1);
  		preparedStatement.setString(1, book.name);
  		preparedStatement.setInt(2, book.id);
  		int rows = preparedStatement.executeUpdate();
  		System.out.println("Rows affected: " + rows);
  		ConnectionUtil.close(connection, preparedStatement, null);
      }
      
      public void deleteBook(Book book) throws SQLException
      {
    	Connection connection = ConnectionUtil.getConnection();
    	String sql2 = "Delete from books where id = ?";
  	    PreparedStatement preparedStatement = connection.prepareStatement(sql2);
  		preparedStatement.setInt(1, book.id);
  		int rows = preparedStatement.executeUpdate();
  		System.out.println("Rows affected: " + rows);
  		ConnectionUtil.close(connection, preparedStatement, null);
      }
      
      public ArrayList<Book> findAll() throws Exception {
      
			ArrayList<Book> booklist = new ArrayList<Book>();
			
			Connection connection = ConnectionUtil.getConnection();
			String sql3 = "select id,name,price from books";
			PreparedStatement preparedStatement = connection.prepareStatement(sql3);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book1 = new Book();
				book1.id = resultSet.getInt("id");
				book1.name = resultSet.getString("name");
				book1.price = resultSet.getInt("price");
				
				booklist.add(book1);
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
     
          return booklist;
		}  
      public Book findById(Book book) throws SQLException 
      {
    	
    	Connection connection = ConnectionUtil.getConnection();
    	String sql4 = "select id,name,price,publishedDate from books where id = ?";
  	    PreparedStatement preparedStatement = connection.prepareStatement(sql4);
  		preparedStatement.setInt(1, book.id);
  		ResultSet resultSet = preparedStatement.executeQuery();
  		Book book1 = null;
  		if (resultSet.next()) {
  			book1 = new Book();
  			book1.id = resultSet.getInt("id");
  			book1.name = resultSet.getString("name");
  			book1.price = resultSet.getInt("price");
  			//Get SQL Date
  			Date d = resultSet.getDate("publishedDate");
  			//Convert SQL Date to LocalDate
  			LocalDate ld = d.toLocalDate();
  			book1.publishedDate=ld;
  		}
  		 ConnectionUtil.close(connection, preparedStatement, resultSet);
  		return book1;
      }
      
}

