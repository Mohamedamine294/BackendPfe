package com.projectPFE.demo.dto.request;

import com.projectPFE.demo.enums.NiveauEtudes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OffreStageRequest {

    @NotBlank
    private String titre;

    private String description;

    private String localisation;

    private String dureeStage;

    @NotNull
    private NiveauEtudes niveauRequis;

    private LocalDate dateExpiration;

    private List<Long> competenceIds;
}