package br.univille.projfabsoftmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftmp.entity.Demand;

@Repository
public interface DemandRepository
        extends JpaRepository<Demand, Long> {

}
