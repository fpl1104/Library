package dao;


import java.util.List;

import com.fanpeilin.model.Frozen;

public interface FrozenDao {
	public boolean add(Frozen frozen);
	public boolean update(Frozen frozen);
	public List<Frozen> sel();
}
