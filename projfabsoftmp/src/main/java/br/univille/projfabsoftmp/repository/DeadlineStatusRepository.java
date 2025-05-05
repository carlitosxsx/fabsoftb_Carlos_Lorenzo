package br.univille.projfabsoftmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftmp.entity.DeadlineStatus;

@Repository
public interface DeadlineStatusRepository
        extends JpaRepository<DeadlineStatus, Long> {

}
