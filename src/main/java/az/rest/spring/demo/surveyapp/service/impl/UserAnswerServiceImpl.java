package az.rest.spring.demo.surveyapp.service.impl;

import az.rest.spring.demo.surveyapp.model.UserAnswer;
import az.rest.spring.demo.surveyapp.repository.UserAnswerRepository;
import az.rest.spring.demo.surveyapp.rest.model.dto.UserAnswerDto;
import az.rest.spring.demo.surveyapp.rest.model.response.UserAnswerResponse;
import az.rest.spring.demo.surveyapp.service.UserAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserAnswerServiceImpl implements UserAnswerService {

    private final UserAnswerRepository userAnswerRepository;

    @Override
    public UserAnswerResponse getAll() {
        List<UserAnswerDto> userAnswerDtos = userAnswerRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return makeResponse(userAnswerDtos);
    }

    @Override
    public UserAnswerDto getUserAnswerById(int id) {
        UserAnswer userAnswer = userAnswerRepository.findById(id).orElseThrow();
        return convertToDto(userAnswer);
    }

    @Override
    public void insert(UserAnswerDto userAnswerDto) {
        UserAnswer userAnswer = new UserAnswer();
        BeanUtils.copyProperties(userAnswerDto, userAnswer);
        userAnswerRepository.save(userAnswer);
    }

    @Override
    public void update(int id, UserAnswerDto userAnswerDto) {
        UserAnswer userAnswer = userAnswerRepository.findById(id).orElseThrow();
        if (userAnswerDto.getOpenQuestionAnswer() != null) {
            userAnswer.setOpenQuestionAnswer(userAnswerDto.getOpenQuestionAnswer());
        }
        userAnswerRepository.save(userAnswer);
    }



    @Override
    public void deleteUserAnswerById(int id) {
        UserAnswer userAnswer = userAnswerRepository.findById(id).orElseThrow();
        userAnswerRepository.delete(userAnswer);
    }

    public UserAnswerDto convertToDto(UserAnswer userAnswer) {
        UserAnswerDto userAnswerDto = new UserAnswerDto();
        BeanUtils.copyProperties(userAnswer, userAnswerDto);
        return userAnswerDto;
    }

    public UserAnswerResponse makeResponse(List<UserAnswerDto> userAnswerDtos) {
        return UserAnswerResponse.builder()
                .answers(userAnswerDtos)
                .build();
    }
}
