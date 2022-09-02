package com.web.todo.service;

import com.web.todo.entity.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAllTodoSortedByPriority();
}
