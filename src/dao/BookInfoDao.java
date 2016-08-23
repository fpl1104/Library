package dao;

import java.util.List;

import com.fanpeilin.model.BookInfo;

public interface BookInfoDao {
	public boolean save(BookInfo bookinfo);
	public boolean del(int id);
	public List<BookInfo> selInfo(int bid);//查找可以删的
	public boolean updata(BookInfo bookinfo);
	public BookInfo sel(int id,int exit);
	public List<BookInfo> sel(int bid);
	public List<BookInfo> selAll();
}
