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

import br.univille.projfabsoftmp.entity.Client;
import br.univille.projfabsoftmp.service.ClientService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        var listaClientes = service.getAll();

        return new ResponseEntity<List<Client>>(listaClientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")	
    public ResponseEntity<Client> getClienteId(@PathVariable Long id){
        var client = service.getById(id);

        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> postClient(@RequestBody Client client) {
        if (client == null) {
            return ResponseEntity.badRequest().build();
        }
        if (client.getId() == 0) {
            service.save(client);
            return new ResponseEntity<Client>(client, HttpStatus.OK);

        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> putClient(@PathVariable long id, @RequestBody Client client){
        if(id == 0 || client == null){
            return ResponseEntity.badRequest().build();
        }
        var clientExistente = service.getById(id);
        if(clientExistente == null){
            return ResponseEntity.notFound().build();
        }
        clientExistente.setName(client.getName());
        service.save(clientExistente);
        return new ResponseEntity<Client>(clientExistente, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var clientExistente = service.getById(id);
        if(clientExistente == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Client>(clientExistente, HttpStatus.OK);
    }

}
