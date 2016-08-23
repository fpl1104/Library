package com.fanpeilin.biz;


import java.util.List;

import com.fanpeilin.model.Frozen;

public interface FrozenBiz {
public boolean save(Frozen frozen);
public List<Frozen> selAll();
}
