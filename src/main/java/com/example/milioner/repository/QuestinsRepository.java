package com.example.milioner.repository;

import com.example.milioner.entity.Questions;
import com.example.milioner.sendQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "questions",excerptProjection = sendQuestions.class)
public interface QuestinsRepository extends JpaRepository<Questions,Integer> {

    Questions getQuestionsByLevels_Id(Integer levels_id);

    List<Questions> getAllByLevelsId(Integer levels_id);

    Questions getQuestionsById(Integer id);
}
