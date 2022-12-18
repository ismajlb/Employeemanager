package tech.initilization.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.initilization.employeemanager.exceptions.UserNotFoundException;
import tech.initilization.employeemanager.model.Employee;
import tech.initilization.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;


    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }



    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());

        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){

        return employeeRepo.save(employee);
    }
    public Optional findEmployeeById(Long id) throws Throwable {
        return (Optional) employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }

    public void deleteEmployee(Long id){

        employeeRepo.deleteEmployeeById(id);
    }
}
