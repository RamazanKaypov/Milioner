package com.example.milioner.entity;

import com.example.milioner.entity.Answers;
import com.example.milioner.entity.Levels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String questions;

    @ElementCollection
    private List<String> variants;


    @ManyToOne
    private Levels levels;

}
