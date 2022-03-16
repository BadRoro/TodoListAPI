package com.learn.todolist.controller;

import com.learn.todolist.model.Todo;
import com.learn.todolist.service.TodoService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoQueryResolver implements GraphQLQueryResolver {

    private TodoService todoService;

    public TodoQueryResolver (TodoService todoService){
        this.todoService = todoService;
    }

    public Todo todo(long id){
        return todoService.read(id);
    }

    public List<Todo> todos(){
        return todoService.readAll();
    }
}
