package com.peixoto.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {
    
    @Schema(example = "Exemplo descrição")
    private String description;
    @Schema(example = "lucas")
    private String username;
    @Schema(example = "lucas@gmail.com")
    private String email;
    private UUID id;
    @Schema(example = "lucas")
    private String name;
}
