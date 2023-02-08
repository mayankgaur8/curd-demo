package com.mayank.curddemo.controller;

import com.mayank.curddemo.exception.ResourceNotFoundException;
import com.mayank.curddemo.model.Employee;
import com.mayank.curddemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//SSSimport javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees(){
         return employeeRepository.findAll();
    }
@GetMapping("allEmployees/{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable(value="id")long id)throws ResourceNotFoundException {
         Employee employee=employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee not found for this id::"+id));
         return ResponseEntity.ok().body(employee);
    }
@PostMapping("/allEmployees")
    public Employee createEmployee( @RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    @PutMapping("/allEmployees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id")long id,@RequestBody Employee employeeDetails)throws ResourceNotFoundException{
    Employee employee=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not found for this id::"+id));
     employee.setEmailId(employeeDetails.getEmailId());
     employee.setLastName(employeeDetails.getLastName());
     employee.setFirstName(employeeDetails.getFirstName());
     final  Employee updatedEmployee=employeeRepository.save(employee);
     return ResponseEntity.ok(updatedEmployee);
    }
    @DeleteMapping("/allEmployees/{id}")

    public Map<String,Boolean> deleteEmployee(@PathVariable(value="id")long id) throws ResourceNotFoundException {
        Employee employee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not found for this id"+id));
        employeeRepository.delete(employee);
        Map<String, Boolean> response=new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return  response;

    }
}
