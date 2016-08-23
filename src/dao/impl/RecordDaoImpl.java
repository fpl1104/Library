package dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fanpeilin.model.BorrowRecord;

import dao.BorrowRecordDao;

public class RecordDaoImpl extends BaseDaoImpl implements BorrowRecordDao{
	//指定人的借书记录
	@Override
	public List<BorrowRecord> queryRecordByUname(String uname) {
		String sql = "select BorrowRecord.id,username,bookname,borrowtime,lendtime from user,BorrowRecord,book where user.id=BorrowRecord.userid and book.id=BorrowRecord.biid and username=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		List<BorrowRecord> data=null;
		try {
			data = this.operQuery(sql, params, BorrowRecord.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	//指定书的借书记录
	@Override
	public List<BorrowRecord> queryRecordByBname(String dname) {
		String sql = "select BorrowRecord.id,username,bookname,borrowtime,lendtime from user,BorrowRecord,book  where user.id=BorrowRecord.userid and book.id=BorrowRecord.biid and bookname=?";
		List<Object> params=new ArrayList<Object>();
		params.add(dname);
		List<BorrowRecord> data=null;
		try {
			data = this.operQuery(sql, params, BorrowRecord.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public BorrowRecord queryRecordById(int rid) {
		String sql = "select * from BorrowRecord where id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(rid);
		List<BorrowRecord> data=null;
		try {
			data = this.operQuery(sql, params, BorrowRecord.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(data.size()>0){
			return data.get(0);
		}
		return null;
	}
	

	@Override
	public boolean saveRecord(BorrowRecord record) {
		String sql="insert into BorrowRecord(Userid,Biid,Borrowtime,Lendtime)values(?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(record.getUserid());
		params.add(record.getBiid());
		params.add(record.getBorrowtime());
		params.add(record.getLendtime());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateRecord(BorrowRecord record) {
		String sql="update BorrowRecord set Userid=?,Biid=?,Borrowtime=?,Lendtime=? where id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(record.getUserid());
		params.add(record.getBiid());
		params.add(record.getBorrowtime());
		params.add(record.getLendtime());
		params.add(record.getRid());
		return this.operUpdate(sql, params);
	}

	

}
