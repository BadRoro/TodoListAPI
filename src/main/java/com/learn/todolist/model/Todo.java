package com.learn.todolist.model;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTodo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTodo;
    private String label;
    private Boolean done;
    private LocalDateTime creationDate;
    @ManyToOne
    //@JsonBackReference
    private TodoList todoList;

    public long getIdTodo() {
        return idTodo;
    }

    public void setIdTodo(long id) {
        this.idTodo = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }
}
