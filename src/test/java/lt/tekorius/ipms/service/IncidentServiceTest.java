package lt.tekorius.ipms.service;

import com.google.common.collect.Iterables;
import lt.tekorius.ipms.model.Incident;
import lt.tekorius.ipms.repository.IncidentRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;

public class IncidentServiceTest {

    private static final String INCIDENT_NAME = "Some Incident";
    private static final LocalDate INCIDENT_DATE = LocalDate.of(2019, 1, 1);

    private IncidentRepository incidentRepository = Mockito.mock(IncidentRepository.class);
    private IncidentService incidentService;

    @Before
    public void setUp() {
        incidentService = new IncidentService(incidentRepository);
    }

    @Test
    public void findsAll() {
        Mockito.when(incidentRepository.findAll())
                .thenReturn(Collections.singletonList(new Incident(INCIDENT_NAME,
                        INCIDENT_DATE)));
        List<Incident> result = incidentService.findAll();

        assertThat(result.size(), Matchers.is(1));
        assertThat(getIncident(result).getName(), Matchers.is(INCIDENT_NAME));
        assertThat(getIncident(result).getStartDate(), Matchers.is(INCIDENT_DATE));
    }

    private Incident getIncident(List<Incident> result) {
        return Iterables.getOnlyElement(result);
    }

    @Test
    public void add() {
        Incident incident = new Incident(INCIDENT_NAME, INCIDENT_DATE);
        incidentService.add(incident);

        Mockito.verify(incidentRepository).insert(incident);
    }
}