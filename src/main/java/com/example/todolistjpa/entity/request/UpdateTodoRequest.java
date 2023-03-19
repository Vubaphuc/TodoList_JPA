package com.example.todolistjpa.entity.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTodoRequest {
    private String title;
//    private String level;
    private boolean status;
}
