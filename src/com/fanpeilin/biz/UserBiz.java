package com.fanpeilin.biz;

import java.util.List;

import com.fanpeilin.model.User;


public interface UserBiz {
	//�û���¼
	public User login(User user);
	//ע���û�
	public int registerUser(User user);
	public boolean updateUser(User user);
	public List<User>  selAll();//��ѯ�����û�
	public User selUser(String username);
	
}
