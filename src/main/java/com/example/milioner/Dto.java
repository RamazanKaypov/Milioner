package com.example.milioner;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dto {

    private String questions;

    private List<String> variants;

    private int answer;

    private int level;
}
