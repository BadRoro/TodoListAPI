package com.learn.todolist.service;

import com.learn.todolist.model.TodoList;
import com.learn.todolist.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoListService {

    @Autowired
    TodoListRepository todoListRepository;

    public List<TodoList> readAll(){
        return todoListRepository.findAll();
    }

    public TodoList read(Long id){
        return todoListRepository.findById(id).orElse(null);
    }

    public TodoList create(TodoList receivedTodoList){
        receivedTodoList.setCreationDate(LocalDateTime.now());
        return todoListRepository.save(receivedTodoList);
    }

    public TodoList update(long id, TodoList receivedTodoList){
        TodoList updatedTodoList = todoListRepository.findById(id).get();
        updatedTodoList.setName(receivedTodoList.getName());
        return todoListRepository.save(updatedTodoList);
    }

    public void delete(long id){
        todoListRepository.deleteById(id);
    }
}
