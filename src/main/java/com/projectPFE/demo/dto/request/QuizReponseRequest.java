package com.projectPFE.demo.dto.request;

import lombok.*;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizReponseRequest {

    private Long quizId;

    private Map<Long, Long> reponses;
}