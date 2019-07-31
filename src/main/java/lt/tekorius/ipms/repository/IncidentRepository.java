package lt.tekorius.ipms.repository;

import lt.tekorius.ipms.model.Incident;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class IncidentRepository {
    private Map<String, Incident> incidents = new HashMap<String, Incident>();

    public void insert(Incident incident) {
        incidents.put(incident.getName(), incident);
    }

    public Incident get(String name) {
        return incidents.get(name);
    }

    public List<Incident> findAll() {
        return new ArrayList<Incident>(incidents.values());
    }
}
