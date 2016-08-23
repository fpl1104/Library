package dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fanpeilin.model.User;

import dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public boolean save(User user) {
		sql = "insert into user(username,password,type)values(?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUsername());
		params.add(user.getPassword());
		params.add(user.getType());
		return this.operUpdate(sql, params);

	}

	@Override
	public boolean del(String username) {
		sql = "delete from user where username=?";
		List<Object> params = new ArrayList<Object>();
		params.add(username);

		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updata(User user) {
		sql = "update user set integral=?,vip=?,borrowNumber=?,Cherish=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getIntegral());
		params.add(user.getVip());
		params.add(user.getBorrowNumber());
		params.add(user.getCherish());
		params.add(user.getId());

		return this.operUpdate(sql, params);
	}

	@Override
	public User sel(User user) {
		List<User> uList = null;
		sql = "select id,username,password,type,integral,vip,borrowNumber,Cherish from user where username=? and password=? ";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUsername());
		params.add(user.getPassword());
		// params.add(user.getType());
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (uList.size() > 0) {
			return uList.get(0);
		}
		return null;
	}

	@Override
	public List<User> selAll() {
		String sql = "select * from user";
		List<User> dList = null;
		try {
			dList = this.operQuery(sql, null, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dList;
	}

	@Override
	public User selUserByName(String name) {
		List<User> uList = null;
		String sql = "select * from user where username=?";
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (uList.size() > 0) {
			return uList.get(0);
		}
		return null;
	}

}
