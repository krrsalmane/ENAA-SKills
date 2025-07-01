package com.s.demo1.model;


import jakarta.persistence.*;


import java.util.List;

@Entity

public class Apprenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String prenom;

    @ManyToMany
    @JoinTable(
            name = "apprenant_competence",
            joinColumns = @JoinColumn(name = "apprenant_id"),
            inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    private List<Competence> competences;
}
