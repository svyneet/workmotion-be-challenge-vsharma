package com.example.workmotion.challenge.employee;

import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {
    StateMachineEmployee stateMachineEmployee = new StateMachineEmployee();
    Map<Integer, Employee> employees = new HashMap<>();
    int id = 1;

    public Employee getEmployee(int id){
        Optional<Employee> emp = Optional.ofNullable(employees.get(id));
        if(emp.isPresent())
            return emp.get();
        throw new NotFoundException("Employee with requested id not found");
    }

    public Employee createEmployee(Employee employee){
        Employee createdEmployee = new Employee(id, employee.name, employee.phoneNumber, employee.email);
        employees.put(id, createdEmployee);
        id += 1;
        return createdEmployee;
    }

    public Employee changeState(int id, String state){
        Employee employee = employees.get(id);
        employee.setState(stateMachineEmployee.changeState(employee.getState(), state));
        return employee;
    }

}