//1
package com.example.LibManagement;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id//Primarykey
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
}
