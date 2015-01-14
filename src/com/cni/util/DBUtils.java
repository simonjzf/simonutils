package com.cni.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	
//	private String dataSourceName;
//	private DataSource ds;
//
//	public DBUtils() {
//	}
//
//	public DBUtils(String dataSourceName) {
//		this.dataSourceName = dataSourceName;
//	}
//
//	public void setDataSourceName(String dataSourceName) {
//		this.dataSourceName = dataSourceName;
//	}
//
//	public void init() {
//		try {
//			Context initcontext = new InitialContext();
//			ds = (DataSource) initcontext.lookup("java:/comp/env/jdbc/wish");
//			initcontext.close();
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}	
//
//	public int update(String sql, String params[]) {
//		int result = 0;
//		QueryRunner qr = new QueryRunner(ds);
//		try {
//			result = qr.update(sql, params);			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	public Object query(String sql, String params[], ResultSetHandler rsh) {
//		Object result = null;
//		QueryRunner qr = new QueryRunner(ds);
//
//		try {
//			result = qr.query(sql, params, rsh);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//	
//	public Object queryPagination(String sql, int params[], ResultSetHandler rsh) {
//		Object result = null;
//		QueryRunner qr = new QueryRunner(ds);
//
//		try {
//			result = qr.query(sql, params, rsh);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//	
    public static Connection conn = null;                 //声明Connection对象
    public static PreparedStatement pstmt = null;         //声明PreparedStatement对象
    public static ResultSet rs = null;                    //声明ResultSet对象
	
    public static Connection getConnection() {		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			String url = "jdbc:mysql://localhost:3306/mfgotv2";
			conn = DriverManager.getConnection(url,"root","javaweb2.0");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
	
	public static void close(ResultSet rs){
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void close(PreparedStatement pstmt){
		try {
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn){
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
