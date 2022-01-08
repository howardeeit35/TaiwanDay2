package tw.taiwanday.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "show1")
public class Show{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;

	@Column(name = "name")
	private String name;

	@Column(name = "sdate")
	private String sdate;

	@Column(name = "edate")
	private String edate;

	@Column(name = "price")
	private String price;

	public Show() {
	}
	
	public Show(String title, String name, String sdate,
			String edate,String price) {
		super();
		this.title = title;
		this.name = name;
		this.sdate = sdate;
		this.edate = edate;
		this.price = price;
	}
	
	public Show(int id, String title, String name, String sdate,
			String edate,String price) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.sdate = sdate;
		this.edate = edate;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Show [id=" + id + ", title=" + title + ", name=" + name + ", sdate=" + sdate + ", edate=" + edate
				+ ", price=" + price + "]";
	}
	
	

}
