package com.s.demo1.DTO;
import java.util.List;



public class ApprenantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private List<CompetenceDTO> competences;


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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<CompetenceDTO> getCompetences() {
        return competences;
    }

    public void setCompetences(List<CompetenceDTO> competences) {
        this.competences = competences;
    }

    public ApprenantDTO(Long id, String nom, String prenom, List<CompetenceDTO> competences) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.competences = competences;
    }
}