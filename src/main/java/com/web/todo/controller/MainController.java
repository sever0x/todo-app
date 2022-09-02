package com.web.todo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.todo.api.RandomQuote;
import com.web.todo.entity.Todo;
import com.web.todo.repo.TodoRepository;
import com.web.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoService todoService;

    @GetMapping({"", "/"})
    public String index(Model model) {
        List<Todo> todoList = todoService.getAllTodoSortedByPriority();
        Todo todo = new Todo();

        model.addAttribute("todos", todoList);
        model.addAttribute("todo", todo);
        model.addAttribute("quote", new RandomQuote().getRandomQuote());

        return "index";
    }

    @PostMapping({"", "/"})
    public String createNewTodo(Todo todo) {
        todoRepository.save(todo);

        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        todoRepository.deleteById(id);

        return "redirect:/";
    }
}
