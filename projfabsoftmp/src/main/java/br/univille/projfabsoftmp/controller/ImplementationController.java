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

import br.univille.projfabsoftmp.entity.Implementation;
import br.univille.projfabsoftmp.service.ImplementationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/implementation")
public class ImplementationController {

    @Autowired
    private ImplementationService service;

    @GetMapping
    public ResponseEntity<List<Implementation>> getImplementations() {
        var listaImplementationes = service.getAll();

        return new ResponseEntity<List<Implementation>>(listaImplementationes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Implementation> postImplementation(@RequestBody Implementation implementation) {
        if (implementation == null) {
            return ResponseEntity.badRequest().build();
        }
        if (implementation.getId() == 0) {
            service.save(implementation);
            return new ResponseEntity<Implementation>(implementation, HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Implementation> putImplementation(@PathVariable long id, @RequestBody Implementation implementation){
        if(id == 0 || implementation == null){
            return ResponseEntity.badRequest().build();
        }
        var implementationExistente = service.getById(id);
        if(implementationExistente == null){
            return ResponseEntity.notFound().build();
        }
        implementationExistente.setName(implementation.getName());
        implementationExistente.setResponsible(implementation.getResponsible());
        implementationExistente.setClient(implementation.getClient());
        implementationExistente.setStatus(implementation.getStatus());
        implementationExistente.setDeadline(implementation.getDeadline());
        implementationExistente.setDataVencimento(implementation.getDataVencimento());
        implementationExistente.setDataInicioImplantacao(implementation.getDataInicioImplantacao());
        implementationExistente.setDataConclusao(implementation.getDataConclusao());
        service.save(implementationExistente);
        return new ResponseEntity<Implementation>(implementationExistente, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Implementation> deleteImplementation(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var implementationExistente = service.getById(id);
        if(implementationExistente == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Implementation>(implementationExistente, HttpStatus.OK);

    }

}
