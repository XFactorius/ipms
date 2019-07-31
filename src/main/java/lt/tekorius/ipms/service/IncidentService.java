package lt.tekorius.ipms.service;

import lombok.RequiredArgsConstructor;
import lt.tekorius.ipms.model.Incident;
import lt.tekorius.ipms.model.exception.IncidentNotFoundException;
import lt.tekorius.ipms.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentService {
    private final IncidentRepository incidentRepository;


    public List<Incident> findAll() {
        return incidentRepository.findAll();
    }

    public void add(Incident incident) {
        incidentRepository.insert(incident);
    }

    public Incident getByName(String name) {
        Incident incident = incidentRepository.get(name);
        if (incident == null) {
            throw new IncidentNotFoundException(name);
        } else {
            return incident;
        }
    }
}
