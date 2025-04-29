package br.univille.projfabsoftmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoftmp.entity.Employee;
import br.univille.projfabsoftmp.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/{id}")
    public ResponseEntity<Employee> putEmployee(@PathVariable long id, @RequestBody Employee employee){
        if(id == 0 || employee == null){
            return ResponseEntity.badRequest().build();
        }
        var employeeExistente = service.getById(id);
        if(employeeExistente == null){
            return ResponseEntity.notFound().build();
        }
        employeeExistente.setName(employee.getName());
        employeeExistente.setRole(employee.getRole());
        employeeExistente.setLeader(employee.getLeader());
        service.save(employeeExistente);
        return new ResponseEntity<Employee>(employeeExistente, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var employeeExistente = service.getById(id);
        if(employeeExistente == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Employee>(employeeExistente, HttpStatus.OK);

    }

}
