package com.s.demo1.controller;
import com.s.demo1.DTO.SousCompetenceDTO;
import com.s.demo1.service.SousCompetenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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


        @PostMapping
        public SousCompetenceDTO create(@RequestBody SousCompetenceDTO dto) {
            return sousCompetenceService.create(dto);
        }

        @GetMapping
        public List<SousCompetenceDTO> getAll() {
            return sousCompetenceService.getAll();
        }

        @GetMapping("/{id}")
        public SousCompetenceDTO getById(@PathVariable Long id) {
            return sousCompetenceService.getById(id);
        }

        @PutMapping("/{id}")
        public SousCompetenceDTO update(@PathVariable Long id, @RequestBody SousCompetenceDTO dto) {
            return sousCompetenceService.update(id, dto);
        }


    }


