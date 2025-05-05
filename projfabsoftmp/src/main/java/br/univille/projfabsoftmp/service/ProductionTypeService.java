package br.univille.projfabsoftmp.service;

import java.util.List;
import br.univille.projfabsoftmp.entity.ProductionType;

public interface ProductionTypeService {
    ProductionType save(ProductionType production);

    List<ProductionType> getAll();

    ProductionType getById(Long id);

    ProductionType delete(Long id);
}
