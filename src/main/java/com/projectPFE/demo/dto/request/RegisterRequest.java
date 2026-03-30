package com.projectPFE.demo.dto.request;

import com.projectPFE.demo.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String motDePasse;

    @NotNull
    private Role role;
}