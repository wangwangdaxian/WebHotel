package sqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javaBean.*;

public class AdministorDao extends BaseDao {

	public AdministorDao() throws SQLException {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Administor findAdms(String userId) {//根据userId找到管理员信息
		Administor adms=new Administor();
		 String sql="select * from Administor where UserID=?";
		 try( Connection con = ds.getConnection();
					PreparedStatement p=con.prepareStatement(sql)) {
			p.setString(1, userId);
			try(ResultSet rs=p.executeQuery()){
			if(rs.next()){
			adms.setUserId(rs.getString(1));
			adms.setName(rs.getString(2));
			adms.setPassword(rs.getString(3));}}
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return adms;
	}
	public boolean verify(String userId,String password) {//验证登陆，检查用户账户和密码是否匹配
		Administor adms=findAdms(userId);
		if(adms.getPassword()!=null)
			if(adms.getPassword().equals(password)) 
				return true;
		return false;
	}
	public ArrayList<AdvanceOrder> findAdOr(String userId) {//根据身份证查询用户当天的所有预订单
		ArrayList<AdvanceOrder> list=new ArrayList<>();
		String sql="select orderID,Customer.UserID,Customer.Name,RoomType.TypeName,price,InDate,OutDate\r\n" + 
				"from AdvanceOrder,Customer,RoomType\r\n" + 
				"where AdvanceOrder.UserID=Customer.UserID and AdvanceOrder.TypeName=RoomType.TypeName and Customer.UserID=? "+
				"and InDate=?";
		Date date=new Date();
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
		try( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);) {
			p.setString(1, userId);
			p.setString(2, ft.format(date));
			try(ResultSet rs=p.executeQuery()){
			while(rs.next()) {
				AdvanceOrder ao=new AdvanceOrder();
				ao.setOrderId(rs.getString(1));
				ao.setCustId(rs.getString(2));
				ao.setCustName(rs.getString(3));
				ao.setRoomType(rs.getString(4));
				ao.setRoomPrice(Integer.parseInt(rs.getString(5)));
				ao.setInDate(rs.getString(6));
				ao.setOutDate(rs.getString(7));
				int days=daysQuery(ao.getOrderId());
				ao.setDays(days);
				ao.setTotalPrice(days*ao.getRoomPrice());
				list.add(ao);}
			}p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return list;
	}
	public AdvanceOrder findAdOrByID(String orderID) {//根据预订单号查找预订单信息
		String sql="select orderID,UserID,InDate,OutDate\r\n" + 
				"from AdvanceOrder\r\n" + 
				"where  orderID=? ";
		AdvanceOrder ao=new AdvanceOrder();
		try ( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);){
			p.setString(1, orderID);
			try(ResultSet rs=p.executeQuery()){
			if(rs.next()) {
			ao.setOrderId(rs.getString(1));
			ao.setCustId(rs.getString(2));
			ao.setInDate(rs.getString(3));
			ao.setOutDate(rs.getString(4));}}
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ao;
	}
	public int daysQuery(String orderId) {//根据预订单号计算用户住店时间
		String sql="select DATEDIFF(day,InDate,OutDate)\r\n" + 
				"from AdvanceOrder\r\n" + 
				"where AdvanceOrder.orderID=?;";
		int days=0;
		try( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);) {
			p.setString(1, orderId);
			try(ResultSet rs=p.executeQuery()){
			if(rs.next()){
			days=Integer.parseInt(rs.getString(1));}}
			p.close();
			con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return days;
	}
	public int daysQuery(String InDate,String OutDate) {//返回入住天数
		String sql="select DATEDIFF(day,?,?)" ;
		int days=0;
		try( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);) {
			p.setString(1, InDate);
			p.setString(2, OutDate);
			try(ResultSet rs=p.executeQuery()){
			if(rs.next()) {
			days=Integer.parseInt(rs.getString(1));}}
			p.close();
			con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return days;
	}
	public ArrayList<Room> findAvaiRoom(String roomType){//查找某种房间类型的所有可用房间
		ArrayList<Room> list=new ArrayList<>();
		String sql="select RoomID,TypeName,RoomFloor,Orientation,Feature\r\n" + 
				"from Room\r\n" + 
				"where RoomID not in(\r\n" + 
				"	select RoomID\r\n" + 
				"	from OrderForm\r\n" + 
				"	where OrderState='进行中')\r\n" + 
				"	and RoomState='可用' and TypeName=?";
		try( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);) {
			p.setString(1, roomType);
			try(ResultSet rs=p.executeQuery()){
			while(rs.next()) {
				Room r=new Room();
				r.setRoomId(rs.getString(1));
				r.setRoomType(rs.getString(2));
				r.setRoomFloor(rs.getString(3));
				r.setOrientation(rs.getString(4));
				r.setFeature(rs.getString(5));
				list.add(r);}
			}p.close();
			con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void delAdOr(String orderID) {//删除某条预订单记录
		String sql="delete from AdvanceOrder where orderID=?";
		try( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);) {
			p.setString(1, orderID);
			p.executeUpdate();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public boolean assignRoom(String orderID,String roomID,String admsID) {//将某条预订单记录转化到订单里，完成房间分配
		AdvanceOrder ao=findAdOrByID(orderID);
		delAdOr(orderID);
		Date date=new Date();
		SimpleDateFormat ft=new SimpleDateFormat("yyyyMMdd");
		String ID=ao.getOrderId()+ft.format(date);
		String sql="insert into OrderForm values(?,?,?,?,?,?,?)";
		try ( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);){
			p.setString(1, ID);
			p.setString(2, admsID);
			p.setString(3, ao.getCustId());
			p.setString(4, roomID);
			p.setString(5, ao.getInDate());
			p.setString(6, ao.getOutDate());
			p.setString(7, "进行中");
			int r=p.executeUpdate();
			p.close();
			con.close();
			if(r>0)return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	public Check findOrder(String roomId) {//生成结账单
		String sql="select OrderForm.orderID,Customer.UserID,Customer.Name,OrderForm.RoomID,Room.TypeName,InDate,OutDate,Price\r\n" + 
				"from OrderForm,Customer,Room,RoomType\r\n" + 
				"where OrderForm.CustID=Customer.UserID  \r\n" + 
				"and OrderForm.RoomID=Room.RoomID and Room.TypeName=RoomType.TypeName  \r\n" + 
				"and OrderState='进行中' and OrderForm.RoomID=?";
		Check ch=new Check();
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try ( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);){
			p.setString(1, roomId);
			ResultSet rs=p.executeQuery();
			if(rs.next()) {
			ch.setOrderId(rs.getString(1));
			ch.setCustId(rs.getString(2));
			ch.setCustName(rs.getString(3));
			ch.setRoomId(rs.getString(4));
			ch.setRoomType(rs.getString(5));
			ch.setInDate(rs.getString(6));
			ch.setOutDate(rs.getString(7));
			ch.setRoomPrice(Integer.parseInt(rs.getString(8)));
			int days=daysQuery(ch.getInDate(), ch.getOutDate());
			ch.setTotalPrice(days*ch.getRoomPrice());
			ch.setDnow(ft.format(new Date()));}
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}return ch;
	}
	public Check checkOut(String roomId) {//离房结账
		String sql="update OrderForm set OrderState='结束'\r\n" + 
				"where RoomID=? and OrderState='进行中'";
		Check ch=findOrder(roomId);
		try ( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);){
			p.setString(1, roomId);
			p.executeUpdate();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}return ch;
	}
	public boolean roomTypeSetup(Room room) {//设置房间类型
		String sql="insert into RoomType values(?,?)";
		int i=0;
		try ( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);){
			p.setString(1, room.getRoomType());
			p.setString(2, room.getRoomPrice());
			i=p.executeUpdate();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}if(i>0)return true;
		else return false;
	}
	public boolean roomInfoSetup(Room r) {//设置房间信息
		String sql="insert into Room values(?,?,?,?,?,?)";
		int i=0;
		try ( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);){
			p.setString(1, r.getRoomId());
			p.setString(2, r.getRoomType());
			p.setString(3, r.getRoomFloor());
			p.setString(4, r.getOrientation());
			p.setString(5, r.getFeature());
			p.setString(6, r.getRoomState());
			i=p.executeUpdate();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}if(i>0)return true;
		else return false;
	}
	public boolean addCust(Customer cust) {//添加顾客信息
		String sql="insert into Customer values(?,?,?,?)";
		int i=0;
		try ( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);){
			p.setString(1, cust.getUserId());
			p.setString(2, cust.getName());
			p.setString(3, cust.getPassword());
			p.setString(4, cust.getPhone());
			i=p.executeUpdate();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(i>0)return true;
		else return false;
	}
	public boolean delCust(String userId) {//删除顾客信息
		String sql="delete from Customer where UserID=?";
		int i=0;
		try ( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);){
			p.setString(1, userId);
			i=p.executeUpdate();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(i>0)return true;
		return false;
	}
	public boolean addRece(Administor adms) {//添加前台信息
		String sql="insert into Administor values(?,?,?)";
		int i=0;
		try( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);) {
			p.setString(1, adms.getUserId());
			p.setString(2, adms.getName());
			p.setString(3, adms.getPassword());
			i=p.executeUpdate();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(i>0)return true;
		else return false;
	}
	public boolean delRece(String userId) {//删除前台信息
		String sql="delete from Administor where UserID=?";
		int i=0;
		try( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);) {
			p.setString(1, userId);
			i=p.executeUpdate();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(i>0)return true;
		return false;
	}
	public boolean roomStateSetup(String roomId,String roomState) {//设置房间状态
		String sql="update Room set RoomState=?  where roomId=?";
		int i=0;
		try (Connection con = ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql);){
			p.setString(1, roomState);
			p.setString(2, roomId);
			i=p.executeUpdate();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}if(i>0)return true;
		return false;
	}
	public ArrayList<Room> findAllRooms(){//返回所有房间信息
		ArrayList<Room> list=new ArrayList<>();
		String sql="select * from Room";
		try( Connection con = ds.getConnection();
			PreparedStatement p=con.prepareStatement(sql);
			ResultSet rs=p.executeQuery();) {
			while(rs.next()) {
				Room r=new Room();
				r.setRoomId(rs.getString(1));
				r.setRoomType(rs.getString(2));
				r.setRoomFloor(rs.getString(3));
				r.setOrientation(rs.getString(4));
				r.setFeature(rs.getString(5));
				r.setRoomState(rs.getString(6));
				list.add(r);
			}
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}return list;
	}
	public ArrayList<CustisHere> custisHere(){//在住客人报表
		ArrayList<CustisHere> list=new ArrayList<>();
		String sql="select * from CustisHere";
		try (Connection con=ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)){
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				CustisHere ch=new CustisHere();
				ch.setCustId(rs.getString(1));
				ch.setCustName(rs.getString(2));
				ch.setRoomId(rs.getString(3));
				ch.setInDate(rs.getString(4));
				ch.setOutDate(rs.getString(5));
				ch.setPhone(rs.getString(6));
				list.add(ch);
			}p.close();
			con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}return list;
	}
	public boolean badRoom(String roomId) {//设置房间状态为维修
		String sql="update Room set RoomState='维修中' where roomId=?";
		int i=0;
		try (Connection con=ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)){
			p.setString(1, roomId);
			i=p.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(i>0)return true;
		return false;
	}
	public ArrayList<AdvanceOrder> searAllAo(String userId) {//查询某用户的所有预订单
		ArrayList<AdvanceOrder> list=new ArrayList<AdvanceOrder>();
		String sql="select * from AdvanceOrder where userId=?";
		try (Connection con = ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)){
			p.setString(1, userId);
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				AdvanceOrder ao=new AdvanceOrder();
				ao.setCustId(rs.getString(2));
				ao.setOrderId(rs.getString(1));
				ao.setInDate(rs.getString(4));
				ao.setOutDate(rs.getString(5));
				ao.setRoomType(rs.getString(3));
				list.add(ao);
			}
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean alterAoType(String id,String type) {//修改预订单房间类型
		String sql="update advanceorder set typename=? where orderid=?";
		int i=0;
		try(Connection con = ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)) {
			p.setString(1, type);
			p.setString(2, id);
			i=p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(i>0)return true;
		return false;
	}
	public boolean  alterAoDate(String id,String in ,String out) {//修改预订单入住时间和离房时间
		String sql="update advanceorder set indate=?,outdate=? where orderid=?";
		int i=0;
		try(Connection con = ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)) {
			p.setString(1, in);
			p.setString(2, out);
			p.setString(3, id);
			i=p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(i>0)return true;
		return false;
	}
	public ArrayList<OrderForm> searAllOf(String id) {//用户查询自己所有的订单
		ArrayList<OrderForm> list=new ArrayList<OrderForm>();
		String sql="select * from orderform where custid=?";
		try (Connection con = ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)){
			p.setString(1, id);
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				OrderForm o=new OrderForm();
				o.setOrderId(rs.getString(1));
				o.setAdmsId(rs.getString(2));
				o.setCustId(rs.getString(3));
				o.setRoomId(rs.getString(4));
				o.setInDate(rs.getString(5));
				o.setOutDate(rs.getString(6));
				o.setOrderState(rs.getString(7));
				list.add(o);
			}
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean alterOutDate(String roomId,String outDate) {//客人续住,更改离房时间
		String sql="update orderform set outDate=? where roomId=? and OrderState='进行中'";
		int i=0;
		try(Connection con=ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)) {
			p.setString(1, outDate);
			p.setString(2, roomId);
			i=p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(i>0)return true;
		return false;
	}
	public String getRoomType(String roomId) {//返回某房间的房间类型
		String sql="select TypeName from Room where roomId=?";
		String roomType=null;
		try(Connection con=ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)) {
			p.setString(1, roomId);
			ResultSet rs=p.executeQuery();
			if(rs.next())
				roomType=rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return roomType;
	}
	public boolean alterroom(String oldId,String newId) {//用户换房（同类型房间）
		String sql="update orderform set roomid=? where roomId=? and OrderState='进行中'";
		int i=0;
		try(Connection con=ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)) {
			p.setString(1, newId);
			p.setString(2, oldId);
			i=p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(i>0)return true;
		return false;
	}
	public ArrayList<Room>roomStateStatistics(String roomType,String roomFloor){//房态统计
		String sql="select RoomId,RoomFloor,TypeName,Orientation,RoomState from Room";
		ArrayList<Room> list=new ArrayList<>();
		try(Connection con=ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)) {
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				Room r=new Room();
				r.setRoomId(rs.getString(1));
				r.setRoomFloor(rs.getString(2));
				r.setRoomType(rs.getString(3));
				r.setOrientation(rs.getString(4));
				String state=rs.getString(5);
				if(state.equals("可用")) {
					if(isEmpty(r.getRoomId()))  r.setSituation("空闲");
					else r.setSituation("使用中");
				}else {
					r.setSituation(state);
				}
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Room> showList=new ArrayList<>();
		if(roomType.equals("null")&&roomFloor.equals("null")) return null;
		if(!roomType.equals("null")&&roomFloor.equals("null")) {
			for(Room rm:list)
				if(rm.getRoomType().equals(roomType))showList.add(rm);
		}
		if(roomType.equals("null")&&!roomFloor.equals("null")) {
			for(Room rm:list)
				if(rm.getRoomFloor().equals(roomFloor))showList.add(rm);
		}
		if(!roomType.equals("null")&&!roomFloor.equals("null")) {
			for(Room rm:list)
				if(rm.getRoomType().equals(roomType)&&rm.getRoomFloor().equals(roomFloor))showList.add(rm);
		}
		return showList;
		
	}
	public boolean isEmpty(String roomId) {//判断可用性房间是否空闲
		String sql="select COUNT(*) from OrderForm where OrderState='进行中' and RoomID=?";
		int i=0;
		try(Connection con=ds.getConnection();
				PreparedStatement p=con.prepareStatement(sql)) {
			p.setString(1, roomId);
			ResultSet rs=p.executeQuery();
			if(rs.next())
				i=Integer.parseInt(rs.getString(1));
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		if(i>0)return false;
		return true;
	}
}
