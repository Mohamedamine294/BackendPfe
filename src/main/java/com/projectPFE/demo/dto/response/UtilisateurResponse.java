package com.projectPFE.demo.dto.response;

import com.projectPFE.demo.enums.Role;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UtilisateurResponse {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private Role role;
    private LocalDate dateInscription;
    private Boolean estActif;
}