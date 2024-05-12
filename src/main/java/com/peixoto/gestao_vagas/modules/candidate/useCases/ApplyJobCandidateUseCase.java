package com.peixoto.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peixoto.gestao_vagas.exceptions.JobNotFoundException;
import com.peixoto.gestao_vagas.exceptions.UserNotFoundException;
import com.peixoto.gestao_vagas.modules.candidate.CandidateRepository;
import com.peixoto.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;
    
    private void execute(UUID idCandidate, UUID idJob){
        this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
            throw new UserNotFoundException();
        });
        this.jobRepository.findById(idJob).orElseThrow(() -> {
            throw new JobNotFoundException();
        });
    }
}
