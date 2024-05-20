package com.example.milioner;

import com.example.milioner.entity.Questions;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Projection(types = Questions.class)
@RequestMapping("/api/v2")
public interface sendQuestions {
    Integer getId();

    String getQuestions();

    List<String> getVariants();

    int getAnswer();

}
