package com.s.demo1.DTO;




public class SousCompetenceDTO {
    private Long id;
    private String description;
    private boolean validee;
    private Long competenceId;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValidee() {
        return validee;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    public SousCompetenceDTO(Long id, String description, boolean validee) {
        this.id = id;
        this.description = description;
        this.validee = validee;
    }

    public SousCompetenceDTO() {
    }

    public Long getCompetenceId() {
        return competenceId;
    }

    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
    }
}