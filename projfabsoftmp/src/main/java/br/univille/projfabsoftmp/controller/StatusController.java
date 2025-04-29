package br.univille.projfabsoftmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoftmp.entity.Status;
import br.univille.projfabsoftmp.service.StatusService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {

    @Autowired
    private StatusService service;

    @GetMapping
    public ResponseEntity<List<Status>> getStatuss() {
        var listaStatuses = service.getAll();

        return new ResponseEntity<List<Status>>(listaStatuses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Status> postStatus(@RequestBody Status status) {
        if (status == null) {
            return ResponseEntity.badRequest().build();
        }
        if (status.getId() == 0) {
            service.save(status);
            return new ResponseEntity<Status>(status, HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();
    }

}
