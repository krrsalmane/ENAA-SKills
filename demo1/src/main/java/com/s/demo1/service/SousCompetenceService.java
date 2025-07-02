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

        // Update the sub-competence status
        sc.setValidee(validee);
        sousCompetenceRepository.save(sc);

        // Get the parent competence
        Competence competence = sc.getCompetence();

        // Count total and validated sub-competences
        int total = competence.getSousCompetences().size();
        long validated = competence.getSousCompetences().stream()
                .filter(SousCompetence::isValidee)
                .count();

        // If more than half are validated, mark as acquired
        boolean isAcquired = validated > (total / 2);

        competence.setAcquise(isAcquired);
        competenceRepository.save(competence);
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

    public SousCompetenceDTO getById(Long id) {
        SousCompetence sc = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sub-competence not found"));
        return new SousCompetenceDTO(sc.getId(), sc.getDescription(), sc.isValidee());
    }

    public SousCompetenceDTO update(Long id, SousCompetenceDTO dto) {
        SousCompetence sc = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sub-competence not found"));

        sc.setDescription(dto.getDescription());
        sc.setValidee(dto.isValidee());

        SousCompetence updated = sousCompetenceRepository.save(sc);
        return new SousCompetenceDTO(updated.getId(), updated.getDescription(), updated.isValidee());
    }

    public void delete(Long id) {
        sousCompetenceRepository.deleteById(id);
    }
}



