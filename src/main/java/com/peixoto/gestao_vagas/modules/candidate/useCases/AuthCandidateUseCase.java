package com.peixoto.gestao_vagas.modules.candidate.useCases;

import java.time.Instant;
import java.util.Arrays;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.peixoto.gestao_vagas.modules.candidate.CandidateRepository;
import com.peixoto.gestao_vagas.modules.candidate.dto.AuthCandidateRequestDTO;
import com.peixoto.gestao_vagas.modules.candidate.dto.AuthCandidateResponseDTO;


@Service
public class AuthCandidateUseCase {

    @Value("${security.token.secret.candidate}")
    private String secretKey;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCandidateResponseDTO execute(AuthCandidateRequestDTO authCandidateDTO) throws AuthenticationException{
        var candidate = this.candidateRepository.findByUsername(authCandidateDTO.username())
            .orElseThrow(() -> {
                throw new UsernameNotFoundException("Username/password incorrect!");
            });

        var passewordMatches = this.passwordEncoder
        .matches(authCandidateDTO.password(), candidate.getPassword());

        if(!passewordMatches){
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(java.time.Duration.ofMinutes(10));
        var token = JWT.create()
            .withIssuer("findVagas")
            .withSubject(candidate.getId().toString())
            .withClaim("roles", Arrays.asList("candidate"))
            .withExpiresAt(expiresIn)
            .sign(algorithm);

        var authCandidateResponse = AuthCandidateResponseDTO.builder().access_token(token).expires_in(expiresIn.toEpochMilli()).build();

        return authCandidateResponse;
    }
}
