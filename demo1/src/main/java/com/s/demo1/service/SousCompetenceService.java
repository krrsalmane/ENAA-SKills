package com.s.demo1.service;
import com.s.demo1.DTO.SousCompetenceDTO;
import com.s.demo1.model.Competence;
import com.s.demo1.model.SousCompetence;
import com.s.demo1.repository.CompetenceRepository;
import com.s.demo1.repository.SousCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SousCompetenceService {

    private final SousCompetenceRepository sousCompetenceRepository;
    private final CompetenceRepository competenceRepository;

    @Autowired
    public SousCompetenceService(SousCompetenceRepository sousCompetenceRepository,
                                 CompetenceRepository competenceRepository) {
        this.sousCompetenceRepository = sousCompetenceRepository;
        this.competenceRepository = competenceRepository;
    }

    public void updateValidationStatus(Long id, boolean validee) {
        SousCompetence sc = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sub-competence with ID " + id + " not found"));

        sc.setValidee(validee);
        sousCompetenceRepository.save(sc);
    }

    public SousCompetenceDTO create(SousCompetenceDTO dto) {
        Competence competence = competenceRepository.findById(dto.getCompetenceId())
                .orElseThrow(() -> new RuntimeException("Competence not found"));

        SousCompetence sc = new SousCompetence();
        sc.setDescription(dto.getDescription());
        sc.setValidee(dto.isValidee());
        sc.setCompetence(competence);

        SousCompetence saved = sousCompetenceRepository.save(sc);
        return new SousCompetenceDTO(saved.getId(), saved.getDescription(), saved.isValidee());
    }

    public List<SousCompetenceDTO> getAll() {
        return sousCompetenceRepository.findAll().stream()
                .map(sc -> new SousCompetenceDTO(sc.getId(), sc.getDescription(), sc.isValidee()))
                .collect(Collectors.toList());
    }


}



