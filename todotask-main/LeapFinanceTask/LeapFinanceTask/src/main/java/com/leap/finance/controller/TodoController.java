package com.leap.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leap.finance.dto.APIResponse;
import com.leap.finance.dto.TaskDto;
import com.leap.finance.service.TodoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/leapfinance")
public class TodoController {
	
	
	@Autowired
	TodoService todoService;
	
	@GetMapping(value = "gettodolistdata")
	public ResponseEntity<List<TaskDto>> getTodoListData() {
		
		System.out.println("Fetching all existing to-do task details");
		
		return ResponseEntity.ok(todoService.getTodoTaskList());
	}
	
	
	@PostMapping(value = "addnewtodotask")
    public APIResponse createNewTodoTask(@RequestBody TaskDto taskDto) {
		System.out.println("Adding new to-do task details " + taskDto);
		
        return todoService.addNewTodoTask(taskDto);
    }
	
	
	@PutMapping(value = "edittodotask")
	public ResponseEntity<ResponseEntity<TaskDto>> updateTodoTaskData(@RequestBody TaskDto taskDetails) {

		 System.out.println("Updating the to-do task details for --> " + taskDetails + " & task id --> " + taskDetails.getId());

		 
		 return ResponseEntity.ok(todoService.updateTaskDetails(taskDetails));

	}
	
	@DeleteMapping(value = "deletetask/{id}")
	private APIResponse deleteTodoTaskData(@PathVariable("id") int id) {
		
		System.out.println("Deleting the to-do task details for task id --> " + id);
		
		return todoService.deleteTaskById(id);
	}

}
