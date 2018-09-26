package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Car;
import bean.CarList;

public class CarDao {
	public void attendCar(Car car,DBConnection databaseDao) throws SQLException{
		String sql="insert into car(bookid,userId,number) values('"+
				car.getBookid()+"','"+car.getUserId()+"','"+car.getNumber()+"')";
		databaseDao.update(sql);
	}
	public List<CarList> Carshow(DBConnection databaseDao,int userId) throws SQLException{
		List<CarList> carLists=new ArrayList<CarList>(); 
		String sql="select carid,book.name bookname,price,number,user.name username from book,user,car where car.userId=user.userId and car.bookid=book.bookid and user.userId="+userId;
		databaseDao.query(sql);
		while (databaseDao.next()) {
			CarList carList=new CarList();
			String sum = Float.parseFloat(databaseDao.getString("price"))*databaseDao.getInt("number")+"";
			carList.setCarid(databaseDao.getInt("carid"));
			carList.setBookname(databaseDao.getString("bookname"));
			carList.setUsername(databaseDao.getString("username"));
			carList.setPrice(databaseDao.getString("price"));
			carList.setNumber(databaseDao.getInt("number"));
			carList.setSum(sum);
			carLists.add(carList);	
		}		
		return carLists;
	}	
	
	public Integer delete(int carid,DBConnection databaseDao)throws SQLException{//查询失败返回-1
			String sql = "delete from car where carid ="+carid;
			return databaseDao.update(sql);
	}
	public Integer update(int carid,int number, DBConnection databaseDao)throws SQLException{//查询失败返回-1
		String sql = "update car set number='"+number+"' where carid ="+carid;
		return databaseDao.update(sql);
  }
	public Integer deletes(int userId,DBConnection databaseDao)throws SQLException{//查询失败返回-1
		String sql = "delete from car where userId ="+userId;
		return databaseDao.update(sql);
 }
}
