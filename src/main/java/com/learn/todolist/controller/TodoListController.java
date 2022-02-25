package com.learn.todolist.controller;

import com.learn.todolist.model.TodoList;
import com.learn.todolist.service.TodoListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoListController {

    TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping("/todolists")
    public ResponseEntity<List<TodoList>> getAllTodoLists(){
        List<TodoList> todoLists = todoListService.readAll();
        if (todoLists.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(todoLists, HttpStatus.OK);
    }

    @GetMapping("/todolists/{id}")
    public ResponseEntity<TodoList> getTodoListById(@PathVariable("id") long id){
        TodoList todoList = todoListService.read(id);
        if (todoList == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @PostMapping("/todolists")
    public ResponseEntity<TodoList> createTodoList(@RequestBody TodoList todoList) {
        TodoList createdTodoList = todoListService.create(todoList);
        return new ResponseEntity<>(createdTodoList, HttpStatus.OK);
    }

    @PutMapping("/todolists/{id}")
    public ResponseEntity<TodoList> updateTodoListById(@PathVariable("id") long id, @RequestBody TodoList todoList){
        TodoList updatedTodoList = todoListService.update(id, todoList);
        if (updatedTodoList == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(updatedTodoList, HttpStatus.OK);
    }

    @DeleteMapping("/todolists/{id}")
    public ResponseEntity<TodoList> deleteTodoListById(@PathVariable("id") long id){
        todoListService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
