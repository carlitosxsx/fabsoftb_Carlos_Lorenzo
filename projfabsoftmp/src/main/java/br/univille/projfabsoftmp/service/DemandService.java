package br.univille.projfabsoftmp.service;

import java.util.List;
import br.univille.projfabsoftmp.entity.Demand;

public interface DemandService {
    Demand save(Demand demand);

    List<Demand> getAll();

    Demand getById(Long id);

    Demand delete(Long id);
}
