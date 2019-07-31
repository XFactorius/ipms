package lt.tekorius.ipms.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Incident {
    private String name;
    private LocalDateTime startDate;
}
