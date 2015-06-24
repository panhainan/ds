package com.ds.dreamstation.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import org.junit.Test;

/**
 * @author phn
 * @date 2015-6-22
 * @email 1016593477@qq.com
 * @TODO
 */
public class DS2dsDBUtil {

	static ResourceBundle rbundle = ResourceBundle.getBundle("jdbc");
	private static String dbDriverName = rbundle.getString("driverName");
	private static String dbUrl = rbundle.getString("url");
	private static String dbUser = rbundle.getString("user");
	private static String dbPassword = rbundle.getString("password");
	public static Connection conn = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	public static Statement st = null;

	// 连接数据库的方法
	public static Connection getConnection() {
		try {
			// 初始化驱动包
			Class.forName(dbDriverName).newInstance(); // 根据数据库连接字符，名称，密码给conn赋值
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * @TODO 关闭连接,释放资源
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void closeConnection(ResultSet rs, PreparedStatement prst,
			Connection conn) {
		try { // 捕捉异常
			try {
				if (rs != null) { // 当ResultSet对象的实例rs不为空时
					rs.close(); // 关闭ResultSet对象
				}
			} finally {
				try {
					if (prst != null) { // 当Statement对象的实例stmt不为空时
						prst.close(); // 关闭Statement对象
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (conn != null) { // 当Connection对象的实例conn不为空时
						conn.close(); // 关闭Connection对象
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}

	public static void closeConnection(PreparedStatement prst, Connection conn) {
		closeConnection(null, prst, conn);
	}

	public static void closeConnection(Connection conn) {
		closeConnection(null, null, conn);
	}

	@Test
	public void testConnect() {
		conn = getConnection();
		if (conn != null) {
			System.out.println("conn=" + conn);
			System.out.println("数据库连接成功！");
		} else {
			System.out.println("数据库连接失败！");
		}
		closeConnection(conn);
	}

}
