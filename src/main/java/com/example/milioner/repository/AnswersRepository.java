package com.example.milioner.repository;

import com.example.milioner.entity.Answers;
import com.example.milioner.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "answers")
public interface AnswersRepository extends JpaRepository<Answers,Integer> {

    Answers getAnswersByQuestionId(Questions questionId);
}
