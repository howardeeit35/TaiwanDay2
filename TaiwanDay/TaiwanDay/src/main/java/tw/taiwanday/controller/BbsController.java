package tw.taiwanday.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.taiwanday.model.BbsBean;
import tw.taiwanday.model.BbsService;




@Controller
public class BbsController {
	@Autowired
	private BbsService bService;
	
	@RequestMapping(path = "/content",method = RequestMethod.GET)
	public String processContentAction() {
		return "Content";
	}
	
	@RequestMapping(path = "/mainpage",method = RequestMethod.GET)
	public String processMainPagesAction() {
		return "forward:/findDB.controller";
	}
	
	@RequestMapping(path = "/updatecontent",method = RequestMethod.GET)
	public String processUpdateAction(@RequestParam("no") String no,@RequestParam("content") String bbscontent,@RequestParam("grades") String bbsgrades,Model m) {
		HashMap<String, String> data = new HashMap<String, String>();
		m.addAttribute("data",data);
		data.put("no",no);
		data.put("content",bbscontent);
		data.put("grades",bbsgrades);
		return "UpdateContent";
	}
	
	@RequestMapping(path = "/deletecontent",method = RequestMethod.GET)
	public String processDeleteAction() {
		return "DeleteContent";
	}
	
	@RequestMapping(path = "/insertDB.controller",method = RequestMethod.POST)
	public String processInsertDBAction(@RequestParam("name") String name,@RequestParam("content") String content,@RequestParam("grades") String grades,Model m) {
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors",errors);
		
		if(name==null || name.length()==0) {
			errors.put("name", "姓名不可空白");
		}
		
		if(content==null || content.length()==0) {
			errors.put("content", "留言不可空白");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "Content";
		}
		
		bService.insert(new BbsBean(name, content, grades));

		return "redirect:/findDB.controller";
	}
	
	@RequestMapping(path = "/updateDB.controller",method = RequestMethod.GET)
	public String processUpdateDBAction(@RequestParam("no") String no,@RequestParam("content") String bbscontent,@RequestParam("grades") String bbsgrades,Model m) {
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors",errors);
		
		if(no==null || no.length()==0) {
			errors.put("no", "不可空白");
		}
		
		if(bbscontent==null || bbscontent.length()==0) {
			errors.put("content", "留言不可空白");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "UpdateContent";
		}
		int bbsid = Integer.parseInt(no);
		System.out.println(bbsid+bbscontent+bbsgrades);
		BbsBean update = bService.update(new BbsBean( bbsid, bbscontent, bbsgrades));
		System.out.println(update.getId()+update.getContent()+update.getGrades());

				
		return "redirect:/findDB.controller";
	}
	
	@RequestMapping(path = "/deleteDB.controller",method = RequestMethod.GET)
	public String processDeleteDBAction(@RequestParam("no")int no,Model m) {
		
		
		HashMap<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors",errors);
		
		if(no==0) {
			errors.put("no", "不可為零");
		}

		bService.delete(no);
		
		return "redirect:/findDB.controller";
	}
	
	@RequestMapping(path = "/findDB.controller",method = RequestMethod.GET)
	public String processFindDBAction(Model m) {
		List<BbsBean> query = bService.findAll();
		m.addAttribute("query",query);
		return "MainPage";
	}

}

