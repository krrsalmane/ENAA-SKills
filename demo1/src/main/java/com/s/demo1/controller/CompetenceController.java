package com.s.demo1.controller;

import com.s.demo1.DTO.CompetenceDTO;
import com.s.demo1.service.CompetenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<CompetenceDTO> getAll() {
        return competenceService.getAllCompetences();
    }

    @GetMapping("/{id}")
    public CompetenceDTO getOne(@PathVariable Long id) {
        return competenceService.getCompetenceById(id);
    }

    @PutMapping("/{id}")
    public CompetenceDTO update(@PathVariable Long id, @RequestBody CompetenceDTO dto) {
        return competenceService.updateCompetence(id, dto);
    }

}
