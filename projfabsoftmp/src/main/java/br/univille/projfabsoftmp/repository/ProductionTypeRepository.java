package br.univille.projfabsoftmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftmp.entity.ProductionType;

@Repository
public interface ProductionTypeRepository
        extends JpaRepository<ProductionType, Long> {

}
