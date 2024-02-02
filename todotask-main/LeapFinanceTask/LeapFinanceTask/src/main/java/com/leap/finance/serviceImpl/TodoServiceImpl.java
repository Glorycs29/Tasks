package com.leap.finance.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.finance.dto.APIResponse;
import com.leap.finance.dto.TaskDto;
import com.leap.finance.entity.TaskEntity;
import com.leap.finance.repository.TodoRepository;
import com.leap.finance.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public List<TaskDto> getTodoTaskList() {

		List<TaskDto> taskDtoList = new ArrayList<TaskDto>();

		try {

			List<TaskEntity> taskEntityList = todoRepository.findAllTaskListData();

			int i = 0;
			for (TaskEntity taskEntity : taskEntityList) {
				TaskDto tempTaskDto = new TaskDto();
				mapper.map(taskEntity, tempTaskDto);
				i++;
				tempTaskDto.setPosition(i + "");

				taskDtoList.add(tempTaskDto);
			}

			System.out.println(
					"total todo task list size is '" + taskEntityList.size() + "'  & data are --> " + taskEntityList);

		} catch (Exception e) {
			System.out.println("Exception occured due to ## " + e.getMessage());
			return  null;
		}
		
		return taskDtoList;
	}

	@Override
	public APIResponse addNewTodoTask(TaskDto taskDto) {

		TaskEntity taskEntity = new TaskEntity();

		try {

			mapper.map(taskDto, taskEntity);

			System.out.print("Going to add the data --> " + taskEntity);

			int count = todoRepository.insertNewToDoTask(taskDto.getTitle(), taskDto.getTaskDescription(),
					taskDto.getTaskStatus());

			System.out.println("AFTER adding the data is --> " + count);

			return new APIResponse(200, "sucess", "Successfully added new Todo Task!");

		} catch (Exception e) {
			System.out.println("Exception occured while adding new 'To-Do task' due to ## " + e.getMessage());
			return new APIResponse(500, "failed adding the new to-do task" + e.getMessage(), null);
		}

	}

	@Override
	public ResponseEntity<TaskDto> updateTaskDetails(TaskDto taskDetails) {
		try {
			TaskEntity taskEntity = todoRepository.findById(taskDetails.getId()).orElse(null);

			if (taskEntity == null) {
				
				return ResponseEntity.status(500)
	                    .body(null);
			}

			// Update to-do task details
			todoRepository.updateById(taskDetails.getTitle(), taskDetails.getTaskDescription(),
					taskDetails.getTaskStatus(), taskDetails.getId());

			return ResponseEntity.status(200)
                    .body(null);

		} catch (Exception e) {

			System.out.println("Exception occured while updating 'To-Do task' for the id --> " + taskDetails.getId() + "due to ## "
					+ e.getMessage());

			return ResponseEntity.status(500)
                    .body(null);
		}

	}

	@Override
	public APIResponse deleteTaskById(int id) {
		try {
			TaskEntity taskEntity = todoRepository.findById(id).orElse(null);

			if (taskEntity == null) {
				return new APIResponse(500, "Current row is not present in the table, refresh the page", null);
			}

			int deleteById = todoRepository.deleteById(id);

			System.out.println("total number of deleted task items --> " + deleteById);

			return new APIResponse(200, "success", "Deleted Successfully!");

		} catch (Exception e) {

			return new APIResponse(500, "Something went wrong while deleting the task data for the id - " + id
					+ " due to ... " + e.getMessage(), null);
		}
	}

}
