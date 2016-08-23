package dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fanpeilin.model.Book;
import com.fanpeilin.model.BookInfo;

import dao.BookInfoDao;

public class BookInfoDaoImpl extends BaseDaoImpl implements BookInfoDao {

	@Override
	public List<BookInfo> selAll() {
		String sql = "select * from BookInfo";
		List<BookInfo> dList = null;
		try {
			dList = this.operQuery(sql, null, BookInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dList;
	}

	@Override
	public boolean save(BookInfo bookinfo) {
		sql = "insert into BookInfo(boodid,exist,damage,lost)values(?,?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(bookinfo.getBoodid());
		params.add(bookinfo.getExist());
		params.add(bookinfo.getDamage());
		params.add(bookinfo.getLost());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean del(int id) {
		sql = "delete from bookinfo where  id=? and exist=0 and damage=0 and lost=0";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updata(BookInfo bookinfo) {
		sql = "update bookinfo set exist=?,damage=?,lost=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(bookinfo.getExist());
		params.add(bookinfo.getDamage());
		params.add(bookinfo.getLost());
		params.add(bookinfo.getId());
		return this.operUpdate(sql, params);
	}

	@Override
	public List<BookInfo> sel(int  bid) {
		List<BookInfo> uList=null;
		sql="select bookinfo.id,boodid, exist,bookinfo.damage,lost from bookinfo where boodid=?  ";
		List<Object> params=new ArrayList<Object>();
		params.add(bid);
		try {
			uList=this.operQuery(sql, params,BookInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return uList;
	}

	@Override
	public List<BookInfo> selInfo(int bid) {
		List<BookInfo> uList=null;
		sql = "select * from bookinfo where Boodid=? and exist=0 and damage=0 and lost=0";
		List<Object> params=new ArrayList<Object>();
		params.add(bid);
		try {
			uList=this.operQuery(sql, params,BookInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return uList;
	}

	@Override
	public BookInfo sel(int id,int exit) {
		List<BookInfo> uList=null;
		BookInfo bookinfo=null;
		sql="select id,boodid,exist,damage,lost from bookinfo where boodid=? and exist=? ";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		params.add(exit);
		try {
			uList=this.operQuery(sql, params,BookInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(uList.size()>0){
			bookinfo=uList.get(0);
		}
		return bookinfo;
	}
}
