package lt.tekorius.ipms.controller;

import lombok.RequiredArgsConstructor;
import lt.tekorius.ipms.model.Incident;
import lt.tekorius.ipms.service.IncidentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/incidents")
@RequiredArgsConstructor
public class IncidentController {

    private final IncidentService incidentService;

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentService.findAll();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addIncident(@RequestBody Incident incident) {
        incidentService.add(incident);
    }

    @GetMapping(value = "/{name}")
    public Incident getIncidentByName(@PathVariable String name) {
        return incidentService.getByName(name);
    }

}
