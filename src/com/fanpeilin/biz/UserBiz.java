package com.fanpeilin.biz;

import java.util.List;

import com.fanpeilin.model.User;


public interface UserBiz {
	//用户登录
	public User login(User user);
	//注册用户
	public int registerUser(User user);
	public boolean updateUser(User user);
	public List<User>  selAll();//查询所以用户
	public User selUser(String username);
	
}
