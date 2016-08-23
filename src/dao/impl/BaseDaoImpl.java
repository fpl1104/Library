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
			conn = getConn();// �������ݿ�����
			pstmt = conn.prepareStatement(sql);// װ��SQL���
			if (params != null) {
				// �����У���sql��䣬��ȥ��ȫ
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(i + 1, params.get(i));
				}
			}
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);// �ͷ���Դ
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
			conn = getConn();// �������ݿ�����
			pstmt = conn.prepareStatement(sql);// װ��SQL���
			if (params != null) {
				// �����У���sql��䣬��ȥ��ȫ
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(i + 1, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData rsd = rs.getMetaData();// �õ����Ԫ����
			// ���Ի�ñ�Ľṹ�����磺�м����У�������ÿ������������
			while (rs.next()) {
				T m = cls.newInstance();
				// ѭ����ȡ����
				for (int i = 0; i < rsd.getColumnCount(); i++) {
					String col_Name = rsd.getColumnName(i + 1);// ��ȡ����
					Object value = rs.getObject(col_Name);// ��ȡ������Ӧ��ֵ
					Field field = cls.getDeclaredField(col_Name);// �õ����������
					field.setAccessible(true);// ��˽�����Ը�����Ȩ��
					field.set(m, value);// �������˽�����Ը�ֵ
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
