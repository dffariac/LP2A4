package br.edu.ifsp.restaurante.service;

import br.edu.ifsp.restaurante.dto.employee.EmployeeRequest;
import br.edu.ifsp.restaurante.dto.employee.EmployeeResponse;
import br.edu.ifsp.restaurante.mapper.employee.EmployeeMapper;
import br.edu.ifsp.restaurante.model.Employee;
import br.edu.ifsp.restaurante.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeResponse> findAll(){
        return this.employeeRepository.findAll().stream().map(EmployeeMapper::employeeToResponse).toList();
    }

    public EmployeeResponse findById(Long id){
        return this.employeeRepository.findById(id).map(EmployeeMapper::employeeToResponse)
                .orElseThrow(() -> new RuntimeException("employee #"+id+" not found"));
    }

    public EmployeeResponse save(EmployeeRequest request){
        Employee employee = this.employeeRepository.save(EmployeeMapper.requestToEmployee(request));
        return EmployeeMapper.employeeToResponse(employee);
    }

    public EmployeeResponse save(Employee employee){
        return EmployeeMapper.employeeToResponse(this.employeeRepository.save(employee));
    }

    public void deleteById(Long id){
        this.employeeRepository.deleteById(id);
    }
}
