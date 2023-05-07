package com.example.Ticketing.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Workflow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "workflow")
    private List<WorkflowStep> steps;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WorkflowStep> getSteps() {
        return steps;
    }

    public void setSteps(List<WorkflowStep> steps) {
        this.steps = steps;
    }


}
