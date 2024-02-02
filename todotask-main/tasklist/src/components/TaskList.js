// TaskList.js

import React, { useState, useEffect } from "react";
import axios from "axios";
import TaskForm from "./TaskForm";

const TaskList = () => {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    fetchTasks();
  }, []);




  

  const fetchTasks = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8090/leapfinance/gettodolistdata"
      );
      console.log('data are ', response.data);
      setTasks(response.data);
    } catch (error) {
      console.error("Error fetching tasks:", error);
    }
  };

  const deleteTask = async (taskId) => {
    try {
      await axios.delete(
        `http://localhost:8090/leapfinance/deletetask/${taskId}`
      );
      fetchTasks();
    } catch (error) {
      console.error("Error deleting task:", error);
    }
  };

  const editTask = async (taskId) => {
    try {
      await axios.put(`http://localhost:8090/leapfinance/edittodotask`, taskId);
      // Additional logic after successful update, e.g., closing the modal
      
      fetchTasks(); // Refresh the task list
  
      // Show a success alert and close it after 3 seconds (adjust duration as needed)
      showAlert('Update successful');
    } catch (error) {
      console.error("Error updating task:", error);
      showAlert('Update failed', 'error');
    }
  };

  const showAlert = (message, type = 'success') => {
    alert(message);
    setTimeout(() => {
    }, 3000);
  };


  return (
    <div>
       <TaskForm fetchTasks={fetchTasks}/>
      <h2 style={{ fontSize: '24px', fontWeight: 500 , color:'red'}}
> Task List</h2>
<ul>
        {tasks.map((task) => (
          <li key={task.id}>
            {task.title} - {task.taskDescription} - {task.taskStatus}
            <button onClick={() => deleteTask(task.id)}>Delete</button>
            
            {/* <button onClick={() => editTask(task)}>Edit</button> */}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TaskList;
