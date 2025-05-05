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

import br.univille.projfabsoftmp.entity.DeadlineStatus;
import br.univille.projfabsoftmp.service.DeadlineStatusService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/deadline-status")
public class DeadlineStatusController {

    @Autowired
    private DeadlineStatusService service;

    @GetMapping
    public ResponseEntity<List<DeadlineStatus>> getDeadlineStatuss() {
        var listaDeadlineStatuses = service.getAll();

        return new ResponseEntity<List<DeadlineStatus>>(listaDeadlineStatuses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeadlineStatus> postDeadlineStatus(@RequestBody DeadlineStatus deadlineStatus) {
        if (deadlineStatus == null) {
            return ResponseEntity.badRequest().build();
        }
        if (deadlineStatus.getId() == 0) {
            service.save(deadlineStatus);
            return new ResponseEntity<DeadlineStatus>(deadlineStatus, HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeadlineStatus> putDeadlineStatus(@PathVariable long id, @RequestBody DeadlineStatus deadlineStatus){
        if(id == 0 || deadlineStatus == null){
            return ResponseEntity.badRequest().build();
        }
        var deadlineStatusExistente = service.getById(id);
        if(deadlineStatusExistente == null){
            return ResponseEntity.notFound().build();
        }
        deadlineStatusExistente.setName(deadlineStatus.getName());
        service.save(deadlineStatusExistente);
        return new ResponseEntity<DeadlineStatus>(deadlineStatusExistente, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeadlineStatus> deleteDeadlineStatus(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var deadlineStatusExistente = service.getById(id);
        if(deadlineStatusExistente == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<DeadlineStatus>(deadlineStatusExistente, HttpStatus.OK);
    }

}
