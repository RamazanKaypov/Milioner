package com.example.milioner;

import com.example.milioner.entity.Answers;
import com.example.milioner.repository.AnswersRepository;
import com.example.milioner.repository.LevelRepository;
import com.example.milioner.repository.QuestinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answers")
public class controllerAnswers {

    @Autowired
    QuestinsRepository questinsRepository;

    @Autowired
    LevelRepository levelRepository;

    @Autowired
    AnswersRepository answersRepository;

    @GetMapping
    ResponseEntity<List<Answers>> getAll(){
        List<Answers> all=answersRepository.findAll();
        return ResponseEntity.ok(all);
    }

}
