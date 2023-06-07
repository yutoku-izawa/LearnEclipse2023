package example.com.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource dc = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
			con = dc.getConnection();
		} catch (NamingException e) {
			throw new SQLException(e.getMessage()
					+ ":データソースの設定が正しく行われていません");
		}
		return con;
	}
}