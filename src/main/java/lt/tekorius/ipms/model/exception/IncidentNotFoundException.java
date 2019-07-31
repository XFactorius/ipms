package lt.tekorius.ipms.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IncidentNotFoundException extends RuntimeException {
    public IncidentNotFoundException(String name) {
        super("Incident not found: " + name);
    }
}
