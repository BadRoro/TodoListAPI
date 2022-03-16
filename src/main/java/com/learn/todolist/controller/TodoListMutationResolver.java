package com.learn.todolist.controller;

import com.learn.todolist.model.TodoList;
import com.learn.todolist.model.TodoListInput;
import com.learn.todolist.service.TodoListService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class TodoListMutationResolver implements GraphQLMutationResolver {

    private TodoListService todoListService;

    public TodoListMutationResolver (TodoListService todoListService){
        this.todoListService = todoListService;
    }

    public TodoList createTodoList(TodoListInput receivedTodoList){
        return todoListService.create(receivedTodoList);
    }

    public TodoList updateTodoList(long id, TodoListInput receivedTodoList){
        return  todoListService.update(id, receivedTodoList);
    }

    public TodoList deleteTodoList(long id){
        TodoList result = todoListService.read(id);
        todoListService.delete(id);
        return result;
    }
}
