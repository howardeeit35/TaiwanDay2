package tw.taiwanday.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import tw.taiwanday.model.HotelBean;
import tw.taiwanday.model.HotelService;
import tw.taiwanday.model.Show;

@Controller
public class HotelController {
	
	@Autowired
	
	private HotelService hService;
	
	
	@GetMapping("/hotelView")//select
	public String hotelview(Model m){
		List<HotelBean> hotelview = hService.getAll();
		m.addAttribute("hotelBeans" , hotelview);
		return "hotelView";
	}
	
	@GetMapping("/hotelForm")//insert
	public String hotelFormForAdd(Model m) {
		HotelBean hotel = new HotelBean();
		m.addAttribute("hotel",hotel);
		return "insertView";
	}
	
	@PostMapping("/saveHotel")//insert
	public String saveHotel( @RequestParam("hotelname") String hotelName, @RequestParam("hotelphonenum") String hotelPhonenum,
			 @RequestParam("hoteladdress") String hotelAddress, @RequestParam("hotelprice") String hotelPrice,@RequestParam("roomstyle") String roomStyle,
			 @RequestParam("checkindate") String checkinDate, @RequestParam("checkoutdate") String checkoutDate) {
			
		System.out.println(hotelName + hotelPhonenum + hotelAddress + hotelPrice + roomStyle + checkinDate + checkoutDate);
		HotelBean hBean = new HotelBean(hotelName, hotelPhonenum ,hotelAddress ,hotelPrice ,roomStyle,checkinDate,checkoutDate);
		hService.insert(hBean);
		return "redirect:/hotelView";
		
	
		
	}
	
	@PostMapping("/updatehotel") //update
	public String updatehotel(@RequestParam("hotelid") int hotelId, @RequestParam("hotelname") String hotelName,@RequestParam("hotelphonenum") String hotelPhonenum,
			 @RequestParam("hoteladdress") String hotelAddress, @RequestParam("hotelprice") String hotelPrice,@RequestParam("roomstyle") String roomStyle,
			 @RequestParam("checkindate") String checkinDate, @RequestParam("checkoutdate") String checkoutDate) {
		
		System.out.println(hotelId + "," + hotelName + "," + hotelPhonenum + "," + hotelAddress + "," + hotelPrice + "," + roomStyle + "," + checkinDate + "," + checkoutDate);
		HotelBean hotel = new HotelBean(hotelId, hotelName, hotelPhonenum, hotelAddress, hotelPrice, roomStyle, checkinDate, checkoutDate);
		hService.update(hotel);
		return "redirect:/hotelView";
	}
	
	
	@GetMapping("/deletehotel") //delete
	public String deleteShow(@RequestParam("hotelid") int hotelId) {
		HotelBean hotel = new HotelBean();
		hotel.setHotelId(hotelId);
		hService.delete(hotelId);
		return "redirect:/hotelView";
	}
	
	
	@GetMapping("/getHotelById")
	public String getHotelBeanById(@RequestParam("hotelid") String hotelId ,@RequestParam("hotelname") String hotelName,@RequestParam("hotelphonenum") String hotelPhonenum,
			 @RequestParam("hoteladdress") String hotelAddress, @RequestParam("hotelprice") String hotelPrice,@RequestParam("roomstyle") String roomStyle,
			 @RequestParam("checkindate") String checkinDate, @RequestParam("checkoutdate") String checkoutDate, Model m) {
		HashMap<String, String> hotel = new HashMap<String, String>();
		m.addAttribute("updatehotel", hotel);
		hotel.put("hotelId", hotelId);
		hotel.put("hotelName", hotelName);
		hotel.put("hotelPhonenum", hotelPhonenum);
		hotel.put("hotelAddress", hotelAddress);
		hotel.put("hotelPrice", hotelPrice);
		hotel.put("roomStyle", roomStyle);
		hotel.put("checkinDate", checkinDate);
		hotel.put("checkoutDate", checkoutDate);
		return "updateView";
	}
	
	
}
