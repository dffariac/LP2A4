package br.edu.ifsp.restaurante.mapper.employee;

import br.edu.ifsp.restaurante.dto.employee.EmployeeRequest;
import br.edu.ifsp.restaurante.dto.employee.EmployeeResponse;
import br.edu.ifsp.restaurante.model.Employee;

public class EmployeeMapper {

    public static EmployeeResponse employeeToResponse(Employee employee) {
        return new EmployeeResponse(employee.getId(), employee.getName(), employee.getCpf());
    }

    public static Employee requestToEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.name());
        employee.setCpf(request.cpf());
        return employee;
    }

    public static Employee responseToEmployee(EmployeeResponse response) {
        Employee employee = new Employee();
        employee.setId(response.id());
        employee.setName(response.name());
        employee.setCpf(response.cpf());
        return employee;
    }
}
