package Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import tool.PageInformation;
import tool.Tool;

public class UserDao {
	public Integer hasUser(User user,DBConnection databaseDao) throws SQLException{
		String sql="select * from user where name='"+user.getName()+"'";
		databaseDao.query(sql);
		while(databaseDao.next()){
			return 1;
		}
		return 0;
	}
	
	public void register(User user,DBConnection databaseDao) throws SQLException{
		String sql="insert into user(type,name,password,enable) values('"+
				user.getType()+"','"+user.getName()+"','"+
				user.getPassword()+"','"+user.getEnable()+"')";
		databaseDao.update(sql);
	}
	
	public User login(User user) throws SQLException, Exception{
		DBConnection databaseDao=new DBConnection();
		User user2=new User();
		String sql="select * from user where name='" + user.getName()+
						"' and password='"+ user.getPassword()+"'";
		databaseDao.query(sql);
		while (databaseDao.next()){
			user2.setPassword(databaseDao.getString("password"));
			user2.setUserId(databaseDao.getInt("userId"));
			user2.setName(databaseDao.getString("name"));
			user2.setType(databaseDao.getString("type"));
		}		
		return user2;
	}	
	
	public List<User> getOnePage(PageInformation pageInformation,DBConnection databaseDao) throws SQLException{
		List<User> users=new ArrayList<User>(); 
		String sqlCount=Tool.getSql(pageInformation,"count");
		Integer allRecordCount=databaseDao.getCount(sqlCount);//符合条件的总记录数
		Tool.setPageInformation(allRecordCount, pageInformation);//更新pageInformation的总页数等
		
		String sqlSelect=Tool.getSql(pageInformation,"select");
		databaseDao.query(sqlSelect);
		while (databaseDao.next()) {
			User user=new User();
			user.setEnable(databaseDao.getString("enable"));
			user.setName(databaseDao.getString("name"));
			user.setRegisterDate(databaseDao.getTimestamp("registerDate"));
			user.setType(databaseDao.getString("type"));
			user.setUserId(databaseDao.getInt("userId"));
			users.add(user);	
		}		
		return users;
	}	
	
	//切换用户的可用性
	public Integer changeEnable(String id,DBConnection databaseDao)throws SQLException{//查询失败返回-1
		String sql = "select * from user where userId in ("+id+")";
		databaseDao.query(sql);
		while (databaseDao.next()) {
			String enable=databaseDao.getString("enable");
			if("use".equals(enable))
				enable="stop";
			else
				enable="use";
			sql = "update user set enable='"+enable+"' where userId in ("+id+")";
			databaseDao.update(sql);
			return 1;
		}		
		return 0;
	}
	
	//删除多个用户
	public Integer deletes(String ids,DBConnection databaseDao)throws SQLException{//查询失败返回-1
		if(ids!=null && ids.length()>0){
			String sql = "delete from user where userId in ("+ids+")";
			return databaseDao.update(sql);
		}else
			return -1;
	}	
}
