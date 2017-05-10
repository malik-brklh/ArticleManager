package org.example.db.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Article {

	@Id
	@GeneratedValue
	private Integer id;
	
//	
	@OneToMany(mappedBy="article",cascade=CascadeType.ALL)
	private List<Comment> comments;
	
	
	   
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="userId")
	private User user = new User();
	
	private String title;
	private Date date;
	private String text;
	
	public Article() {}

	public Article(Integer id, User writer, String title, Date date, String text, List<Comment> comments) {
		super();
		this.id=id;
		this.user = writer;
		this.title = title;
		this.date = date;
		this.text = text;
		this.comments = comments;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//
//	public static List<Article> convertModelToEntity(List<org.example.model.Article> list){
//		if(list==null)return null;
//		List<Article> returnList = new ArrayList<>();
//		for(org.example.model.Article r : list){
//			returnList.add(new Article(r.getId(),User.convertModelToEntity(r.getWriter()), r.getTitle(), r.getDate(), r.getText(), Comment.convertModelToEntity(r.getComments())));
//		}
//		return returnList;
//	}
//	
//	public static List<org.example.model.Article> convertEntityToModel(List<Article> list){
//		if(list==null)return null;
//		List<org.example.model.Article> returnList = new ArrayList<>();
//		for(Article r : list){
//			returnList.add(new org.example.model.Article(r.getId(),User.convertEntityToModel(r.getUser()), r.getTitle(), r.getDate(), r.getText(), Comment.convertEntityToModel(r.getComments())));
//		}
//		return returnList;
//	}
}
