package com.EnaaSkills.EnaaSkills.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgressReportDTO {
    private String nomApprenant;
    private Map<String, Boolean> etatCompetences; // ex: "C1": true
}