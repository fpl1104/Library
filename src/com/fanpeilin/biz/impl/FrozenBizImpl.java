package com.fanpeilin.biz.impl;

import java.util.List;

import com.fanpeilin.biz.FrozenBiz;
import com.fanpeilin.model.Frozen;

import dao.FrozenDao;
import dao.impl.FrozenDaoImpl;


public class FrozenBizImpl implements FrozenBiz{
private FrozenDao frozendao=null;
 public FrozenBizImpl() {
	frozendao=new FrozenDaoImpl();
}
	@Override
	public boolean save(Frozen frozen) {
		// TODO Auto-generated method stub
		return frozendao.add(frozen);
	}

	@Override
	public List<Frozen> selAll() {
		// TODO Auto-generated method stub
		return frozendao.sel();
	}

}
