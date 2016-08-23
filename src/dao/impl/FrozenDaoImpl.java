package dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fanpeilin.model.Book;
import com.fanpeilin.model.Frozen;

import dao.FrozenDao;

public class FrozenDaoImpl extends BaseDaoImpl implements FrozenDao{

	@Override
	public boolean add(Frozen frozen) {
		sql = "insert into Frozen(userid,ftime,reason)values(?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(frozen.getUserid());
		params.add(frozen.getFtime());
		params.add(frozen.getReason());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean update(Frozen frozen) {
		sql = "update Frozen set userid=?,ftime=?,reason=? where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(frozen.getUserid());
		params.add(frozen.getFtime());
		params.add(frozen.getReason());
		params.add(frozen.getId());
		return this.operUpdate(sql, params);
	}

	@Override
	public List<Frozen> sel() {
		String sql = "select * from Book";
		List<Frozen> dList = null;
		try {
			dList = this.operQuery(sql, null, Frozen.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dList;
	}

}
