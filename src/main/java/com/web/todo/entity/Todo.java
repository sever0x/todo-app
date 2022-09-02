package com.web.todo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "todo")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Todo implements Comparable<Todo> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private Boolean priority;


    @Override
    public int compareTo(Todo o) {
        return Boolean.compare(getPriority(), o.getPriority());
    }
}
