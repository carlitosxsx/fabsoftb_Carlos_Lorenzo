package br.univille.projfabsoftmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftmp.entity.Client;

@Repository
public interface ClientRepository
        extends JpaRepository<Client, Long> {

}
