package br.univille.projfabsoftmp.service;

import java.util.List;
import br.univille.projfabsoftmp.entity.Status;

public interface StatusService {
    Status save(Status status);

    List<Status> getAll();

    Status getById(Long id);

    Status delete(Long id);
}
