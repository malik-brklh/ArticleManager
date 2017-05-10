package org.example.dao;

import org.example.config.HibernateUtil;
import org.example.db.model.User;

public class UserDAO {

//	public static org.example.model.User select(Integer id){
//		return User.convertEntityToModel((User) HibernateUtil.getSession().get(User.class, id));
		
//	}
	
	public static void save(User u){
		HibernateUtil.save(u);
		
	}
	
	
	public boolean delete(){return false;}
	public boolean updateInformation(){return false;}
	public boolean updatePassword(){return false;}
	public boolean addRoles(){return false;}
	public boolean deleteRoles(){return false;}
	
	
}
