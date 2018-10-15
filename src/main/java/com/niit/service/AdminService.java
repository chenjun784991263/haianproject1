package com.niit.service;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Parameter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.niit.Bean.BookBean;
import com.niit.constants.MessageConstant;
import com.niit.dao.AdminDao;
import com.niit.dao.UserDAO;
import com.niit.dbutil.DBConnection;
import com.niit.model.Book;
import com.niit.model.Publisher;
import com.niit.model.Type;
import com.niit.model.User;

public class AdminService {
	public static List<User> QueryAllUser() throws SQLException
	{
		
	 return	AdminDao.QueryAllUser();
		
		
		
	}
	
	public static void DeleteUser(Integer id) throws SQLException
	{
		AdminDao.DeleteUser(id);
		
	}
	
	public static User getUser(Integer id) throws SQLException
	{
		return AdminDao.getUser(id);
		
	}
	
	
	public static void EditUser(User user) throws SQLException 
	{
		AdminDao.EditUser(user);
		
		
	}
	
    public static void ChangeUserState(Integer id) throws SQLException
    {
    	AdminDao.ChangeUserState(id);
    	
    	
    }

    public static List<BookBean> QueryBook() throws SQLException {
        return	AdminDao.QueryBook();
     
    }
    
    public static Integer addBookType(Type booktype) throws SQLException {
	
		if(booktype!=null) {
			Integer flag=AdminDao.addBookType(booktype);
			return flag;
		}else {
			return MessageConstant.BookType_ISNULL;
		}
	}


	public static Integer addPublisher(Publisher publisher) throws SQLException {
	
		if(publisher!=null) {
			Integer flag=AdminDao.addPublisher(publisher);
			return flag;
		}else {
			return MessageConstant.Pubisher_ISNULL;
		}
	}
	
	public static Integer addBook(Book book) throws SQLException {
		
		if(book!=null) {
			Integer flag=AdminDao.addBook(book);
			return flag;
		}else {
			return MessageConstant.Book_ISNULL;
		}
	}

	
}
