package br.univille.projfabsoftmp.service;

import java.util.List;
import br.univille.projfabsoftmp.entity.Colect;

public interface ColectService {
    Colect save(Colect demand);

    List<Colect> getAll();

    Colect getById(Long id);

    Colect delete(Long id);
}
