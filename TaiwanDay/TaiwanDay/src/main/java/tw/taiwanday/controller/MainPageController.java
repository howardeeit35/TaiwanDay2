package tw.taiwanday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.taiwanday.model.BbsDao;

@Controller
public class MainPageController {
	@Autowired
	private BbsDao bDao;
	
	@RequestMapping(path = "/realmainpage",method = RequestMethod.GET)
	public String processContentAction() {
		return "RealMainPage";
	}
	
	@RequestMapping(path = "/returnmainpage",method = RequestMethod.GET)
	public String returnAction() {
		return "redirect:/realmainpage";
	}

}
