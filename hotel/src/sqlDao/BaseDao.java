package sqlDao;

import javax.naming.Context;
import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class BaseDao {
	protected DataSource ds;

	public BaseDao() throws SQLException {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/hotel");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
