package com.pulkit.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




import com.pulkit.model.UserDetail;


public class UserDaoImpl implements UserDao {

	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetail.class);
	SessionFactory sf = con.buildSessionFactory();
	Session session = sf.openSession();
	
	@Override
	public UserDetail saveuser(UserDetail user) {
		
		
		Transaction tx = session.beginTransaction();
		session.save(user);
		
		tx.commit();
		
		return user;
	}

	
	public List<UserDetail> getuser() {
		
		List<UserDetail> userlist = session.createCriteria(UserDetail.class).list();
		return userlist;
	}
	


}
