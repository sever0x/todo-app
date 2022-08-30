package com.web.todo.controller;

import com.web.todo.entity.Todo;
import com.web.todo.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping({"", "/"})
    public String index(Model model) {
        List<Todo> todoList = todoRepository.findAll();
        Todo todo = new Todo();
        model.addAttribute("todos", todoList);
        model.addAttribute("todo", todo);

        return "index";
    }

    @PostMapping({"", "/"})
    public String createNewTodo(Todo todo) {
        todoRepository.save(todo);

        return "redirect:/";
    }
}
