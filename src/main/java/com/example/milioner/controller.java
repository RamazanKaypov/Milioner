package com.example.milioner;

import com.example.milioner.entity.Answers;
import com.example.milioner.entity.Levels;
import com.example.milioner.entity.Questions;
import com.example.milioner.repository.AnswersRepository;
import com.example.milioner.repository.LevelRepository;
import com.example.milioner.repository.QuestinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/questions")
public class controller {

    @Autowired
    QuestinsRepository questinsRepository;

    @Autowired
    LevelRepository levelRepository;

    @Autowired
    AnswersRepository answersRepository;


    @PostMapping
    public ResponseEntity<String> addQuestions(@RequestBody Dto dto){
        Levels levels=levelRepository.getLevelsByLevel(dto.getLevel());
        Questions questions=new Questions(null,dto.getQuestions(),dto.getVariants(),levels);
        questinsRepository.save(questions);
        Answers answers=new Answers(null,dto.getAnswer(),questions);
        answersRepository.save(answers);

        return ResponseEntity.ok(questions.toString());
    }

    @GetMapping()
    public ResponseEntity<List<Questions>> getQuestions(){
        List<Questions> all = questinsRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{levelId}")
    public Questions getByLevel(@PathVariable int levelId){
        List<Questions> allByLevelsId = questinsRepository.getAllByLevelsId(levelId);
        int a=(int)(Math.random()*allByLevelsId.size());
        Questions questions=allByLevelsId.get(a);
        return questions;
    }

    @PostMapping("/answer/{answer}&{questionsId}")
    public boolean getAnswer(@PathVariable Integer questionsId, @PathVariable String answer ){
        Questions questionsById = questinsRepository.getQuestionsById(questionsId);
        Answers answers=answersRepository.getAnswersByQuestionId(questionsById);
        List<String> variants = questionsById.getVariants();
        return (variants.get(answers.getAnswer()).equals(answer));
    }

}
