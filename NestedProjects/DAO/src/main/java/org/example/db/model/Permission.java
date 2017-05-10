package org.example.db.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Permission{

	@Id
	@GeneratedValue
	private Integer id;
	
	private String value;

	@ManyToMany(mappedBy="permissions")
	private List<Role> roles = new ArrayList<>();
	
	public Permission() {}

	public Permission(Integer id,String value) {
		super();
		this.id=id;
		this.value = value;
	}

	public Permission(Integer id,String value,List<Role> roles) {
		super();
		this.id=id;
		this.value = value;
		this.roles=roles;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	/* ********************************************************************************************************************************************/
	/* ********************************************************************************************************************************************/
	/* ********************************************************************************************************************************************/

	

	public static List<Permission> convertModelToEntity(List<org.example.model.Permission> list){
		if(list==null)return null;
		List<Permission> permissions = new ArrayList<>();
		for(org.example.model.Permission p : list){
			permissions.add(new Permission(p.getId(),p.getValue()));
		}
		return permissions;
	}
	
	public static List<org.example.model.Permission> convertEntityToModel(List<Permission> list){
		if(list==null)return null;
		List<org.example.model.Permission> permissions = new ArrayList<>();
		for(Permission p : list){
			permissions.add(new org.example.model.Permission(p.id,p.getValue()));
		}
		return permissions;
	}
	
	
	
}
