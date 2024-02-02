package com.leap.finance.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.finance.dto.APIResponse;
import com.leap.finance.dto.TaskDto;

@Service
public interface TodoService {

	public List<TaskDto> getTodoTaskList();
	
	public APIResponse addNewTodoTask(TaskDto taskDto);

	public ResponseEntity<TaskDto> updateTaskDetails(TaskDto taskDetails);

	public APIResponse deleteTaskById(int id);

	

}
