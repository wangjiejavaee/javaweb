package service;

import java.sql.SQLException;
import java.util.List;

import Dao.CarDao;
import Dao.DBConnection;
import bean.Car;
import bean.CarList;

public class CarService {
	public void attendCar(Car car){	
		try {
			DBConnection databaseDao=new DBConnection();
			CarDao carDao=new CarDao();
			carDao.attendCar(car, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public List<CarList> Carshow(int userId){
		List<CarList> carLists=null;
		try {
			DBConnection databaseDao=new DBConnection();			
			CarDao carDao=new CarDao();		
			carLists=carDao.Carshow(databaseDao, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return carLists;
	}
	
	public Integer delete(int carid){
		try {
			DBConnection databaseDao=new DBConnection();			
			CarDao carDao=new CarDao();		
			return carDao.delete(carid, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;		
	}
	
	public Integer update(int carid,int number){
		try {
			DBConnection databaseDao=new DBConnection();			
			CarDao carDao=new CarDao();		
			return carDao.update(carid, number,databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;		
	}
	public Integer deletes(int userId){
		try {
			DBConnection databaseDao=new DBConnection();			
			CarDao carDao=new CarDao();		
			return carDao.deletes(userId, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;		
	}
}
