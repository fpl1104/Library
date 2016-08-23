package dao;

import java.util.List;

import com.fanpeilin.model.User;


public interface UserDao {
	public boolean save(User user);//增加
	public boolean del(String  username);//删除
	public boolean updata(User user);//修改
	public User sel(User user);//查看
	public List<User> selAll();//查看全部
	public User selUserByName(String name);
	
}
