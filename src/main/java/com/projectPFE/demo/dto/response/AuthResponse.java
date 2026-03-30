package com.projectPFE.demo.dto.response;

import com.projectPFE.demo.enums.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {

    private String token;
    private Long userId;
    private String nom;
    private String prenom;
    private String email;
    private Role role;
}