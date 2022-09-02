package com.web.todo.service;

import com.web.todo.entity.Todo;
import com.web.todo.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository todoRepository;


    @Override
    public List<Todo> getAllTodoSortedByPriority() {
        List<Todo> allTodos = todoRepository.findAll();
        Collections.sort(allTodos);
        Collections.reverse(allTodos);

        return allTodos;
    }
}
