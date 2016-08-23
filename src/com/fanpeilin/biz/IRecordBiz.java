package com.fanpeilin.biz;

import java.util.List;

import com.fanpeilin.model.BorrowRecord;


public interface IRecordBiz {
	// 查看指定用户的借还记录
		public List<BorrowRecord> queryUserRecords(String uname);

		// 查看指定书的借还记录
		public List<BorrowRecord> queryBookRecords(String dname);
		
		public BorrowRecord queryRecordsById(int  id);
	}

