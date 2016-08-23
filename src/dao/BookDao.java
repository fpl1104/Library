package dao;

import java.util.List;

import com.fanpeilin.model.Book;



public interface BookDao {
	public boolean save(Book book);
	public boolean del(Book  book);
	public boolean updata(Book book);
	public Book sel(Book book);
	public List<Book> selAll();
	public Book queryBookByName(String dname);//查找指定名字的书
	public List<Book> querySortBookByLimit(int index,int number);//查找起始位置开始后的指定个数的记录
	public Book queryBookById(int bok);//根据书的编号来查询
}
