package service;

import java.sql.SQLException;
import java.util.List;

import Dao.DBConnection;
import Dao.OrderDao;
import bean.Order;
import bean.OrderList;

public class OrderService {
	public void attendOrder(Order order){	
		try {
			DBConnection databaseDao=new DBConnection();
			OrderDao orderDao=new OrderDao();
			orderDao.attendOrder(order, databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public List<Order> orders(){
		List<Order> orderLists=null;
		try {
			DBConnection databaseDao=new DBConnection();			
			OrderDao orderDao=new OrderDao();	
			orderLists=orderDao.orders(databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return orderLists;
	}
	public List<OrderList> Ordershow(int userId){
		List<OrderList> orderLists=null;
		try {
			DBConnection databaseDao=new DBConnection();			
			OrderDao orderDao=new OrderDao();	
			orderLists=orderDao.Ordershow(databaseDao, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return orderLists;
	}
	public Integer update1(String orderId,int userId,int carId,int ordertype){
		try {
			DBConnection databaseDao=new DBConnection();			
			OrderDao orderDao=new OrderDao();		
			return orderDao.update1(orderId,userId,carId,ordertype,databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;		
	}
	public Integer update(String orderId){
		try {
			DBConnection databaseDao=new DBConnection();			
			OrderDao orderDao=new OrderDao();		
			return orderDao.update(orderId,databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;		
	}
	public Integer delete(String orderId){
		try {
			DBConnection databaseDao=new DBConnection();			
			OrderDao orderDao=new OrderDao();		
			return orderDao.delete(orderId,databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;		
	}
}
