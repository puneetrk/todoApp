import React, { Component } from 'react';
import TodoApp from './component/todo/TodoApp'
import './App.css';
import './bootstrap.min.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <TodoApp></TodoApp>
      </div>
    );
  }
}
export default App;
