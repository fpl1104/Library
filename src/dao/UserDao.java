package dao;

import java.util.List;

import com.fanpeilin.model.User;


public interface UserDao {
	public boolean save(User user);//����
	public boolean del(String  username);//ɾ��
	public boolean updata(User user);//�޸�
	public User sel(User user);//�鿴
	public List<User> selAll();//�鿴ȫ��
	public User selUserByName(String name);
	
}
