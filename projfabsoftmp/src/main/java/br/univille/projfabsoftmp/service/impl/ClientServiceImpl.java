package br.univille.projfabsoftmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftmp.repository.ClientRepository;
import br.univille.projfabsoftmp.service.ClientService;
import br.univille.projfabsoftmp.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long id) {
        var retorno = clientRepository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;

    }

    @Override
    public Client delete(Long id) {
        Client client = getById(id);
        if (client != null) {
            clientRepository.deleteById(id);
        }
        return client;
    }

}