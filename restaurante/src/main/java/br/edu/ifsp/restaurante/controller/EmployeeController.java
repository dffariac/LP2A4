package br.edu.ifsp.restaurante.controller;

import br.edu.ifsp.restaurante.dto.employee.EmployeeRequest;
import br.edu.ifsp.restaurante.dto.employee.EmployeeResponse;
import br.edu.ifsp.restaurante.mapper.employee.EmployeeMapper;
import br.edu.ifsp.restaurante.model.Employee;
import br.edu.ifsp.restaurante.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> showAll(){
        List<EmployeeResponse> response = this.employeeService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest request) {
        EmployeeResponse response = this.employeeService.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse> editEmployee(@PathVariable Long employeeId, @RequestBody EmployeeRequest request) {
        Employee employee = EmployeeMapper.responseToEmployee(this.employeeService.findById(employeeId));
        employee.setName(request.name());
        employee.setCpf(request.cpf());
        EmployeeResponse response = this.employeeService.save(employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        this.employeeService.deleteById(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
