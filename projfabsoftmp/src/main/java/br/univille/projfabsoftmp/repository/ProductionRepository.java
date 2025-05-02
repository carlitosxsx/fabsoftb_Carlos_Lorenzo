package br.univille.projfabsoftmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftmp.entity.Production;

@Repository
public interface ProductionRepository
        extends JpaRepository<Production, Long> {

}
