package com.peixoto.gestao_vagas.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peixoto.gestao_vagas.exceptions.CompanyNotFoundException;
import com.peixoto.gestao_vagas.modules.company.entities.JobEntity;
import com.peixoto.gestao_vagas.modules.company.repositories.CompanyRepository;
import com.peixoto.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity){
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return this.jobRepository.save(jobEntity);
    }
}
