package com.fanpeilin.biz.impl;

import java.util.List;

import com.fanpeilin.biz.IRecordBiz;
import com.fanpeilin.model.BorrowRecord;

import dao.BorrowRecordDao;
import dao.impl.RecordDaoImpl;

public class RecordBizImpl implements IRecordBiz{
	private BorrowRecordDao recordDao=null;
	public RecordBizImpl(){
		recordDao=new RecordDaoImpl();
	}
	@Override
	public List<BorrowRecord> queryUserRecords(String uname) {
		return recordDao.queryRecordByUname(uname);
	}

	@Override
	public List<BorrowRecord> queryBookRecords(String dname) {
		return recordDao.queryRecordByBname(dname);
	}
	@Override
	public BorrowRecord queryRecordsById(int id) {
		// TODO Auto-generated method stub
		return recordDao.queryRecordById(id);
	}

}
