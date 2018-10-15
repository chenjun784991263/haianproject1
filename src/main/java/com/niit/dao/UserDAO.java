package com.niit.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.Bean.BorrowRecordBean;
import com.niit.Bean.ReserveRecordBean;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niit.Bean.BookBean;

import com.niit.constants.MessageConstant;
import com.niit.dbutil.DBConnection;
import com.niit.model.Account;
import com.niit.model.AccountRecord;
import com.niit.model.Book;
import com.niit.model.BorrowRecord;
import com.niit.model.LoseRecord;
import com.niit.model.ReserveRecord;
import com.niit.model.Stock;
import com.niit.model.User;
import com.niit.supportclasses.GeneralSupport;

/*created by :-prateek kamdar
created date:-12/9/2018
updated by:-null
updated date:-null 
*/


import com.sun.org.apache.regexp.internal.recompile;

public class UserDAO {

	public static int addUser(User user) throws SQLException {
	
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		return MessageConstant.USER_CREATE_SUCCESS;
	}

	public static Integer login(User user) throws SQLException {
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		User userModel=(User) session.createQuery("from User where name='"+user.getName()+"' and password='"+user.getPassword()+"'").uniqueResult();
		if(userModel!=null) {
			if(user.getName().equals(userModel.getName())&& user.getPassword().equals(userModel.getPassword())) {
				return MessageConstant.LOGIN_SUCCESS;
			}else {
				return MessageConstant.LOGIN_FAIL;
			}
		}else {
			return MessageConstant.SOMETHING_WRONG;
		}
	}
	
	public static User getUser(User user)throws SQLException
	{
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		User userModel=(User) session.createQuery("from User where name='"+user.getName()+"' and password='"+user.getPassword()+"'").uniqueResult();
		return userModel;
		
		
		
	}
	
	public static Stock getStock(Integer bookid ) throws SQLException {
		
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		Stock stock=(Stock) session.createQuery("from Stock where bookid="+bookid).uniqueResult();
		session.close();
		return stock;
		
	}
	
	public static void changeStockForBorrowOrReserveOrLose(Stock stock) throws SQLException
	{
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		Stock stock1=session.get(Stock.class,stock.getId());
		stock1.setQuantity(stock.getQuantity()-1);
		stock.setModifydate(GeneralSupport.getDate());
		session.update(stock1);
		tx.commit();
		session.close();
		
    }
	
	public static void changeStockForReturnOrCancelReserve(Stock stock) throws SQLException
	{
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		Stock stock1=session.get(Stock.class,stock.getId());
		stock1.setQuantity(stock.getQuantity()+1);
		stock.setModifydate(GeneralSupport.getDate());
		session.update(stock1);
		tx.commit();
		session.close();
		
    }
	
	
	
	
	public static List<BookBean> QueryBook() throws SQLException{
		
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		List<BookBean>booklist=new ArrayList<BookBean>();
		List<Object[]> list=session.createSQLQuery("SELECT b.id,b.name,b.author,b.releasingtime,b.price,b.contentType,b.flag,t.releasingtype,p.name as 'publishername' ,t.name as 'typename' FROM t_book b LEFT JOIN t_publisher p ON b.publisher=p.id LEFT JOIN t_type t ON b.typeid=t.id where b.flag=1").list();
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
	
	public static void AddBorrowRecord(BorrowRecord br) throws SQLException
	{
		
		Session session=DBConnection.buildConection();
		Transaction tx=session.beginTransaction();
		session.save(br);
		tx.commit();
		session.close();
		
		
	 }
	
	 public static List<BorrowRecordBean> QueryBorrowRecord(Integer userid) throws SQLException
	 {
		 Session session=DBConnection.buildConection();
			Transaction tx=session.beginTransaction();
			List<BorrowRecordBean>borrowrecord=new ArrayList<BorrowRecordBean>();
			List<Object[]> list=session.createSQLQuery("SELECT br.id,b.name,b.author,b.price,b.releasingtime,br.borrowdate,br.shouldreturndate FROM t_borrowrecord br LEFT JOIN t_book b ON br.bookid=b.id  WHERE br.userid="+userid).list();
			for(Object[] row:list)	
			{
				BorrowRecordBean brb=new BorrowRecordBean();
				brb.setId(Integer.parseInt(row[0].toString()));
				brb.setBookname(row[1].toString());
				brb.setAuthor(row[2].toString());
				brb.setPrice(Double.parseDouble(row[3].toString()));
				brb.setReleasingtime(row[4].toString());
				brb.setBorrowdate(row[5].toString());
			    brb.setShouldreturndate(row[6].toString());
		        borrowrecord.add(brb);
			
			}
			session.close();
			return borrowrecord;
				
	 }
	 
	 public static List<ReserveRecordBean> QueryReserveRecord(Integer userid) throws SQLException
	 {
		 Session session=DBConnection.buildConection();
			Transaction tx=session.beginTransaction();
			List<ReserveRecordBean>reserverecord=new ArrayList<ReserveRecordBean>();
			List<Object[]> list=session.createSQLQuery("SELECT r.id,b.id as 'bookid',b.name,b.author,b.price,b.releasingtime FROM t_reserverecord r LEFT JOIN t_book b ON r.bookid=b.id LEFT JOIN t_user u ON r.userid=u.id WHERE r.userid="+userid).list();
			for(Object[] row:list)	
			{
				ReserveRecordBean rrb=new ReserveRecordBean();
				rrb.setId(Integer.parseInt(row[0].toString()));
				rrb.setBookid(Integer.parseInt(row[1].toString()));
				rrb.setBookname(row[2].toString());
				rrb.setAuthor(row[3].toString());
				rrb.setPrice(Double.parseDouble(row[4].toString()));
				rrb.setReleasingtime(row[5].toString());
			
		        reserverecord.add(rrb);
			
			}
			session.close();
			return reserverecord;
				
	 }
	 
	 
	 
	 
	 
	 public static BorrowRecord getBorrowRecord(Integer id) throws SQLException
	 {
		 Session session=DBConnection.buildConection();
		 Transaction tx=session.beginTransaction();
		 BorrowRecord br=session.get(BorrowRecord.class, id);
		 session.close();
		 return br;
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 public static void DeleteBorrowRecord(Integer borrowrecordid) throws SQLException
	 {
		 Session session=DBConnection.buildConection();
	     Transaction tx=session.beginTransaction();
		 BorrowRecord br=session.get(BorrowRecord.class,borrowrecordid);
		 session.delete(br);
		 tx.commit();
		 session.close();
		 
		 
	 }
	 
	 public static List<Book> SelectBookByInf(String inf) throws SQLException
	 {
		 Session session=DBConnection.buildConection();
	     Transaction tx=session.beginTransaction();
		
		 String sql="from Book as b where b.name like :name";
	     Query query=session.createQuery(sql);
	     query.setString("name", "%"+inf+"%");
	     List<Book> booklist=query.list();
	     
		 
			session.close();
			return booklist;
				
			
			 
			 
			 
			 
		 }
		 
	   public static Account getAcccount(Integer id) throws SQLException	
	   {
		   Session session=DBConnection.buildConection();
		   Transaction tx=session.beginTransaction();
		   
		   Account account=(Account) session.createQuery("from Account where userid="+id).uniqueResult();
		   session.close();
		   return account;
		   
		   
		   
		   
		   
	   }
	
	   public static void addAccountRecord(AccountRecord ar) throws SQLException
	   {
		   Session session=DBConnection.buildConection();
		   Transaction tx=session.beginTransaction();
		   session.save(ar);
		   tx.commit();
		   session.close();
		   
		   
		   
		   
	   }
	   
	   public static void fine(Integer accountid,double money) throws SQLException
	   {
	 	  Session session=DBConnection.buildConection();
	 	  Transaction tx=session.beginTransaction();
	 	  Account a=session.get(Account.class, accountid);
	 	  a.setBalance(a.getBalance()-money);
	 	  session.update(a);
	 	  tx.commit();
	 	  session.close();
	 	  
	 	  
	   }
	   
	   public static void AddLoseRecord(LoseRecord lr) throws SQLException
	   {
		   Session session=DBConnection.buildConection();
		   Transaction tx=session.beginTransaction();
		   session.save(lr);
		   tx.commit();
		   session.close();
		   
		   
		   
	   }
	   
	   public static LoseRecord getLoseRecord(Integer userid,Integer bookid) throws SQLException
	   {
		   Session session=DBConnection.buildConection();
		   Transaction tx=session.beginTransaction();
		   LoseRecord lr=(LoseRecord) session.createQuery("from LoseRecord where userid="+userid+"and bookid="+bookid).uniqueResult();
		
		   session.close();
		   return lr;
		   
		   
		   
	   }

       public static void addReserveRecord(ReserveRecord rr) throws SQLException
       {
    	   Session session=DBConnection.buildConection();
		   Transaction tx=session.beginTransaction();
    	   session.save(rr);
    	   tx.commit();
    	   session.close();
    	   
    	   
    	   
       }
	   
	   public static List<ReserveRecord> queryreserverecordbyUser(Integer userid) throws SQLException
	   {
		   Session session=DBConnection.buildConection();
		   Transaction tx=session.beginTransaction();
		   List<ReserveRecord>list=session.createQuery("from ReserveRecord where userid="+userid).list();
		   session.close();
		   return list;
		   
		   
	   }
	   
	   public static List<ReserveRecord> queryreserverecordbyBook(Integer bookid) throws SQLException
	   {
		   Session session=DBConnection.buildConection();
		   Transaction tx=session.beginTransaction();
		   List<ReserveRecord>list=session.createQuery("from ReserveRecord where bookid="+bookid).list();
		   session.close();
		   return list;
		   
		   
	   }

	public static void DeleteReserveRecord(int reserverecordid) throws SQLException {
		 Session session=DBConnection.buildConection();
		 Transaction tx=session.beginTransaction();
		 ReserveRecord rr=session.get(ReserveRecord.class, reserverecordid);
		 session.delete(rr);
		 tx.commit();
		 session.close();
		 
		 
		 
	}

}
	


