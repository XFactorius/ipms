package lt.tekorius.ipms.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Incident {
    private String name;
    private LocalDate startDate;
}
