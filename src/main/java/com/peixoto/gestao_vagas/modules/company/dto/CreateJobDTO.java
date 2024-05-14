package com.peixoto.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobDTO {
    @Schema(example = "teste vaga", requiredMode = RequiredMode.REQUIRED)
    private String description;
    @Schema(example = "teste beneficio", requiredMode = RequiredMode.REQUIRED)
    private String benefits;
    @Schema(example = "pleno", requiredMode = RequiredMode.REQUIRED)
    private String level;
}
