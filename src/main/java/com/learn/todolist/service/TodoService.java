package com.learn.todolist.service;

import com.learn.todolist.model.Todo;
import com.learn.todolist.repository.TodoListRepository;
import com.learn.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoService {

        @Autowired
        TodoRepository todoRepository;
        @Autowired
        TodoListRepository todoListRepository;

        public List<Todo> readAll(){
            return todoRepository.findAll();
        }

        public Todo read(long id){
            return todoRepository.findById(id).orElse(null);
        }

        public Todo create(TodoInput input){
            Todo createdTodo = new Todo();
            createdTodo.setLabel(input.getLabel());
            createdTodo.setCreationDate(LocalDateTime.now());
            createdTodo.setDone(false);
            createdTodo.setTodoList(todoListRepository.findById(input.getIdTodoList()).orElse(null));

            return todoRepository.save(createdTodo);
        }

        public Todo update(long id, TodoInput input){
            Todo returnedTodo = todoRepository.findById(id).orElse(null);
            if (returnedTodo == null)
                return null;
            if (input.getLabel() != null)
                returnedTodo.setLabel(input.getLabel());
            if (input.getDone() != null)
                returnedTodo.setDone(input.getDone());
            if (input.getIdTodoList() != null)
                returnedTodo.setTodoList(todoListRepository.findById(input.getIdTodoList()).orElse(null));

            return todoRepository.save(returnedTodo);
        }

        public void delete(long id){
            todoRepository.deleteById(id);
        }
}
