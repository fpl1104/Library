package com.fanpeilin.biz;

import java.util.List;

import com.fanpeilin.model.BorrowRecord;


public interface IRecordBiz {
	// �鿴ָ���û��Ľ軹��¼
		public List<BorrowRecord> queryUserRecords(String uname);

		// �鿴ָ����Ľ軹��¼
		public List<BorrowRecord> queryBookRecords(String dname);
		
		public BorrowRecord queryRecordsById(int  id);
	}

