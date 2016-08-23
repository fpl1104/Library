package dao;

import java.util.List;

import com.fanpeilin.model.AppointmentBook;


public interface AppointmentBookDao {
	public boolean save(AppointmentBook book);//增加
	public boolean del(int   userid);//删除
	public boolean updata(AppointmentBook book);//修改
	public AppointmentBook sel(AppointmentBook book);//查看
	public List<AppointmentBook> selAll();
}
