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

import br.univille.projfabsoftmp.entity.Colect;
import br.univille.projfabsoftmp.service.ColectService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/colect")
public class ColectController {

    @Autowired
    private ColectService service;

    @GetMapping
    public ResponseEntity<List<Colect>> getColects() {
        var listaColectes = service.getAll();

        return new ResponseEntity<List<Colect>>(listaColectes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Colect> postColect(@RequestBody Colect colect) {
        if (colect == null) {
            return ResponseEntity.badRequest().build();
        }
        if (colect.getId() == 0) {
            service.save(colect);
            return new ResponseEntity<Colect>(colect, HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colect> putColect(@PathVariable long id, @RequestBody Colect colect){
        if(id == 0 || colect == null){
            return ResponseEntity.badRequest().build();
        }
        var colectExistente = service.getById(id);
        if(colectExistente == null){
            return ResponseEntity.notFound().build();
        }
        colectExistente.setName(colect.getName());
        colectExistente.setResponsible(colect.getResponsible());
        colectExistente.setClient(colect.getClient());
        colectExistente.setStatus(colect.getStatus());
        colectExistente.setDeadline(colect.getDeadline());
        colectExistente.setDataPagamento(colect.getDataPagamento());
        colectExistente.setDataPrimeiroContato(colect.getDataPrimeiroContato());
        colectExistente.setDataColetaConcluida(colect.getDataColetaConcluida());
        colectExistente.setTmc(colect.getTmc());
        
        service.save(colectExistente);
        return new ResponseEntity<Colect>(colectExistente, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Colect> deleteColect(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var colectExistente = service.getById(id);
        if(colectExistente == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Colect>(colectExistente, HttpStatus.OK);
    }

}
