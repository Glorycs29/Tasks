package com.leap.finance.dto;

public class TaskDto {

	private String position;
	int id;
	private String title;
	private String taskDescription;
	private String taskStatus;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		return "TaskDto [position=" + position + ", id=" + id + ", title=" + title + ", taskDescription="
				+ taskDescription + ", taskStatus=" + taskStatus + "]";
	}

}
