package com.example.demo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private String lastName;
    private String mobile;

}
