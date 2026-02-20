package org.example.votingsystem.controller;

import org.example.votingsystem.model.Candidate;
import org.example.votingsystem.service.VoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {
    private final VoteService service;

    public VoteController(VoteService service) {
        this.service = service;
    }

    @PostMapping("/candidate")
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        return service.addCandidate(candidate);
    }

    @GetMapping("/candidates")
    public List<Candidate> getCandidates() {
        return service.getAllCandidates();
    }

    @PostMapping("/{candidateId}")
    public String vote(@PathVariable Long candidateId) {
        service.vote(candidateId);
        return "Vote registered for candidate " + candidateId;
    }

    @GetMapping("/results")
    public List<Candidate> getResults() {
        return service.getAllCandidates();
    }
}
