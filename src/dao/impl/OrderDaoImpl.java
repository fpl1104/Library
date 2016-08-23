package dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fanpeilin.model.AppointmentBook;

import dao.AppointmentBookDao;

public class OrderDaoImpl extends BaseDaoImpl implements AppointmentBookDao {

	@Override
	public boolean save(AppointmentBook book) {
		sql = "insert into AppointmentBook(userid,bookid)values(?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(book.getUserid());
		params.add(book.getBookid());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean del(int  userid) {
		sql = "delete from AppointmentBook where userid=?";
		List<Object> params = new ArrayList<Object>();
		params.add(userid);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updata(AppointmentBook book) {
		sql = "update AppointmentBook set userid=?,bookid=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(book.getUserid());
		params.add(book.getBookid());
		params.add(book.getid());
		return this.operUpdate(sql, params);
	}

	@Override
	public AppointmentBook sel(AppointmentBook book) {
		List<AppointmentBook> uList = null;
		sql = "select id,userid,bookid from AppointmentBook where userid=? ";
		List<Object> params = new ArrayList<Object>();
		params.add(book.getUserid());
		try {
			uList = this.operQuery(sql, params, AppointmentBook.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (uList.size() > 0) {
			return uList.get(0);
		}
		return null;
	}

	@Override
	public List<AppointmentBook> selAll() {
		String sql = "select * from AppointmentBook";
		List<AppointmentBook> dList = null;
		try {
			dList = this.operQuery(sql, null, AppointmentBook.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dList;
	}

}
