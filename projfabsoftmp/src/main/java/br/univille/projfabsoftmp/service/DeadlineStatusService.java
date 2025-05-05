package br.univille.projfabsoftmp.service;

import java.util.List;
import br.univille.projfabsoftmp.entity.DeadlineStatus;

public interface DeadlineStatusService {
    DeadlineStatus save(DeadlineStatus demand);

    List<DeadlineStatus> getAll();

    DeadlineStatus getById(Long id);

    DeadlineStatus delete(Long id);
}
