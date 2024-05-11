package com.peixoto.gestao_vagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peixoto.gestao_vagas.modules.company.dto.CreateJobDTO;
import com.peixoto.gestao_vagas.modules.company.entities.JobEntity;
import com.peixoto.gestao_vagas.modules.company.services.CreateJobUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company/job")
public class JobController {

  @Autowired
  private CreateJobUseCase createJobUseCase;

  @PostMapping("/")
  @PreAuthorize("hasRole('COMPANY')")
  public JobEntity create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
    var companyId = request.getAttribute("company_id");

    var jobEntity = JobEntity.builder()
    .benefits(createJobDTO.getBenefits())
    .companyId(UUID.fromString(companyId.toString()))
    .description(createJobDTO.getDescription())
    .level(createJobDTO.getLevel())
    .build();
    return this.createJobUseCase.execute(jobEntity);
  }
}