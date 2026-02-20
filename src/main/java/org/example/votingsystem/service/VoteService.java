package org.example.votingsystem.service;

import org.example.votingsystem.model.Candidate;
import org.example.votingsystem.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    private final CandidateRepository candidateRepository;

    public VoteService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate addCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public void vote(Long candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        candidate.addVote();
        candidateRepository.save(candidate);
    }
}
