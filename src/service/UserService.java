package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.DBConnection;
import Dao.UserDao;
import bean.User;
import tool.PageInformation;

public class UserService {
	public Integer register(User user){
		int result=-1;//数据库操作失败	
		
		try {
			DBConnection databaseDao=new DBConnection();
			UserDao UserDao=new UserDao();
			
			if(UserDao.hasUser(user, databaseDao)==0){//没有同名用户，可以注册
				UserDao.register(user, databaseDao);
				return 1;	//成功
			}else{
				return 0;//失败，用户已存在
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}
	
	public User login(User user){
		try {
			UserDao UserDao=new UserDao();
			return UserDao.login(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;		
	}	
	
	public List<User> getOnePage(PageInformation pageInformation) {	
		List<User> users=new ArrayList<User>();
		try {
			DBConnection databaseDao=new DBConnection();			
			UserDao userDao=new UserDao();		
			users=userDao.getOnePage(pageInformation,databaseDao);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return users;
	}

	public List<User> check(PageInformation pageInformation,String id) {	
		List<User> users=null;
		try {
			DBConnection databaseDao=new DBConnection();			
			UserDao userDao=new UserDao();
			
			if(id!=null && !id.isEmpty())
				userDao.changeEnable(id,databaseDao);
			
			users=userDao.getOnePage(pageInformation,databaseDao);
			
		} catch (SQLException e) {
			users=null;
			e.printStackTrace();
		} catch (Exception e) {
			users=null;
			e.printStackTrace();
		}		
		return users;
	}
	//删除多条记录
	public List<User> deletes(PageInformation pageInformation) {	
		List<User> users=null;
		try {
			DBConnection databaseDao=new DBConnection();			
			UserDao userDao=new UserDao();
			userDao.deletes(pageInformation.getIds(),databaseDao);
			pageInformation.setIds(null);
			users=userDao.getOnePage(pageInformation,databaseDao);
		} catch (SQLException e) {
			users=null;
			e.printStackTrace();
		} catch (Exception e) {
			users=null;
			e.printStackTrace();
		}		
		return users;
	}
	//修改密码
	public Integer changePassword(String oldPassword, String newPassword) {		
		try {
			DBConnection databaseDao=new DBConnection();			
			UserDao userDao=new UserDao();
			//userDao.deletes(pageInformation.getIds(),databaseDao);
			//pageInformation.setIds(null);
			//users=userDao.getOnePage(pageInformation,databaseDao);
		} catch (SQLException e) {
			//users=null;
			e.printStackTrace();
		} catch (Exception e) {
			//users=null;
			e.printStackTrace();
		}		
		return 1;
	}	
}
