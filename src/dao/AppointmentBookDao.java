package dao;

import java.util.List;

import com.fanpeilin.model.AppointmentBook;


public interface AppointmentBookDao {
	public boolean save(AppointmentBook book);//����
	public boolean del(int   userid);//ɾ��
	public boolean updata(AppointmentBook book);//�޸�
	public AppointmentBook sel(AppointmentBook book);//�鿴
	public List<AppointmentBook> selAll();
}
