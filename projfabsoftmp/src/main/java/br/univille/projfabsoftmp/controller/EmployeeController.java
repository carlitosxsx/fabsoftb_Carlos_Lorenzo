package br.univille.projfabsoftmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoftmp.entity.Employee;
import br.univille.projfabsoftmp.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        var listaEmployeees = service.getAll();

        return new ResponseEntity<List<Employee>>(listaEmployeees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
        if (employee == null) {
            return ResponseEntity.badRequest().build();
        }
        if (employee.getId() == 0) {
            service.save(employee);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();
    }

}
