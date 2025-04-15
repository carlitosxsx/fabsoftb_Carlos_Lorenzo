package br.univille.projfabsoftmp.service;

import java.util.List;
import br.univille.projfabsoftmp.entity.Client;

public interface ClientService {
    Client save(Client client);

    List<Client> getAll();

    Client getById(Long id);

    Client delete(Long id);
}
