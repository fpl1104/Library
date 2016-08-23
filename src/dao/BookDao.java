package dao;

import java.util.List;

import com.fanpeilin.model.Book;



public interface BookDao {
	public boolean save(Book book);
	public boolean del(Book  book);
	public boolean updata(Book book);
	public Book sel(Book book);
	public List<Book> selAll();
	public Book queryBookByName(String dname);//����ָ�����ֵ���
	public List<Book> querySortBookByLimit(int index,int number);//������ʼλ�ÿ�ʼ���ָ�������ļ�¼
	public Book queryBookById(int bok);//������ı������ѯ
}
