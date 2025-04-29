package br.univille.projfabsoftmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoftmp.entity.Demand;
import br.univille.projfabsoftmp.service.DemandService;

import org.springframework.web.bind.annotation.PostMapping;
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

}
