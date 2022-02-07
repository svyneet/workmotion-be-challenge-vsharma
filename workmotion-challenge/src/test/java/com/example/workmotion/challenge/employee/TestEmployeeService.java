package com.example.workmotion.challenge.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEmployeeService {

    private EmployeeService employeeService = new EmployeeService();
    Employee employee;

    @BeforeEach
    public void before() {
        employee = new Employee();
        employee.setName("Vineet");
        employee.setPhoneNumber("17671898760");
        employee.setEmail("s.vyneet@gmail.com");
        employee = employeeService.createEmployee(employee);
    }

    @Test
    public void createEmployee(){
        Employee employee = new Employee();
        employee.setName("Vineet");
        employee.setPhoneNumber("17671898760");
        employee.setEmail("s.vyneet@gmail.com");
        employee = employeeService.createEmployee(employee);
        Assertions.assertEquals(employee.getId(), 2);
        Assertions.assertEquals(employee.getName(), "Vineet");
        Assertions.assertEquals(employee.getPhoneNumber(), "17671898760");
        Assertions.assertEquals(employee.getEmail(), "s.vyneet@gmail.com");
    }

    @Test
    public void changeState() {
        employeeService.changeState(1, "IN_CHECK");
        Assertions.assertEquals(employee.getState(), State.IN_CHECK);
        employeeService.changeState(1, "APPROVED");
        Assertions.assertEquals(employee.getState(), State.APPROVED);
        employeeService.changeState(1, "ACTIVE");
        Assertions.assertEquals(employee.getState(), State.ACTIVE);
    }

    @Test
    public void changeStateInvalid() {
        try {
            employeeService.changeState(1, "IN_CHECK");
            Assertions.assertEquals(employee.getState(), State.IN_CHECK);
            employeeService.changeState(1, "ACTIVE");
            Assertions.fail("The expected exception wasn't thrown.");
        }
        catch(IllegalStateException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals("No valid leaving transitions are permitted from state 'IN_CHECK' for trigger 'ACTIVE'. Consider ignoring the trigger.",e.getMessage());
        }
    }

    @Test
    public void getEmployee() {
        Employee employee = employeeService.getEmployee(1);
        Assertions.assertEquals(employee.getId(), 1);
        Assertions.assertEquals(employee.getName(), "Vineet");
        Assertions.assertEquals(employee.getPhoneNumber(), "17671898760");
        Assertions.assertEquals(employee.getEmail(), "s.vyneet@gmail.com");

    }

    @Test
    public void getEmployeeInvalid() {
        try {
             employeeService.getEmployee(100);
             Assertions.fail("The expected exception wasn't thrown.");
        }
        catch(Exception e){
        Assertions.assertEquals("Employee with requested id not found", e.getMessage());
        }
    }
}
