package co.a1lexen.restsample;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(staticName = "empty")
@AllArgsConstructor(staticName = "of")
public class EmployeeDto {

    Long id;

    String name;

    String position;

}
