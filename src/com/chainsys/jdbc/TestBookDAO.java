package com.chainsys.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class TestBookDAO {

	public static void main(String[] args) throws SQLException {
		int q = 0;
		Scanner scanner = new Scanner(System.in);
		do{
		System.out.println("Enter your operation : ");
		System.out.println("1)add 2)modify 3)delete 4)selectall 5)select");
        int a = scanner.nextInt();
        BookDAO bookDAO = new BookDAO();
        BookValidator validator=new BookValidator();
       try {
		switch(a)
		   {
		   case 1:
		   {
			  System.out.println("Enter name : ");
			  String name = scanner.next();
			  System.out.println("Enter price : ");
			  int price = scanner.nextInt();
			  System.out.println("Enter Id :");
			  int id = scanner.nextInt();
			  try {
				 validator.validateBook(name,price);
				 bookDAO.addBook(name,price,id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  bookDAO.findAll();
			  break;
		   }
		   case 2 :
		   {
			   String name = scanner.next();
			   int id = scanner.nextInt();
			   bookDAO.updateBook(name, id);
			   break;
		   }
		   case 3 : 
		   {
			   int id = scanner.nextInt();
			   bookDAO.deleteBook(id);
			   break;
		   }
		   case 4 :
		   {
			   bookDAO.findAll();
			   break;
		   }
		   case 5:
		   {
			   int id = scanner.nextInt();
			   bookDAO.findById(id);
			   break;
		   }
		   default :
		   {
			   break;
		   }
   }
		System.out.println("Press 1");
		q = scanner.nextInt();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
		while(q==1);
        scanner.close();
	}

}
