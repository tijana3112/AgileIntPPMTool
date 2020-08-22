package io.agileintelligence.ppmtool.web;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project") // ruta u browser-u
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {
        // Binding result vraca listu errora
        // upitnik je da mozemo bilo sta da vratimo, vracamo response entity bilo kog tipa ili tipa Project ili String...

        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
        // definisemo i status HTTP odgovora koji zelimo da posaljemo
    } // ResponseEntity nam daje vise kontrole nas JSON odgovorima, vezujemo se na API koji
    // ce biti napravljen u React-u
    // @Valid za bolje ispisan error u konzoli
    // BindingResult interfejs koji poziva validator nad objektom, analizira objekat da li ima errora
}
