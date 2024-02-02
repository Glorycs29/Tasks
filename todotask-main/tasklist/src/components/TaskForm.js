import React, { useState } from "react";
import axios from "axios";

const TaskForm = ({fetchTasks}) => {
  const [taskData, setTaskData] = useState({
    title: "",
    taskDescription: "",
    taskStatus: "", // Add the new taskStatus property
  });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8090/leapfinance/addnewtodotask", taskData);
      setTaskData({
        title: "",
        taskDescription: "",
        taskStatus: "", // Reset taskStatus after submission
      });
      fetchTasks();
    } catch (error) {
      console.error("Error creating task:", error);
    }
  };

  return (
    <div style={{ padding: "20px", border: "1px solid #ccc", borderRadius: "5px", marginBottom: "20px" }}>
      <h2>Create new Todo Task</h2>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: "10px" }}>
          <label style={{ marginRight: "10px" }}>
            Title:
            <input
              type="text"
              placeholder="Title"
              value={taskData.title}
              onChange={(e) => setTaskData({ ...taskData, title: e.target.value })}
              style={{ height: "30px", marginLeft: "5px" }}
              required
            />
          </label>
        </div>
        <div style={{ marginBottom: "10px" }}>
          <label style={{ marginRight: "10px" }}>
            Description:
            <textarea
              placeholder="Description"
              value={taskData.taskDescription}
              onChange={(e) => setTaskData({ ...taskData, taskDescription: e.target.value })}
              style={{ height: "30px", marginLeft: "5px" }}
              required
            ></textarea>
          </label>
        </div>
        <div style={{ marginBottom: "10px" }}>
          <label style={{ marginRight: "10px" }}>
            Status:
            <input
              type="text"
              placeholder="Status"
              value={taskData.taskStatus}
              onChange={(e) => setTaskData({ ...taskData, taskStatus: e.target.value })}
              style={{ height: "30px", marginLeft: "5px" }}
              required
            />
          </label>
        </div>
        <button
          type="submit"
          style={{
            marginTop: "10px",
            padding: "8px 12px",
            cursor: "pointer",
            backgroundColor: "blue",
            color: "white",
            border: "none",
            borderRadius: "5px",
          }}
        >
          Add new todo
        </button>
      </form>
    </div>
  );
};

export default TaskForm;