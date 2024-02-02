package com.leap.finance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leap.finance.entity.TaskEntity;

import jakarta.transaction.Transactional;

@Repository
public interface TodoRepository extends JpaRepository<TaskEntity, Integer>{
	
	@Query(value= "SELECT * FROM todo_task_details", nativeQuery=true)
	List<TaskEntity> findAllTaskListData();

	
	@Transactional
	@Modifying
	@Query(value ="INSERT INTO todo_task_details (task_title, task_description, task_status) VALUES (?1, ?2, ?3)", nativeQuery = true)
	int insertNewToDoTask(String title, String taskDescription, String taskStatus);
	
	
	@Transactional
	@Modifying
	@Query(value ="delete from todo_task_details WHERE id = ?1", nativeQuery = true)
	int deleteById(int id);
	
	
	 @Transactional
	 @Modifying
	 @Query(value= "update todo_task_details SET task_title = ?1 , task_description = ?2, task_status=?3 WHERE id = ?4", nativeQuery=true)
	 int updateById(String taskTitle, String taskDescription, String taskStatus, int id);


}
