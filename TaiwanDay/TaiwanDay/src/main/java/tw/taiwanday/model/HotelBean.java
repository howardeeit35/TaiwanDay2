package tw.taiwanday.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "hotel")
@Component("hotel")
public class HotelBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @Column(name = "hotelid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelId;
	
	@Column(name = "hotelname")
	private String hotelName;
	
	@Column(name = "hotelphonenum")
	private String hotelPhoneNum;

	@Column(name = "hoteladdress")
	private String hotelAddress;
	
	@Column(name = "hotelprice")
	private String hotelPrice;
	
	@Column(name = "roomstyle")
	private String roomStyle;
	
//	@JsonFormat(pattern= "yyyy-MM-dd" ,timezone = "GMT+8")
//	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Column(name = "checkindate")
	private String checkinDate;

//	@JsonFormat(pattern= "yyyy-MM-dd" ,timezone = "GMT+8")
//	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Column(name = "checkoutdate")
	private String checkoutDate;
	
	public HotelBean() {
	}
	
	//新增
	public HotelBean( String hotelName, String hotelPhoneNum,String hotelAddress, String hotelPrice,String roomStyle,String checkinDate,String checkoutDate) {
		
		this.hotelName = hotelName;
		this.hotelPhoneNum = hotelPhoneNum;
		this.hotelAddress = hotelAddress;
		this.hotelPrice = hotelPrice;
		this.roomStyle = roomStyle;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}
	
	
	//查詢 修改 刪除
	public HotelBean(int hotelId, String hotelName, String hotelPhoneNum,String hotelAddress, String hotelPrice,String roomStyle,String checkinDate,String checkoutDate) {
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelPhoneNum = hotelPhoneNum;
		this.hotelAddress = hotelAddress;
		this.hotelPrice = hotelPrice;
		this.roomStyle = roomStyle;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelPhoneNum() {
		return hotelPhoneNum;
	}

	public void setHotelPhoneNum(String hotelPhoneNum) {
		this.hotelPhoneNum = hotelPhoneNum;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(String hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	public String getRoomStyle() {
		return roomStyle;
	}

	public void setRoomStyle(String roomStyle) {
		this.roomStyle = roomStyle;
	}

	public String getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	
}
