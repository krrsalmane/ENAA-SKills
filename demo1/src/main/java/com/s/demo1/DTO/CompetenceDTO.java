package com.s.demo1.DTO;
import java.util.List;



public class CompetenceDTO {
    private Long id;
    private String nom;
    private String description;
    private List<SousCompetenceDTO> sousCompetences;
    private boolean acquise;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<SousCompetenceDTO> getSousCompetences() {
        return sousCompetences;
    }

    public void setSousCompetences(List<SousCompetenceDTO> sousCompetences) {
        this.sousCompetences = sousCompetences;
    }

    public boolean isAcquise() {
        return acquise;
    }

    public void setAcquise(boolean acquise) {
        this.acquise = acquise;
    }

    public CompetenceDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CompetenceDTO(Long id, String nom, String description, List<SousCompetenceDTO> sousCompetences, boolean acquise) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.sousCompetences = sousCompetences;
        this.acquise = acquise;
    }

}

