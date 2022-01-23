package com.springmvc.etg.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.etg.dao.impl.TaskSystemDAOImpl;
import com.springmvc.etg.model.Task;

@RestController
public class TaskRESTContoller {
	@Autowired
	TaskSystemDAOImpl taskSystemDAOImpl;
	
	@PostMapping("/restaddtask")
	public ResponseEntity<Task> addTask(@RequestBody Task task) throws SQLException {
		taskSystemDAOImpl.addTask(task);
		return new ResponseEntity<Task>(task,HttpStatus.OK);
	}
	
	@GetMapping("/restgettask/{taskid}")
	public Task getTask(@PathVariable int taskid) throws SQLException {
		return taskSystemDAOImpl.getTask(taskid);
	}
	
	@PutMapping("/updateownerid/{taskid}/{ownerid}")
	public void updateOwnerid(@PathVariable int taskid, @PathVariable int ownerid) {
		taskSystemDAOImpl.assignOwner(taskid, ownerid);
	}
}
