package com.learn.todolist.controller;

import com.learn.todolist.model.Todo;
import com.learn.todolist.model.TodoInput;
import com.learn.todolist.service.TodoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class TodoMutationResolver implements GraphQLMutationResolver {

    private TodoService todoService;

    public TodoMutationResolver(TodoService todoService){
        this.todoService = todoService;
    }

    public Todo createTodo(TodoInput receivedTodo){
        return todoService.create(receivedTodo);
    }

    public Todo updateTodo(long id, TodoInput receivedTodo){
        return todoService.update(id, receivedTodo);
    }

    public Todo deleteTodo(long id){
        Todo result = todoService.read(id);
        todoService.delete(id);
        return result;
    }
}
