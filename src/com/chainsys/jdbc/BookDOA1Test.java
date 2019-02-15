package com.chainsys.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BookDOA1Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddBook() throws Exception {
		// fail("Not yet implemented");
		BookDOA1 bookDOA1 = new BookDOA1();
		Book book = new Book();
		book.id = 1;
		book.name = "arvinddddddd";
		book.price = 5678;
		book.publishedDate = LocalDate.parse("2019-09-09");
		bookDOA1.addBook(book);

		Book book1 = new Book();
		book1.id = 1;
		Book b = bookDOA1.findById(book1);

		assertEquals(book.price, b.price);
	}

	@Test
	public void testUpdateBook() throws SQLException {
		BookDOA1 bookDOA1 = new BookDOA1();
		Book book = new Book();
		book.id = 21;

		Book book1 = new Book();

		Book b = bookDOA1.findById(book);
		assertEquals(book.id, b.id);
		b.name = "c";
		bookDOA1.updateBook(b);

		// fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testDeleteBook() throws SQLException {
		// fail("Not yet implemented");
		BookDOA1 bookDOA1 = new BookDOA1();
		Book book = new Book();
		book.id = 21;
		
		Book b = bookDOA1.findById(book);
		assertEquals(book.id, b.id);
		bookDOA1.deleteBook(book);
		
	}

	@Test
	public void testFindAll() throws Exception {
		BookDOA1 bookDOA1 = new BookDOA1();
		bookDOA1.findAll();
		// fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

}
