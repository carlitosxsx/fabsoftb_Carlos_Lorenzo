package br.univille.projfabsoftmp.service;

import java.util.List;
import br.univille.projfabsoftmp.entity.Production;

public interface ProductionService {
    Production save(Production production);

    List<Production> getAll();

    Production getById(Long id);

    Production delete(Long id);
}
