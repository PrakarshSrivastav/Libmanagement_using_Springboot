//2
package com.example.LibManagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String Title;
    private String author;
    private boolean borrowed;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User borrowedBy;
}
