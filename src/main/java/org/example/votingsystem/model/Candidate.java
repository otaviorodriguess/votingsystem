package org.example.votingsystem.model;

import jakarta.persistence.*;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int votes = 0;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getVotes() { return votes; }
    public void setVotes(int votes) { this.votes = votes; }

    public void addVote() { this.votes++; }
}
