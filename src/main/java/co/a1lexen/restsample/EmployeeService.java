package co.a1lexen.restsample;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EmployeeService {

    // NEED TO ADD GUAVA DEPENDENCY FOR THIS com.google.guava
    static List<EmployeeDto> EMPLOYEES = Lists.newArrayList(
            EmployeeDto.of(1L, "John Wick", "Java Developer"),
            EmployeeDto.of(2L, "Naruto Uzumaki", "QA"),
            EmployeeDto.of(3L, "Sarah Connor", "React Developer")
    );

    public List<EmployeeDto> getEmployees(String search) {
        return EMPLOYEES.stream()
                .filter(song -> song.getName().contains(search) || song.getPosition().contains(search))
                .collect(Collectors.toList());
    }

    public EmployeeDto hireEmployee(CreateEmployeeRequest createEmployeeRequest) {
        EmployeeDto lastEmployee = EMPLOYEES.get(EMPLOYEES.size() - 1);
        EmployeeDto hiredEmployee = EmployeeDto.of(lastEmployee.getId() + 1, createEmployeeRequest.getName(), createEmployeeRequest.getPosition());
        EMPLOYEES.add(hiredEmployee);
        return hiredEmployee;
    }

    public EmployeeDto getEmployee(Long employeeId) {
        return EMPLOYEES.stream()
                .filter(song -> employeeId.equals(song.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Couldn't find an employee by such an id"));
    }


}
