package com.example.workmotion.challenge.employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Operation(summary = "Get a employee by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the employee",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content) })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee>   getEmployee(@RequestParam int id){
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @Operation(summary = "Add an employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee added",
                    content = @Content)})
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee>  addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @Operation(summary = "Change the state of an employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee state changed",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee state couldn't be changed",
                    content = @Content) })
    @PostMapping("/change-state")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> changeState(@RequestParam int id, String state) {
        return ResponseEntity.ok(employeeService.changeState(id, state));
    }
}