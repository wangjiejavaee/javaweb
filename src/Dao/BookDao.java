package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Book;


public class BookDao {
	public void insert(Book book,DBConnection databaseDao)throws SQLException{
		String sql="insert into book(name,author,price,title,intro) values('"+book.getName()+"','"+
	    book.getAuthor()+"','"+book.getPrice()+"','"+book.getTitle()+"','"+book.getIntro()+"')";
		databaseDao.update(sql);
	}
	
	public Integer update(int bookid,String name,String author,String price,String title,String intro,DBConnection databaseDao)throws SQLException{
		String sql="update book set bookid='"+bookid+"',name='"+name+"',author='"+author+
				"',price='"+price+"',title='"+title+"',intro='"+intro+"'where bookid="+bookid;
		return databaseDao.update(sql);
	}
	
	public List<Book> Bookshow(DBConnection databaseDao) throws SQLException{
		List<Book> books=new ArrayList<Book>(); 
		String sql="select * from  book";
		databaseDao.query(sql);
		while (databaseDao.next()) {
			Book book=new Book();
			book.setAuthor(databaseDao.getString("author"));
			book.setBookimg(databaseDao.getString("bookimg"));
			book.setIntro(databaseDao.getString("intro"));
			book.setName(databaseDao.getString("name"));
			book.setPrice(databaseDao.getString("price"));
			book.setTitle(databaseDao.getString("title"));
			book.setBookid(databaseDao.getInt("bookid"));
			books.add(book);	
		}		
		return books;
	}	
	public Integer delete(int bookid,DBConnection databaseDao)throws SQLException{//查询失败返回-1
		String sql = "delete from book where bookid ="+bookid;
		return databaseDao.update(sql);
}
}
