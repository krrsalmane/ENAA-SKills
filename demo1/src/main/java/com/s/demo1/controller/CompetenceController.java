package com.s.demo1.controller;

import com.s.demo1.DTO.CompetenceDTO;
import com.s.demo1.service.CompetenceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/competences")

public class CompetenceController {

    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }
    @PostMapping
    public CompetenceDTO create(@RequestBody CompetenceDTO dto) {
        return competenceService.createCompetence(dto);
    }
}
