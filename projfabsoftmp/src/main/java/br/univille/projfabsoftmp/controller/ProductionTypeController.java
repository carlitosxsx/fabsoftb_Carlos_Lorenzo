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

import br.univille.projfabsoftmp.entity.ProductionType;
import br.univille.projfabsoftmp.service.ProductionTypeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/production-type")
public class ProductionTypeController {

    @Autowired
    private ProductionTypeService service;

    @GetMapping
    public ResponseEntity<List<ProductionType>> getProductionTypes() {
        var listaProductionTypees = service.getAll();

        return new ResponseEntity<List<ProductionType>>(listaProductionTypees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductionType> postProductionType(@RequestBody ProductionType productionType) {
        if (productionType == null) {
            return ResponseEntity.badRequest().build();
        }
        if (productionType.getId() == 0) {
            service.save(productionType);
            return new ResponseEntity<ProductionType>(productionType, HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductionType> putProductionType(@PathVariable long id, @RequestBody ProductionType productionType){
        if(id == 0 || productionType == null){
            return ResponseEntity.badRequest().build();
        }
        var productionTypeExistente = service.getById(id);
        if(productionTypeExistente == null){
            return ResponseEntity.notFound().build();
        }
        productionTypeExistente.setName(productionType.getName());
        service.save(productionTypeExistente);
        return new ResponseEntity<ProductionType>(productionTypeExistente, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductionType> deleteProductionType(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var productionTypeExistente = service.getById(id);
        if(productionTypeExistente == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<ProductionType>(productionTypeExistente, HttpStatus.OK);

    }

}
