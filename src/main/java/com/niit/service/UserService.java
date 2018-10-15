package com.niit.service;

import java.sql.SQLException;
import java.util.List;

import com.niit.constants.MessageConstant;
import com.niit.dao.UserDAO;
import com.niit.model.User;

/*created by :-prateek kamdar
created date:-13/9/2018
updated by:-null
updated date:-null 
*/



public class UserService {

	public static Integer addUser(User user) throws SQLException {
	
		if(user!=null) {
			Integer flag=UserDAO.addUser(user);
			return flag;
		}else {
			return MessageConstant.USER_ISNULL;
		}
	}

	public static Integer login(User user) throws SQLException {
		if(user!=null) {
			Integer flag=UserDAO.login(user);
			return flag;
		}else {
			return MessageConstant.SOMETHING_WRONG;
		}
	}

	
	

}
