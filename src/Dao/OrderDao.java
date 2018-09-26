package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Order;
import bean.OrderList;

public class OrderDao {
	public void attendOrder(Order order,DBConnection databaseDao) throws SQLException{
		String sql="INSERT INTO `order`(carId,userId,orderId,ordertype) VALUES('"+
				order.getCarId()+"','"+order.getUserId()+"','"+order.getOrderId()+"','"+order.getOrdertype()+"')";
		databaseDao.update(sql);
	}
	public List<Order> orders(DBConnection databaseDao)throws SQLException{
		List<Order> orders=new ArrayList<Order>();
		String sql="select * from `order`";
		databaseDao.query(sql);
		while (databaseDao.next()) {
			Order order=new Order();
			order.setCarId(databaseDao.getInt("carId"));
			order.setOrderData(databaseDao.getTimestamp("orderData"));
			order.setOrderId(databaseDao.getString("orderId"));
			order.setOrdertype(databaseDao.getInt("ordertype"));
			order.setUserId(databaseDao.getInt("userId"));
			orders.add(order);
		}
		return orders;
	}
	
	public List<OrderList> Ordershow(DBConnection databaseDao,int userId) throws SQLException{
		List<OrderList> orderLists=new ArrayList<OrderList>(); 
		String sql="select orderId,orderData,ordertype,book.name bookname,price,number,user.name username from book,user,car,`order`where `order`.userId=user.userId and `order`.carId=car.carid and car.bookid=book.bookid and user.userId="+userId;
		databaseDao.query(sql);
		while (databaseDao.next()) {
			OrderList orderList=new OrderList();
			String sum = Float.parseFloat(databaseDao.getString("price"))*databaseDao.getInt("number")+"";
			orderList.setOrderId(databaseDao.getString("orderId"));
			orderList.setBookname(databaseDao.getString("bookname"));
			orderList.setUsername(databaseDao.getString("username"));
			orderList.setPrice(databaseDao.getString("price"));
			orderList.setNumber(databaseDao.getInt("number"));
			orderList.setOrderData(databaseDao.getTimestamp("orderData"));
			if(databaseDao.getInt("ordertype")==0){
				orderList.setOrdertype("未结算");
			}else {
				orderList.setOrdertype("已结算");
			}
			orderList.setSum(sum);
			orderLists.add(orderList);	
		}		
		return orderLists;
	}	
	public Integer update(String orderId, DBConnection databaseDao)throws SQLException{//查询失败返回-1
		String sql = "update `order` set ordertype='"+1+"' where orderId ="+orderId;
		return databaseDao.update(sql);
  }
	public Integer update1(String orderId,int userId,int carId,int ordertype, DBConnection databaseDao)throws SQLException{//查询失败返回-1
		String sql = "update `order` set userId='"+userId+"',ordertype='"+ordertype+
				"',carId='"+carId+"'where orderId ="+orderId;
		return databaseDao.update(sql);
  }
	public Integer delete(String orderId,DBConnection databaseDao)throws SQLException{//查询失败返回-1
		String sql = "delete from `order` where orderId ="+orderId;
		return databaseDao.update(sql);
}
}
