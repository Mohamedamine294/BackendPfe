package com.projectPFE.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConversationRequest {

    @NotBlank
    private String message;

    private Long conversationId;
}