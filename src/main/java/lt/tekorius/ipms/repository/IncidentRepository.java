package lt.tekorius.ipms.repository;

import lt.tekorius.ipms.model.Incident;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class IncidentRepository {
    private Map<String, Incident> incidents = new HashMap<String, Incident>();

    public void insert(Incident incident) {
        incidents.put(incident.getName(), incident);
    }

    public void get(String name) {
        incidents.get(name);
    }

    public List<Incident> findAll() {
        return new ArrayList<Incident>(incidents.values());
    }
}
