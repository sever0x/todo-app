package com.web.todo.controller;

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
import java.util.Optional;

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

    @PostMapping("/change-state/{id}")
    public String changeTodoState(@PathVariable int id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        Todo todo = todoOptional.orElse(null);

        if (todo != null) {
            todo.setIsComplete(!todo.getIsComplete());
            todoRepository.save(todo);
        }

        return "redirect:/";
    }
}
