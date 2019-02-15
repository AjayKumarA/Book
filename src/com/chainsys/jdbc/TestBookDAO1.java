package com.chainsys.jdbc;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import org.xml.sax.Parser;

public class TestBookDAO1 {

	public static void main(String[] args) throws Exception {
		int q = 0;
		BookDOA1 bookdao = new BookDOA1();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter your operation : ");
			System.out.println("1)add 2)modify 3)delete 4)selectall 5)select");
			int a = scanner.nextInt();
			Book book = new Book();
			BookValidator1 validator1 = new BookValidator1();
			
				switch (a) {
				case 1: {
					System.out.println("Enter name : ");
					String name = scanner.next();
					System.out.println("Enter price : ");
					int price = scanner.nextInt();
					System.out.println("Enter date : (YYYY-MM-DD)");
					String publishedDate = scanner.next();
					book.name = name;
					book.price = price;
					book.publishedDate = LocalDate.parse(publishedDate);
					try {
						validator1.validateAdd(book);
						bookdao.addBook(book);
						//bookdao.findAll(book);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
				}
				case 2: {
					String name = scanner.next();
					book.name=name;
					int id = scanner.nextInt();
					book.id=id;
					try {
						validator1.validateUpdate(book);	
						bookdao.updateBook(book);
						bookdao.findAll();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 3: {
					int id = scanner.nextInt();
					book.id = id;
					try {
						validator1.validateDelete(book);
						bookdao.deleteBook(book);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 4: {
					try {
						ArrayList<Book> bookList = bookdao.findAll();
						if(bookList.isEmpty())
						{
							System.out.println("No records found");
						}
						else
						{
							for(Book b : bookList)
							{
								System.out.println(b.id);
								System.out.println(b.name);
								System.out.println(b.price);
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				case 5: {
					try {
						System.out.println("Enter id : ");
						int id = scanner.nextInt();
						book.id = id;
						validator1.validateFindbyId(book);
						Book b = bookdao.findById(book);
						if (b != null) {
							System.out.println(b.id);
							System.out.println(b.name);
							System.out.println(b.price);
						} else {
							System.out.println("No results found");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				default: {
					break;
				}
				}
				System.out.println("Press 1");
				q = scanner.nextInt();
			
		} while (q == 1);
		scanner.close();
	}

}
