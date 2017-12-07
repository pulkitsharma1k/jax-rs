package com.pulkit.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




import org.hibernate.query.Query;

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
	
	public UserDetail updateUser(UserDetail user) {
		
		
		
		
		session.getTransaction().begin();
		Query query = session.createSQLQuery(
				"update userTable set name='" + user.getName() + "',email='" + user.getEmail() + "'  , address='" + user.getAddress() + "' where id='" + user.getId() + "'");
	
		int result = query.executeUpdate();
		session.getTransaction().commit();
		
		
	
		
		return user;
	}

	public UserDetail deleteUser(UserDetail user) {
		
		
		
		
		session.getTransaction().begin();
		Query query = session.createSQLQuery(
				"delete from userTable  where id='" + user.getId() + "'");
	
		int result = query.executeUpdate();
		session.getTransaction().commit();
		
		
	
		
		return user;
	}
}
