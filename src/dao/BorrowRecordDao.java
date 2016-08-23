package dao;

import java.util.List;

import com.fanpeilin.model.BorrowRecord;



public interface BorrowRecordDao {
	//查看指定用户的借还DVD记录
	public List<BorrowRecord> queryRecordByUname(String uname);
	//查看指定DVD的借还记录
	public List<BorrowRecord> queryRecordByBname(String dname);
	//查看指定id的DVD借还记录
	public BorrowRecord queryRecordById(int rid);
	//保存Record记录
	public boolean saveRecord(BorrowRecord record);
	//更新Record记录
	public boolean updateRecord(BorrowRecord record);
	
}
