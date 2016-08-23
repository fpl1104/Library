package com.fanpeilin.biz.impl;
import java.util.List;

import com.fanpeilin.biz.UserBiz;
import com.fanpeilin.model.User;

import dao.UserDao;
import dao.impl.UserDaoImpl;


public class UserBizImpl implements UserBiz{
	private UserDao userDao = null;
	public UserBizImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public User login(User user) {
		return userDao.sel(user);
	}


	@Override
	public int registerUser(User user) {
		if(userDao.sel(user)!=null){
			return 1;//此用户已存在
		}else{
			boolean res = userDao.save(user);
			if(res){
				return 2;//注册成功
			}else{
				return 3;//注册失败
			}
		}
	}

	@Override
	public List<User> selAll() {
		return userDao.selAll();
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updata(user);
	}

	@Override
	public User selUser(String username) {
		// TODO Auto-generated method stub
		return userDao.selUserByName(username);
	}
	
}
