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

import br.univille.projfabsoftmp.entity.Production;
import br.univille.projfabsoftmp.service.ProductionService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/production")
public class ProductionController {

    @Autowired
    private ProductionService service;

    @GetMapping
    public ResponseEntity<List<Production>> getProductions() {
        var listaProductiones = service.getAll();

        return new ResponseEntity<List<Production>>(listaProductiones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Production> postProduction(@RequestBody Production production) {
        if (production == null) {
            return ResponseEntity.badRequest().build();
        }
        if (production.getId() == 0) {
            service.save(production);
            return new ResponseEntity<Production>(production, HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Production> putProduction(@PathVariable long id, @RequestBody Production production){
        if(id == 0 || production == null){
            return ResponseEntity.badRequest().build();
        }
        var productionExistente = service.getById(id);
        if(productionExistente == null){
            return ResponseEntity.notFound().build();
        }
        productionExistente.setName(production.getName());
        productionExistente.setResponsible(production.getResponsible());
        productionExistente.setClient(production.getClient());
        productionExistente.setStatus(production.getStatus());
        productionExistente.setDeadline(production.getDeadline());
        productionExistente.setTipo(production.getTipo());
        productionExistente.setDataVencimentoGeral(production.getDataVencimentoGeral());
        productionExistente.setDataVencimentoCriacao(production.getDataVencimentoCriacao());
        productionExistente.setPrazo(production.getPrazo());
        service.save(productionExistente);
        return new ResponseEntity<Production>(productionExistente, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Production> deleteProduction(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var productionExistente = service.getById(id);
        if(productionExistente == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Production>(productionExistente, HttpStatus.OK);

    }

}
