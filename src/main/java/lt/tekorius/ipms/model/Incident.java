package lt.tekorius.ipms.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Incident {
    private String name;
    private LocalDate startDate;
}
