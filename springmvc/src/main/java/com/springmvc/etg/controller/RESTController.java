package com.springmvc.etg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.etg.model.Task;

@RestController
public class RESTController {
	
	//@RequestMapping(value="/resthello", method = RequestMethod.GET,produces = "application/json")
	@GetMapping("/resthello")
	public String getHello() {
		return "Hello How are you";
	}
	
	@GetMapping("/resttask")
	public Task getTask() {
		Task task = new Task();
		task.setTaskId(1000);
		task.setName("Create REST Service");
		return task;
	}
	
	@GetMapping("/resttasks")
	public List<Task> getTasks() {
		List<Task> list = new ArrayList<Task>();
		Task task = new Task();
		task.setTaskId(1000);
		task.setName("Create REST Service");
		list.add(task);
		task.setTaskId(1001);
		task.setName("Create Task Service");
		list.add(task);
		return list;
	}
}
