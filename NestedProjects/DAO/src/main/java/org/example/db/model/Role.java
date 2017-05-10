package org.example.db.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role{

	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "role_permission", 
		joinColumns = { @JoinColumn(name = "roleid") },
		inverseJoinColumns = { @JoinColumn(name = "permissionid") }
	)
	private List<Permission> permissions = new ArrayList<>();
	
	@ManyToMany(mappedBy="roles",cascade = CascadeType.ALL)
	private List<User> users = new ArrayList<>();
	
	public Role() {}

	public Role(Integer id,String name, List<Permission> permissions) {
		super();
		this.id=id;
		this.name = name;
		this.permissions = permissions;
	}


	public Role(Integer id,String name, List<Permission> permissions,List<User> users) {
		super();
		this.id=id;
		this.name = name;
		this.permissions = permissions;
		this.users=users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	/* ***************************************** ******************************** ******************************** ******************************** */
	/* ***************************************** ******************************** ******************************** ******************************** */
	/* ***************************************** ******************************** ******************************** ******************************** */
	
	public static List<Role> convertModelToEntity(List<org.example.model.Role> list){
		if(list==null)return null;
		List<Role> returnList = new ArrayList<>();
		for(org.example.model.Role r : list){
			returnList.add(new Role(r.getId(),r.getName(),Permission.convertModelToEntity(r.getPermissions())));
		}
		return returnList;
	}
	
	public static List<org.example.model.Role> convertEntityToModel(List<Role> list){
		if(list==null)return null;
		List<org.example.model.Role> returnList = new ArrayList<>();
		for(Role r : list){
			returnList.add(new org.example.model.Role(r.id,r.getName(),Permission.convertEntityToModel(r.getPermissions())));
		}
		return returnList;
	}
}
