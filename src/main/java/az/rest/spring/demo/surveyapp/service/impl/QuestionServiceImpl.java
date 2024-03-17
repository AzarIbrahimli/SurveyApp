package az.rest.spring.demo.surveyapp.service.impl;

import az.rest.spring.demo.surveyapp.model.Question;
import az.rest.spring.demo.surveyapp.repository.QuestionRepository;
import az.rest.spring.demo.surveyapp.rest.model.dto.QuestionDto;
import az.rest.spring.demo.surveyapp.rest.model.response.QuestionResponse;
import az.rest.spring.demo.surveyapp.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    QuestionRepository questionRepository;
    @Override
    public QuestionResponse getAll() {
        List<QuestionDto> questions = questionRepository.findAll()
                .stream().map(question -> convertToDto(question))
                .collect(Collectors.toList());
        return MakeResponse(questions);
    }

    public QuestionDto convertToDto(Question question){
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question, questionDto);
        return questionDto;
    }

    public QuestionResponse MakeResponse(List<QuestionDto> questionDto){
        return QuestionResponse.builder()
                .questions(questionDto)
                .build();
    }

}
