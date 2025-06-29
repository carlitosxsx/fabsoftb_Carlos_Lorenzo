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

import br.univille.projfabsoftmp.entity.Demand;
import br.univille.projfabsoftmp.service.DemandService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/demand")
public class DemandController {

    @Autowired
    private DemandService service;

    @GetMapping
    public ResponseEntity<List<Demand>> getDemands() {
        var listaDemandes = service.getAll();

        return new ResponseEntity<List<Demand>>(listaDemandes, HttpStatus.OK);
    }
    @GetMapping("/{id}")	
    public ResponseEntity<Demand> getDemandId(@PathVariable Long id){
        var demand = service.getById(id);

        return new ResponseEntity<Demand>(demand, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Demand> postDemand(@RequestBody Demand demand) {
        if (demand == null) {
            return ResponseEntity.badRequest().build();
        }
        if (demand.getId() == 0) {
            service.save(demand);
            return new ResponseEntity<Demand>(demand, HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Demand> putDemand(@PathVariable long id, @RequestBody Demand demand){
        if(id == 0 || demand == null){
            return ResponseEntity.badRequest().build();
        }
        var demandExistente = service.getById(id);
        if(demandExistente == null){
            return ResponseEntity.notFound().build();
        }
        demandExistente.setName(demand.getName());
        demandExistente.setResponsible(demand.getResponsible());
        demandExistente.setClient(demand.getClient());
        demandExistente.setStatus(demand.getStatus());
        demandExistente.setDeadline(demand.getDeadline());
        service.save(demandExistente);
        return new ResponseEntity<Demand>(demandExistente, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Demand> deleteDemand(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var demandExistente = service.getById(id);
        if(demandExistente == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Demand>(demandExistente, HttpStatus.OK);
    }

}
