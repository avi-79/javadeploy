package com.springmvc.etg.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.etg.AddInterface;
import com.springmvc.etg.dao.TaskSystemDAO;
import com.springmvc.etg.model.Task;

@Controller
@SessionAttributes("username")
public class HelloConroller {

	@Autowired
	AddInterface add;
	@Autowired
	TaskSystemDAO taskSystemDAOImpl;
	//handler method
	@RequestMapping(value = "/sayhello",method=RequestMethod.GET)
	public String sayHello(Model model) {
		model.addAttribute("msg", "Hi How are you");
		return "hello";
	}
	
	@RequestMapping("/gettask/abc")
	public String getTask(Model model) {
		Task task = new Task();
		task.setTaskId(1000);
		task.setName("Create a controller");
		model.addAttribute("task", task);
		return "task";
	}
	
	@RequestMapping("/")
	public String sayHello1(ModelMap map) {
		return "addform";
	}
	
	@RequestMapping("/mav")
	public ModelAndView sayHello2() {
		ModelAndView m = new ModelAndView("home");
		m.addObject("name", "Example of ModelAndView");
		return m;
	}
	
	@RequestMapping("/home")
	public void sayHello3(Model model,@RequestParam("no1") int no1, @RequestParam("no2") int no2) {
		int r = add.add(no1, no2);
		
		model.addAttribute("name", r);
	}
	
	@RequestMapping("/addnumbers/{no1}/abc/{no2}")
	public String sayHello4(Model model, @PathVariable int no1, @PathVariable int no2) {
		int r = add.add(no1, no2);
		model.addAttribute("name", r);
		return "home";
	}
	
	@RequestMapping("/getalltasks")
	public String getAllTasks(Model model) {
		model.addAttribute("tasklist",taskSystemDAOImpl.getAllTask() );
		return "task";
	}

}
