package com.s.demo1.controller;
import com.s.demo1.service.SousCompetenceService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/competence-service/sous-competences")
public class SousCompetenceController {

        private final SousCompetenceService sousCompetenceService;

        public SousCompetenceController(SousCompetenceService sousCompetenceService) {
            this.sousCompetenceService = sousCompetenceService;
        }

        @PutMapping("/{id}/validation")
        public void updateValidation(@PathVariable Long id, @RequestParam boolean validee) {
            sousCompetenceService.updateValidationStatus(id, validee);
        }
}
