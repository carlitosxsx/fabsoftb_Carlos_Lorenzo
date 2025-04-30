package br.univille.projfabsoftmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftmp.entity.Colect;

@Repository
public interface ColectRepository
        extends JpaRepository<Colect, Long> {

}
