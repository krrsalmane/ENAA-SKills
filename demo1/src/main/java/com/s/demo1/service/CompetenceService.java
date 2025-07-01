package com.s.demo1.service;
import com.s.demo1.DTO.CompetenceDTO;
import com.s.demo1.DTO.SousCompetenceDTO;
import com.s.demo1.model.Competence;
import com.s.demo1.model.SousCompetence;
import com.s.demo1.repository.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CompetenceService {

    private final CompetenceRepository competenceRepository;

    public CompetenceService(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

    public CompetenceDTO createCompetence(CompetenceDTO dto) {
        Competence competence = new Competence();
        competence.setNom(dto.getNom());

        List<SousCompetence> sousCompetences = dto.getSousCompetences().stream()
                .map(scDto -> {
                    SousCompetence sc = new SousCompetence();
                    sc.setDescription(scDto.getDescription());
                    sc.setValidee(false);
                    sc.setCompetence(competence);
                    return sc;
                }).collect(Collectors.toList());

        competence.setSousCompetences(sousCompetences);

        Competence saved = competenceRepository.save(competence);

        // Mapper vers DTO de réponse
        CompetenceDTO response = new CompetenceDTO();
        response.setId(saved.getId());
        response.setNom(saved.getNom());
        response.setAcquise(false);
        response.setSousCompetences(
                saved.getSousCompetences().stream()
                        .map(sc -> new SousCompetenceDTO(sc.getId(), sc.getDescription(), sc.isValidee()))
                        .collect(Collectors.toList())
        );
        return response;
    }
}
