package tw.taiwanday.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "users")
@Component
public class BbsBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String content;
	private String grades;
	

	public BbsBean() {
		// TODO Auto-generated constructor stub
	}


	public BbsBean(int id, String content, String grades) {
		this.id = id;
		this.content = content;
		this.grades = grades;
	}

	public BbsBean(String userName, String content, String grades) {
		this.userName = userName;
		this.content = content;
		this.grades = grades;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String context) {
		this.content = context;
	}


	public String getGrades() {
		return grades;
	}


	public void setGrades(String grades) {
		this.grades = grades;
	}
	
	

}
