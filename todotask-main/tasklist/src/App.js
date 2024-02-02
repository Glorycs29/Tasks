import React from "react";
import TaskList from "./components/TaskList";
import TaskForm from "./components/TaskForm";
import "./App.css";

function App() {
  return (
    <div className="App">
      <h1>To-Do List</h1>
     
      <TaskList />
    </div>
  );
}

export default App;
