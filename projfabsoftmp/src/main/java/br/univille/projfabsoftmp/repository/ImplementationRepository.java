package br.univille.projfabsoftmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftmp.entity.Implementation;

@Repository
public interface ImplementationRepository
        extends JpaRepository<Implementation, Long> {

}
