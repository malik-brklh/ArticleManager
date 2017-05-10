package org.example.test;

import java.util.Date;

import org.example.config.HibernateUtil;
import org.example.db.model.Article;
import org.example.db.model.Comment;
import org.example.db.model.Permission;
import org.example.db.model.Role;
import org.example.db.model.User;

public class TestDB {

	public static void main(String[] args) {
		
		Permission p1 = new Permission(null,"v1");
		Permission p2 = new Permission(null,"v2");
		Permission p3 = new Permission(null,"v3");		
		
		a(p1);
		a(p2);
		a(p3);
		
		Role r1 = new Role();
		Role r2 = new Role();
//		r1.setId(1);
//		r2.setId(2);
		r1.setName("r1");
		r2.setName("r1");
		a(r1);
		a(r2);
		
		r1.getPermissions().add(p1);
		r1.getPermissions().add(p2);
		r2.getPermissions().add(p2);
		r2.getPermissions().add(p3);
		
		p1.getRoles().add(r1);
		p2.getRoles().add(r1);
		p2.getRoles().add(r2);
		p3.getRoles().add(r2);
		
		a(r1);
		a(r2);
		
		  User user1=new User();
//		  user1.setId(11);
		  user1.setFirstName("Malik");
		  user1.setUsername("malik-brklh");
		  user1.setEmail("malik.barkallah@gmail.com");
		  user1.setLastName("BARKALLAH");
		  user1.setPassword("123456");
		  
		  user1.getRoles().add(r1);
		  user1.getRoles().add(r2);
		  
		  r1.getUsers().add(user1);
		  r2.getUsers().add(user1);
		  
//		  
		  Article a1 = new Article();
//		  a1.setId(3);
		  a1.setDate(new Date());
		  a1.setText("sdcsdcdscdscsdc sdcsdc dsc sdc sdcsdc sdc ");
		  a1.setUser(user1);
		  a1.setTitle("cds");
		  user1.getArticles().add(a1);
		  
		  Comment c1 = new Comment();
		  c1.setDate(new Date());
		  c1.setValue("aaa");
		  c1.setArticle(a1);
		  c1.setUser(user1);
		  
		  
		  
		  a(user1);
		  
		  a(c1);
	}
	
	
	
	public static void a(Object o){
		HibernateUtil.getSession().saveOrUpdate(o);
		HibernateUtil.commit();
	}
}
