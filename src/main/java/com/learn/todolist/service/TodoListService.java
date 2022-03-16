package com.learn.todolist.service;

import com.learn.todolist.model.TodoList;
import com.learn.todolist.model.TodoListInput;
import com.learn.todolist.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public TodoList create(TodoListInput receivedTodoList){
        TodoList createdTodoList = new TodoList();
        createdTodoList.setName(receivedTodoList.getName());
        createdTodoList.setCreationDate(LocalDateTime.now());
        return todoListRepository.save(createdTodoList);
    }

    public TodoList update(long id, TodoListInput receivedTodoList){
        TodoList updatedTodoList = todoListRepository.findById(id).get();
        updatedTodoList.setName(receivedTodoList.getName());
        return todoListRepository.save(updatedTodoList);
    }

    public void delete(long id){
        todoListRepository.deleteById(id);
    }
}
