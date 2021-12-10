package harish.csv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class Employee {
    private String name;
    private Integer salary;
    private String city;

    public Employee(String name, Integer salary, String city) {
        this.name = name;
        this.salary = salary;
        this.city = city;
    }
}
