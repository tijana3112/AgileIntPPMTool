package io.agileintelligence.ppmtool.services;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    // Kontroler da bude samo za povezivanje a da postoju service sloj gde ce biti napisana logika

    // metoda za cuvanje projekta
    public Project saveOrUpdateProject(Project project) {
        // Logic

        return projectRepository.save(project);
    }
}
