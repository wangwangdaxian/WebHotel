package sqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javaBean.*;

public class CustomerDao extends BaseDao{
	public CustomerDao() throws SQLException {
		super();
		// TODO 自动生成的构造函数存根
	}
	public boolean isNew(String userId) {//判断用户ID是否已经存在
			 String sql="select count(*) from Customer where UserID=?";
			 String s = null;
			try (Connection con = ds.getConnection();
					PreparedStatement p=con.prepareStatement(sql)){
				
				p.setString(1, userId);
				ResultSet r=p.executeQuery();
				if(r.next()) {
				s=r.getString(1);}
				p.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(s.equals("0"))	return true;
		else return false;
	}
	public boolean register(Customer newCust) {//向sql存储新用户newCust的信息
		String sql="insert into Customer values(?,?,?,?)";
		 try( Connection con = ds.getConnection();
					PreparedStatement p=con.prepareStatement(sql)) {
			
			p.setString(1, newCust.getUserId());
			p.setString(2, newCust.getName());
			p.setString(3, newCust.getPassword());
			p.setString(4, newCust.getPhone());
			int r=p.executeUpdate();
			p.close();
			con.close();
			if(r>0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}
	public Customer findCust(String userId) {//根据userId从sql中找到用户信息并返回该用户cust
		 Customer cust=new Customer();
		 String sql="select * from Customer where UserID=?";
		 try ( Connection con = ds.getConnection();
					PreparedStatement p=con.prepareStatement(sql)){
			
			p.setString(1, userId);
			ResultSet rs=p.executeQuery();
			if(rs.next()) {
			cust.setUserId(rs.getString(1));
			cust.setName(rs.getString(2));
			cust.setPassword(rs.getString(3));
			cust.setPhone(rs.getString(4));}
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return cust;
	}
	public boolean verify(String userId,String password) {//验证登陆，检查用户账户和密码是否匹配
		Customer cust=findCust(userId);
		if(cust.getPassword()!=null)
			if(cust.getPassword().equals(password)) 
				return true;
		return false;
	}
	public ArrayList<Room> skimRoom(){//浏览不同房型的信息
		ArrayList<Room> rooms=new ArrayList<Room>();
		String sql="select * from RoomType";
		try ( Connection con = ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql);
				ResultSet rs=p.executeQuery();){
			while(rs.next()) {
				Room r=new Room();
				r.setRoomType(rs.getString(1));
				r.setRoomPrice(rs.getString(2));
				r.setDiscribe(rs.getString(3));
				rooms.add(r);
			}
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rooms;
	}
	public String aoNum(String date) {//返回预订单尾部三位编号
		String sql="select COUNT(*)from AdvanceOrder where orderID like ?";
		int n=0;
		String N=null;
		try ( Connection con = ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)){

			p.setString(1, date+"%");
			ResultSet rs=p.executeQuery();
			if(rs.next()) {
			n=Integer.parseInt(rs.getString(1));
			N=String.format("%03d",n+1);}
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}return N;
	}
	public boolean book(AdvanceOrder ao) {//用户预订生成预订单
		SimpleDateFormat ft=new SimpleDateFormat("yyyyMMdd");
		String date=ft.format(new Date());
		ao.setOrderId(date+aoNum(date));
		int i=0;
		String sql="insert into AdvanceOrder values(?,?,?,?,?)";
		try( Connection con = ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)) {

			p.setString(1, ao.getOrderId());
			p.setString(2, ao.getCustId());
			p.setString(3, ao.getRoomType());
			p.setString(4, ao.getInDate());
			p.setString(5, ao.getOutDate());
			i=p.executeUpdate();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}if(i>0)return true;
		else return false;
	}
	
}
