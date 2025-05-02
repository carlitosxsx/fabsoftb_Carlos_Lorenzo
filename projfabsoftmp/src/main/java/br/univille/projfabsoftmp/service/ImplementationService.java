package br.univille.projfabsoftmp.service;

import java.util.List;
import br.univille.projfabsoftmp.entity.Implementation;

public interface ImplementationService {
    Implementation save(Implementation implementation);

    List<Implementation> getAll();

    Implementation getById(Long id);

    Implementation delete(Long id);
}
