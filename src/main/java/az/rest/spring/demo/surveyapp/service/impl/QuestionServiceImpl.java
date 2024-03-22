package az.rest.spring.demo.surveyapp.service.impl;

import az.rest.spring.demo.surveyapp.model.Question;
import az.rest.spring.demo.surveyapp.repository.QuestionRepository;
import az.rest.spring.demo.surveyapp.rest.model.dto.QuestionDto;
import az.rest.spring.demo.surveyapp.rest.model.response.QuestionResponse;
import az.rest.spring.demo.surveyapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    @Override
    public QuestionResponse getAll() {
        List<QuestionDto> questions = questionRepository.findAll()
                .stream().map(question -> convertToDto(question))
                .collect(Collectors.toList());
        return MakeResponse(questions);
    }

    @Override
    public QuestionDto getQuestionById(int id) {
        Question question = questionRepository.findById(id).orElseThrow();
        return convertToDto(question);
    }

    @Override
    public void insert(QuestionDto questionDto) {
        Question question = new Question();
        BeanUtils.copyProperties(questionDto,question);
        questionRepository.save(question);
    }

    @Override
    public void updateSome(int id, QuestionDto questionDto) {
        Question question = questionRepository.findById(id).orElseThrow();
        if(questionDto.getBody()!=null){
            question.setBody(questionDto.getBody());
        }
        if(questionDto.getType()!=null){
            question.setType(questionDto.getType());
        }
        questionRepository.save(question);
    }

    @Override
    public void updateAll(int id, QuestionDto questionDto) {
        Question question = questionRepository.findById(id).orElseThrow();
        question.setBody(questionDto.getBody());
        question.setBody(questionDto.getBody());
        questionRepository.save(question);
    }

    @Override
    public void deleteById(int id) {
        Question question = questionRepository.findById(id).orElseThrow();
        questionRepository.delete(question);
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
