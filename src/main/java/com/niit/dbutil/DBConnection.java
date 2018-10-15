package com.niit.dbutil;


import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*created by :-prateek kamdar
created date:-12/9/2018
updated by:-null
updated date:-null 
*/

public class DBConnection {

	public static Session buildConection() throws SQLException {
	
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		return session;
	}

}
