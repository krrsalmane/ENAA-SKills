package com.EnaaSkills.EnaaSkills.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprenantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private List<CompetenceDTO> competences;
}