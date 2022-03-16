package com.learn.todolist.controller;

import com.learn.todolist.model.TodoList;
import com.learn.todolist.service.TodoListService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoListQueryResolver implements GraphQLQueryResolver{

    private TodoListService todoListService;

    public TodoListQueryResolver(TodoListService todoListService){
        this.todoListService = todoListService;
    }

    public TodoList todoList(Long id){
        return todoListService.read(id);
    }

    public List<TodoList> todoLists(){
        return todoListService.readAll();
    }

}
