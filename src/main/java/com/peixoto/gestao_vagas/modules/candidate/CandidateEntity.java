package com.peixoto.gestao_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "lucas")
    private String name;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "O username não deve conter espaços")
    @Schema(example = "lucas")
    private String username;

    @Email(message = "O campo deve conter um e-mail válido!")
    @Schema(example = "lucas@gmail.com")
    private String email;

    @Length(min = 8, max = 200, message = "A senha deve conter no mínimo 8 caracteres")
    @Schema(example = "admin@1234", minLength = 8, maxLength = 200, requiredMode = RequiredMode.REQUIRED, description = "Senha candidato")
    private String password;
    @Schema(example = "Exemplo de descrição")
    private String description;
    private String cv;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
