package org.example.db.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class User {

	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	
	
	
	   
	
	@OneToMany( mappedBy="user",cascade=CascadeType.ALL)
	private List<Article> articles = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "user_role",
		joinColumns = {
			@JoinColumn(name = "userid") },
		inverseJoinColumns = { @JoinColumn(name = "roleid") })
	private List<Role>  roles = new ArrayList<>();
	

	public User() {}

	public User(Integer id, String firstName, String lastName, String username, String email, String password,
			List<Article> articles, List<Role> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.articles = articles;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

//	public static org.example.model.User convertEntityToModel(User u){
//		if(u==null)return null;
//		return new org.example.model.User(u.id, u.firstName, u.lastName, u.username, u.email, u.password,Article.convertEntityToModel(u.articles) , Role.convertEntityToModel(u.roles));
//	}
//
//	public static User convertModelToEntity(org.example.model.User u){
//		if(u==null)return null;
//		return new User(u.getId(), u.getFirstName(), u.getLastName(), u.getUsername(), u.getEmail(), u.getPassword(),Article.convertModelToEntity(u.getArticles()), Role.convertModelToEntity(u.getRoles()));
//	}
	
}
