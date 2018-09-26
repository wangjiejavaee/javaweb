package service;

import java.sql.SQLException;
import java.util.List;

import Dao.BookDao;
import Dao.DBConnection;
import bean.Book;

public class BookService {
	public void insert(Book book){
		try {
			DBConnection databaseDao=new DBConnection();
			BookDao bookDao=new BookDao();
			bookDao.insert(book, databaseDao);
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public Integer update(int bookid,String name,String author,String price,String title,String intro){
		try {
			DBConnection databaseDao=new DBConnection();
			BookDao bookDao=new BookDao();
			return bookDao.update(bookid, name, author, price, title, intro, databaseDao);
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;	
	}
	public List<Book> Bookshow(){
		List<Book> books=null;
		try {
			DBConnection databaseDao=new DBConnection();			
			BookDao bookDao=new BookDao();		
			books=bookDao.Bookshow(databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return books;
	}
	public Integer delete(int bookid){
		try {
			DBConnection databaseDao=new DBConnection();			
			BookDao bookDao=new BookDao();			
			return bookDao.delete(bookid, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;		
	}
}
