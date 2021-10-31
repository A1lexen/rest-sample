package co.a1lexen.restsample;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees(@RequestParam String search) {
        return ResponseEntity.ok(employeeService.getEmployees(search));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> hireEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Value");
        return new ResponseEntity<>(
                employeeService.hireEmployee(createEmployeeRequest),
                headers,
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployee(employeeId));
    }

}

