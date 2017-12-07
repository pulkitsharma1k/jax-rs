package com.pulkit.webappjersey;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;










import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pulkit.Repository.UserDao;
import com.pulkit.Repository.UserDaoImpl;
import com.pulkit.model.UserDetail;

@Path("/")
public class UserResource {
	
	
	UserDao usrdao;

	Configuration con = new Configuration().configure().addAnnotatedClass(UserDetail.class);
	SessionFactory sf = con.buildSessionFactory();
	Session session = sf.openSession();
	
	@GET
	@Path("getuser")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<UserDetail> getuser() {
		
		List<UserDetail> userlist = session.createCriteria(UserDetail.class).list();
		return userlist;
	}
	
	@POST
	/*@Produces(MediaType.APPLICATION_JSON)*/
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("saveUser")
	public UserDetail saveuser(UserDetail user){
		
		UserDaoImpl usr = new UserDaoImpl();
		usr.saveuser(user);
		return user;
		
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("updateuser")
	public UserDetail updateUser(UserDetail user){
		UserDaoImpl usr = new UserDaoImpl();
		
		usr.updateUser(user);
		
		return user;
		
	}
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("updateuser")
	public UserDetail deleteUser(UserDetail user){
		UserDaoImpl usr = new UserDaoImpl();
		
		usr.deleteUser(user);
		
		return user;
		
	}
	

}
