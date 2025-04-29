package br.univille.projfabsoftmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftmp.entity.Status;

@Repository
public interface StatusRepository
        extends JpaRepository<Status, Long> {

}
