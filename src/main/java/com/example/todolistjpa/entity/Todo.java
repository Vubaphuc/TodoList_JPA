package com.example.todolistjpa.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title", columnDefinition = "TEXT")
    private String title;
    @Column(nullable = false)
    private boolean status;
}
