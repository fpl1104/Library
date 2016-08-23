package dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/Library?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	String name = "root";
	String passwrd = "1111";
	Connection conn;
	String sql;
	PreparedStatement ps;
	ResultSet rs;

	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, name, passwrd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean operUpdate(String sql, List<Object> params) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();// 建立数据库连接
			pstmt = conn.prepareStatement(sql);// 装载SQL语句
			if (params != null) {
				// 假如有？的sql语句，就去补全
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(i + 1, params.get(i));
				}
			}
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);// 释放资源
		}
		return res > 0 ? true : false;

	}
	public <T> List<T> operQuery(String sql, List<Object> params, Class<T> cls)
			throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> data = new ArrayList<T>();
		try {
			conn = getConn();// 建立数据库连接
			pstmt = conn.prepareStatement(sql);// 装载SQL语句
			if (params != null) {
				// 假如有？的sql语句，就去补全
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(i + 1, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData rsd = rs.getMetaData();// 得到表的元数据
			// 可以获得标的结构，比如：有几个列，列名，每个列数据类型
			while (rs.next()) {
				T m = cls.newInstance();
				// 循环获取列名
				for (int i = 0; i < rsd.getColumnCount(); i++) {
					String col_Name = rsd.getColumnName(i + 1);// 获取列名
					Object value = rs.getObject(col_Name);// 获取列所对应的值
					Field field = cls.getDeclaredField(col_Name);// 得到对象的属性
					field.setAccessible(true);// 给私有属性赋访问权限
					field.set(m, value);// 给对象的私有属性赋值
				}
				data.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return data;
	}

}
