package az.rest.spring.demo.surveyapp.service.impl;

import az.rest.spring.demo.surveyapp.model.Answer;
import az.rest.spring.demo.surveyapp.repository.AnswerRepository;
import az.rest.spring.demo.surveyapp.rest.model.dto.AnswerDto;
import az.rest.spring.demo.surveyapp.rest.model.dto.QuestionDto;
import az.rest.spring.demo.surveyapp.rest.model.response.AnswerResponse;
import az.rest.spring.demo.surveyapp.rest.model.response.QuestionResponse;
import az.rest.spring.demo.surveyapp.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;


    @Override
    public AnswerResponse getAllAnswers() {
        List<AnswerDto> answers = answerRepository.findAll()
                .stream()
                .map(answer -> convertToDto(answer))
                .collect(Collectors.toList());
        return makeResponse(answers);
    }

    @Override
    public AnswerDto getAnswerById(int id) {
        Answer answer = answerRepository.findById(id).orElseThrow();
        return convertToDto(answer);
    }

    @Override
    public void insertAnswer(AnswerDto answerDto) {
        Answer answer = new Answer();
        BeanUtils.copyProperties(answerDto, answer);
        answerRepository.save(answer);
    }

    @Override
    public void updateAnswer(int id, AnswerDto answerDto) {
        Answer answer = answerRepository.findById(id).orElseThrow();
        if (answerDto.getBody() != null) {
            answer.setBody(answerDto.getBody());
        }
        answerRepository.save(answer);
    }



    @Override
    public void deleteAnswerById(int id) {
        Answer answer = answerRepository.findById(id).orElseThrow();
        answerRepository.delete(answer);
    }

    private AnswerDto convertToDto(Answer answer) {
        AnswerDto answerDto = new AnswerDto();
        BeanUtils.copyProperties(answer, answerDto);
        return answerDto;
    }

    public AnswerResponse makeResponse(List<AnswerDto> answerDto){
        return AnswerResponse.builder()
                .answers(answerDto)
                .build();
    }
}
