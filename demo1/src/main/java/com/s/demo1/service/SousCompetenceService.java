package com.s.demo1.service;
import com.s.demo1.model.SousCompetence;
import com.s.demo1.repository.SousCompetenceRepository;
import org.springframework.stereotype.Service;


@Service
    public class SousCompetenceService {

    private final SousCompetenceRepository sousCompetenceRepository;

    public SousCompetenceService(SousCompetenceRepository sousCompetenceRepository) {
        this.sousCompetenceRepository = sousCompetenceRepository;
    }

    public void updateValidationStatus(Long id, boolean validee) {
        SousCompetence sc = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sub-competence with ID " + id + " not found"));

        sc.setValidee(validee);
        sousCompetenceRepository.save(sc);
    }
}
