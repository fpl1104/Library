package dao;

import java.util.List;

import com.fanpeilin.model.BorrowRecord;



public interface BorrowRecordDao {
	//�鿴ָ���û��Ľ軹DVD��¼
	public List<BorrowRecord> queryRecordByUname(String uname);
	//�鿴ָ��DVD�Ľ軹��¼
	public List<BorrowRecord> queryRecordByBname(String dname);
	//�鿴ָ��id��DVD�軹��¼
	public BorrowRecord queryRecordById(int rid);
	//����Record��¼
	public boolean saveRecord(BorrowRecord record);
	//����Record��¼
	public boolean updateRecord(BorrowRecord record);
	
}
