package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TaskDto;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService; 
	
	@RequestMapping(value = {"/all"}, method = RequestMethod.GET)
	public ResponseEntity<List<TaskDto>> obtenerTasks() {
		List<TaskDto> listaTasks =  taskService.getAllTasks();
		//hay una libreria que se llama StringUtils con su opcion de isBlank o isEmpty que devuelve o un true o un false
		if(listaTasks.size() == 0) {
			return new ResponseEntity<List<TaskDto>>(new ArrayList<TaskDto>(), HttpStatus.NOT_FOUND);
		}
	    return new ResponseEntity<List<TaskDto>>(listaTasks, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/task/{id}"}, method = RequestMethod.GET)
	public ResponseEntity<TaskDto> obtenerTask(
			@PathVariable(value = "id") int id) {
		TaskDto taskDto =  taskService.getTask(id);
		//hay una libreria que se llama StringUtils con su opcion de isBlank o isEmpty que devuelve o un true o un false
		if(taskDto == null) {
			return new ResponseEntity<TaskDto>(new TaskDto(), HttpStatus.NOT_FOUND);
		}
	    return new ResponseEntity<TaskDto>(taskDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/task/{task}"}, method = RequestMethod.POST)
	public ResponseEntity<TaskDto> insertarTask(
			@RequestBody TaskDto task) {
		boolean bien = taskService.createTask(task);
		//hay una libreria que se llama StringUtils con su opcion de isBlank o isEmpty que devuelve o un true o un false
		if(!bien) {
			return new ResponseEntity<TaskDto>(task, HttpStatus.BAD_REQUEST);
		}
	    return new ResponseEntity<TaskDto>(task, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/task/{task}"}, method = RequestMethod.PUT)
	public ResponseEntity<TaskDto> updateTask(
			@RequestBody TaskDto task) {
		boolean bien = taskService.createTask(task);
		//hay una libreria que se llama StringUtils con su opcion de isBlank o isEmpty que devuelve o un true o un false
		if(!bien) {
			return new ResponseEntity<TaskDto>(task, HttpStatus.BAD_REQUEST);
		}
	    return new ResponseEntity<TaskDto>(task, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/task/{id}"}, method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteTask(
			@PathVariable(value = "id") int id) {
		taskService.deleteTask(id);
	    return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	

}
