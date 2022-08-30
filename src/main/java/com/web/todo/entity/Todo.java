package com.web.todo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    private int id;
    private String content;
}
