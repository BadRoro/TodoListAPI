package com.learn.todolist.controller;

import com.learn.todolist.model.Todo;
import com.learn.todolist.service.TodoInput;
import com.learn.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

/*    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> todoLists = todoService.readAll();
        if (todoLists.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(todoLists, HttpStatus.OK);
    }*/

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") long id){
        Todo foundTodo = todoService.read(id);
        return new ResponseEntity<>(foundTodo, HttpStatus.OK);
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody TodoInput input) {
        Todo createdTodo = todoService.create(input);
        return new ResponseEntity<>(createdTodo, HttpStatus.OK);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodoById(@PathVariable("id") long id, @RequestBody TodoInput input){
        Todo updatedTodo = todoService.update(id, input);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Todo> deleteTodoById(@PathVariable("id") long id){
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
