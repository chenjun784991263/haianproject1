package com.niit.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niit.Bean.AccountBean;
import com.niit.Bean.BookBean;
import com.niit.Bean.BorrowRecordBean;
import com.niit.Bean.ReserveRecordBean;
import com.niit.Bean.StockBean;
import com.niit.constants.MessageConstant;
import com.niit.dbutil.DBConnection;
import com.niit.model.Account;
import com.niit.model.Book;
import com.niit.model.BorrowRecord;
import com.niit.model.Publisher;
import com.niit.model.Stock;
import com.niit.model.Type;
import com.niit.model.User;

public class AdminDao {

	public static List<User> QueryAllUser() throws SQLException{
		
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<User> list=session.createQuery("from User").list();
		session.close();
		return list;
			
		
}
   public static List<User> QueryAllUserwithoutAccount() throws SQLException{
		
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<Object[]>row=session.createSQLQuery("SELECT *FROM t_user WHERE id NOT IN( SELECT userid FROM T_account)").list();
		List<User>list=new ArrayList<User>();
		for(Object[] u:row)
		{
			User user=new User();
			user.setId(Integer.parseInt(u[0].toString()));
			user.setName(u[1].toString());
			user.setGender(u[2].toString());
			user.setRole(u[3].toString());
			user.setTel(u[4].toString());
			user.setLoc(u[5].toString());
			user.setEmail(u[6].toString());
			user.setPassword(u[7].toString());
			user.setFlag(Integer.parseInt(u[8].toString()));
			list.add(user);
		}
		session.close();
		return list;
			
		
}
	
	
    public static User getUser(Integer id) throws SQLException
    {
    	Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
    	User user=(User) session.createQuery("from User where id="+id).uniqueResult();
    	session.close();
    	return user;
    	
    	
    	
    }
	
    public static void EditUser(User user) throws SQLException
    {
    	Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
    	User user1=session.get(User.class, user.getId());
    	user1.setName(user.getName());
    	user1.setGender(user.getGender());
    	user1.setRole(user.getRole());
    	user1.setTel(user.getTel());
    	user1.setLoc(user.getLoc());
    	user1.setPassword(user.getPassword());
    	session.update(user1);
    	tx.commit();
    	session.close();
    	
    }
	
    public static void ChangeUserState(Integer id) throws SQLException
    {
    	Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
    	User user=session.get(User.class, id);
    	if(user.getFlag()==1)
    	{
    		user.setFlag(0);
    		session.update(user);
    		
    	}else if(user.getFlag()==0)
    	{
    		user.setFlag(1);
    		session.update(user);
    		
    	}
    	tx.commit();
		session.close();
    	
    	
    }
	
	
	
	
	public static void DeleteUser(Integer id) throws SQLException
	{
		
		Session session=DBConnection.buildConection();
	    Transaction tx=session.beginTransaction();
		User user=(User)session.get(User.class, id);
		session.delete(user);
		tx.commit();
		session.close();
	
	}

	

public static List<BookBean> QueryBook() throws SQLException{
	
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	List<BookBean>booklist=new ArrayList<BookBean>();
	List<Object[]> list=session.createSQLQuery("SELECT b.id,b.name,b.author,b.releasingtime,b.price,b.contentType,b.flag,t.releasingtype,p.name as 'publishername' ,t.name as 'typename' FROM t_book b LEFT JOIN t_publisher p ON b.publisher=p.id LEFT JOIN t_type t ON b.typeid=t.id").list();
	for(Object[] row:list) {
		BookBean book=new BookBean();
		book.setId(Integer.parseInt(row[0].toString()));
		book.setName(row[1].toString());
		book.setAuthor(row[2].toString());
		book.setReleasingtime(row[3].toString());
		book.setPrice(Double.parseDouble(row[4].toString()));
		book.setContenttype(row[5].toString());
		book.setFlag(Integer.parseInt(row[6].toString()));
		book.setReleasingtype(row[7].toString());
		book.setPublishername(row[8].toString());
		book.setType(row[9].toString());
		booklist.add(book);
	}
	session.close();
	return booklist;
		
	
}





public static int addBookType(Type type) throws SQLException {
	
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	session.save(type);
	tx.commit();
	session.close();
	return MessageConstant.BookType_Create_Success;
}

public static int addBook(Book book) throws SQLException {
	
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	session.save(book);
	tx.commit();
	session.close();
	return MessageConstant.Book_Create_Success;
}

public static void addStock(Stock stock) throws SQLException
{
	
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	session.save(stock);
	tx.commit();
	session.close();
	
	
	
}




public static int addPublisher(Publisher publisher) throws SQLException {
	
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	session.save(publisher);
	tx.commit();
	session.close();
	return MessageConstant.Publisher_Create_Success;
}

public static List<Type> QueryAllBookType() throws SQLException{
	
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	List<Type> list=session.createQuery("from Type").list();
	session.close();
	return list;
		
	
}

public static List<Publisher> QueryAllPublisher() throws SQLException{
	
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	List<Publisher> list=session.createQuery("from Publisher").list();
	session.close();
	return list;
		
	
}

public static void EditBookType(Type type) throws SQLException
{
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	Type type1=session.get(Type.class, type.getId());
	type1.setName(type.getName());
	type1.setReleasingtype(type.getReleasingtype());
	type1.setTime(type.getTime());
	session.update(type1);
	tx.commit();
	session.close();
	
}

public static void ChangeBookTypeState(Integer id) throws SQLException
{
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	Type type=session.get(Type.class, id);
	if(type.getFlag()==1)
	{
		type.setFlag(0);
		session.update(type);
		
	}else if(type.getFlag()==0)
	{
		type.setFlag(1);
		session.update(type);
		
	}
	tx.commit();
	session.close();
	
	
}

public static void EditPublisher(Publisher publisher) throws SQLException
{
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	Publisher pub=session.get(Publisher.class, publisher.getId());
	pub.setName(publisher.getName());
	pub.setLoc(publisher.getLoc());
	pub.setTel(publisher.getTel());
	session.update(pub);
	tx.commit();
	session.close();
	
}

public static void ChangePublisherState(Integer id) throws SQLException
{
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	Publisher pub=session.get(Publisher.class, id);
	if(pub.getFlag()==1)
	{
		pub.setFlag(0);
		session.update(pub);
		
	}else if(pub.getFlag()==0)
	{
		pub.setFlag(1);
		session.update(pub);
		
	}
	tx.commit();
	session.close();
	
	
}
public static void DeleteBookType(Integer id) throws SQLException
{
	
	Session session=DBConnection.buildConection();
    Transaction tx=session.beginTransaction();
	Type type=(Type)session.get(Type.class, id);
	session.delete(type);
	tx.commit();
	session.close();

}

public static void DeletePublisher(Integer id) throws SQLException
{
	
	Session session=DBConnection.buildConection();
    Transaction tx=session.beginTransaction();
    Publisher publisher=(Publisher)session.get(Publisher.class, id);
	session.delete(publisher);
	tx.commit();
	session.close();

}

public static Type getType(Integer id) throws SQLException
{
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	Type type=(Type) session.createQuery("from Type where id="+id).uniqueResult();
	session.close();
	return type;
	
	
	
}

public static Publisher getPublisher(Integer id) throws SQLException
{
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	Publisher publisher=(Publisher) session.createQuery("from Publisher where id="+id).uniqueResult();
	session.close();
	return publisher;
	
	
	
}

public static Book getBook(String name,String releasingtime) throws SQLException
{
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
    Book book=(Book) session.createQuery("from Book where name='"+name+"'"+"and releasingtime='"+releasingtime+"'").uniqueResult();
	
	session.close();
	return book;
	
	
	
}


 

public static void EditBook(Book book) throws SQLException
{
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	Book book1=session.get(Book.class,book.getId());
	book1.setName(book.getName());
	book1.setAuthor(book.getAuthor());
	book1.setPrice(book.getPrice());
	book1.setPublisherid(book.getPublisherid());
    book1.setReleasingtime(book.getReleasingtime());
    book1.setContenttype(book.getContenttype());
    book1.setTypeid(book.getTypeid());
    session.update(book1);
    
    tx.commit();
	session.close();
}

public static void changeBookState(Integer id) throws SQLException
{
	Session session=DBConnection.buildConection();
	Transaction tx=session.beginTransaction();
	Book book=session.get(Book.class,id);
	if(book.getFlag()==1)
	{
		book.setFlag(0);
		session.update(book);
		
	}else if(book.getFlag()==0)
	{
		book.setFlag(1);
		session.update(book);
		
	}
	tx.commit();
	session.close();
 }


public static void DeleteBook(Integer id) throws SQLException
{
	
	Session session=DBConnection.buildConection();
    Transaction tx=session.beginTransaction();
    Book book=session.get(Book.class,id);
	session.delete(book);
	tx.commit();
	session.close();

}
public static void DeleteStock(Integer id) throws SQLException
{
	
	Session session=DBConnection.buildConection();
    Transaction tx=session.beginTransaction();
    Stock stock=session.get(Stock.class,id);
	session.delete(stock);
	tx.commit();
	session.close();

}



public static Book getBook(Integer id) throws SQLException
{
	Session session=DBConnection.buildConection();
    Transaction tx=session.beginTransaction();
    Book book=(Book) session.createQuery("from Book where id="+id).uniqueResult();
	session.close();
    
    return book; 
}

public static void AddAccount(Account a) throws SQLException
{
	 Session session=DBConnection.buildConection();
    Transaction tx=session.beginTransaction();
	 session.save(a);
	 tx.commit();
	 session.close();
	 
	 
}
 public static List<AccountBean> QueryAccount() throws SQLException{
	 
	 Session session=DBConnection.buildConection();
	 Transaction tx=session.beginTransaction();
	 List<AccountBean> accountlist=new ArrayList<AccountBean>();
	 List<Object[]> list= session.createSQLQuery("SELECT a.id,u.name,u.gender,u.role,u.tel,a.balance FROM t_account a LEFT JOIN t_user u ON a.userid=u.id").list();
	 for(Object[] row:list)
	 {
		 AccountBean ab=new AccountBean();
		 ab.setId(Integer.parseInt(row[0].toString()));
		 ab.setUsername(row[1].toString());
		 ab.setGender(row[2].toString());
		 ab.setRole(row[3].toString());
		 ab.setTel(row[4].toString());
		 ab.setBalance(Double.parseDouble(row[5].toString()));
		 accountlist.add(ab);
		 
	 }
	 session.close();
	 return accountlist;
	 
 }

  public static void AddBalance(Integer accountid,double money) throws SQLException
  {
	  Session session=DBConnection.buildConection();
	  Transaction tx=session.beginTransaction();
	  Account a=session.get(Account.class, accountid);
	  a.setBalance(a.getBalance()+money);
	  session.update(a);
	  tx.commit();
	  session.close();
	  
	  
  }
  
   public static void DeleteAccount(Integer id) throws SQLException
   {
	   
	   Session session=DBConnection.buildConection();
	   Transaction tx=session.beginTransaction();
	   Account a=session.get(Account.class, id);
	   session.delete(a);
	   tx.commit();
	   session.close();
	   
	   
   }
 
   public static List<StockBean> queryStock() throws SQLException{
	   
	   Session session=DBConnection.buildConection();
	   Transaction tx=session.beginTransaction();
	   List<StockBean>stocklist=new ArrayList<StockBean>();
		List<Object[]> list=session.createSQLQuery("SELECT s.id,b.name,b.author,b.releasingtime,b.price,b.contenttype,s.quantity FROM t_stock s LEFT JOIN t_book b ON s.bookid=b.id").list();
		for(Object[] row:list) {
		    StockBean sb=new StockBean();
			sb.setId(Integer.parseInt(row[0].toString()));
			sb.setName(row[1].toString());
			sb.setAuthor(row[2].toString());
			sb.setReleasingtime(row[3].toString());
			sb.setPrice(Double.parseDouble(row[4].toString()));
			sb.setContenttype(row[5].toString());
			sb.setQuantity(Integer.parseInt(row[6].toString()));
			stocklist.add(sb);
		}
		session.close();
		return stocklist;
			
	   
	   
	   
	   
	   
   }
 
   public static void addstock(Integer stockid,int num) throws SQLException
   {
	   
	   Session session=DBConnection.buildConection();
	   Transaction tx=session.beginTransaction();
	   Stock stock=session.get(Stock.class,stockid);
	   stock.setQuantity(stock.getQuantity()+num);
	   session.update(stock);
	   tx.commit();
	   session.close();
	   
	   
   }
   
   public static List<BorrowRecordBean> QueryBorrowRecord() throws SQLException
	 {
		 Session session=DBConnection.buildConection();
			Transaction tx=session.beginTransaction();
			List<BorrowRecordBean>borrowrecord=new ArrayList<BorrowRecordBean>();
			List<Object[]> list=session.createSQLQuery("SELECT br.id,u.id as 'userid',u.name as 'username',b.name as 'bookname',br.borrowdate,br.shouldreturndate FROM t_borrowrecord br LEFT JOIN t_book b ON br.bookid=b.id left join t_user u on u.id=br.userid WHERE br.flag=0").list();
			for(Object[] row:list)	
			{
				BorrowRecordBean brb=new BorrowRecordBean();
				brb.setId(Integer.parseInt(row[0].toString()));
				brb.setUserid(Integer.parseInt(row[1].toString()));
				brb.setUsername(row[2].toString());
				brb.setBookname(row[3].toString());
			    brb.setBorrowdate(row[4].toString());
			    brb.setShouldreturndate(row[5].toString());
		        borrowrecord.add(brb);
			
			}
			session.close();
			return borrowrecord;
				
	 }
     public static List<ReserveRecordBean> QueryReserveRecord() throws SQLException
	 {
		 Session session=DBConnection.buildConection();
			Transaction tx=session.beginTransaction();
			List<ReserveRecordBean>reserverecord=new ArrayList<ReserveRecordBean>();
			List<Object[]> list=session.createSQLQuery("SELECT r.id,u.id as 'userid',u.name AS 'username',b.name AS 'bookname' FROM t_reserverecord r LEFT JOIN t_user u ON r.USERID=u.id LEFT JOIN t_book b ON b.id=r.BOOKID where r.flag=0").list();
			for(Object[] row:list)	
			{
				ReserveRecordBean rr=new ReserveRecordBean();
				rr.setId(Integer.parseInt(row[0].toString()));
				rr.setUserid(Integer.parseInt(row[1].toString()));
				rr.setUsername(row[2].toString());
				rr.setBookname(row[3].toString());
			  
		        reserverecord.add(rr);
			
			}
			session.close();
			return reserverecord;
				
	 }
   
   
   
   
	 
   public static void  changeborrowrecordflag(Integer borrowrecordid) throws SQLException
   {
	   Session session=DBConnection.buildConection();
	   Transaction tx=session.beginTransaction();
	   BorrowRecord bb=session.get(BorrowRecord.class, borrowrecordid);
	   bb.setFlag(1);
	   session.update(bb);
	   tx.commit();
	   session.close();
	   
	   
	   
	   
	   
   }
   
   public static void  changereserverecordflag(Integer reserverecordid) throws SQLException
   {
	   Session session=DBConnection.buildConection();
	   Transaction tx=session.beginTransaction();
	   BorrowRecord bb=session.get(BorrowRecord.class, reserverecordid);
	   bb.setFlag(1);
	   session.update(bb);
	   tx.commit();
	   session.close();
	   
	   
	   
	   
	   
   }
   


}
