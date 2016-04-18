package com.dbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *JDBC访问数据库类
 */
public class DBHelper {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private static final String driver="sun.jdbc.odbc.JdbcOdbcDriver";
	private static final String url="jdbc:oracle:thin:@211.144.69.40:1521:orcl";
	private static final String dbuser="yz";
	private static final String password = "yz";
	public Connection getConn(){
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbuser,password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void close(Connection conn,Statement st,ResultSet rs){
		try{
			if(rs!=null){
				rs.close();			
			}
			if(st!=null){
				st.close();
			}
			if(conn!=null||!conn.isClosed()){
				conn.close();
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
}