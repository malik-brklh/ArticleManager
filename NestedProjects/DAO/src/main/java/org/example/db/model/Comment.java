package org.example.db.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment  {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user = new User();
	
	private String value;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="articleid")
	private Article article = new Article();
	
	public Comment() {}

//	public Comment(Integer id,User writer, String value, Date date) {
//		super();
//		this.id=id;
//		this.user = user;
//		this.value = value;
//		this.date = date;
//	}
//
//	public Comment(Integer id,User user, String value, Date date,List<Article> articles) {
//		super();
//		this.id=id;
//		this.user = user;
//		this.value = value;
//		this.date = date;
//	}
//	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	

	/* ************************************************* */
	/* ************************************************* */
	/* ************************************************* */
	/* ************************************************* */
//	public static List<Comment> convertModelToEntity(List<org.example.model.Comment> list){
//		if(list==null)return null;
//		List<Comment> list2 = new ArrayList<>();
//		for(org.example.model.Comment p : list){
//			list2.add(new Comment(p.getId(), User.convertModelToEntity(p.getWriter()), p.getValue(),p.getDate()));
//		}
//		return list2;
//	}
//	
//	public static List<org.example.model.Comment> convertEntityToModel(List<Comment> list){
//		if(list==null)return null;
//		List<org.example.model.Comment> list2 = new ArrayList<>();
//		for(Comment p : list){
//			list2.add(new org.example.model.Comment(p.getId(), User.convertEntityToModel(p.getWriter()), p.getValue(),p.getDate()));
//		}
//		return list2;
//	}
	
	
}
