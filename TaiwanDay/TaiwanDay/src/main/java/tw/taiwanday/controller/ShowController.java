package tw.taiwanday.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.taiwanday.model.Show;
import tw.taiwanday.model.ShowService;

@Controller
public class ShowController {

	@Autowired
	private ShowService sService;
	
	@GetMapping("/listShow")
	public String listShow(Model m){
		List<Show> listShow = sService.getAll();
		m.addAttribute("shows" , listShow);
		return "list-show";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model m) {
		Show show = new Show();
		m.addAttribute("show",show);
		return "inster";
	}
	
	@PostMapping("/saveShow")
	public String saveShow(@RequestParam("title") String title, @RequestParam("name") String name, @RequestParam("sdate") String sdate, @RequestParam("edate") String edate,
								@RequestParam("price") String price) {
			
		System.out.println(title+ name +sdate +edate +price);
		Show show = new Show(title, name ,sdate ,edate ,price);
		sService.inster(show);
		return "redirect:/listShow";
		
	}
	
	
	@GetMapping("/delete")
	public String deleteShow(@RequestParam("showId") int id) {
		Show show = new Show();
		show.setId(id);
		sService.delete(id);
		return "redirect:/listShow";
	}
	
	@GetMapping("/getById")
	public String getShowById(@RequestParam("showId") int id , Model m) {
		Show show = sService.getShowById(id);
		m.addAttribute("temp", show);
		return "update";
	}
	
	@PostMapping("/update")
	public String updateShow(@RequestParam("title") String title, @RequestParam("name") String name, @RequestParam("sdate") String sdate, @RequestParam("edate") String edate,
								@RequestParam("price") String price) {
			
		System.out.println(title+ name +sdate +edate +price);
		Show show = new Show(title, name ,sdate ,edate ,price);
		sService.update(show);
		return "redirect:/listShow";
	}
	
}
