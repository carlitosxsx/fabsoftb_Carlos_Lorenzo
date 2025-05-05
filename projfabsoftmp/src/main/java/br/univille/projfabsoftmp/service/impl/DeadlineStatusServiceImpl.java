package br.univille.projfabsoftmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftmp.repository.DeadlineStatusRepository;
import br.univille.projfabsoftmp.service.DeadlineStatusService;
import br.univille.projfabsoftmp.entity.DeadlineStatus;

@Service
public class DeadlineStatusServiceImpl implements DeadlineStatusService {

    @Autowired
    private DeadlineStatusRepository deadlineStatusRepository;

    public DeadlineStatusServiceImpl(DeadlineStatusRepository deadlineStatusRepository) {
        this.deadlineStatusRepository = deadlineStatusRepository;
    }

    @Override
    public DeadlineStatus save(DeadlineStatus deadlineStatus) {
        return deadlineStatusRepository.save(deadlineStatus);
    }

    @Override
    public List<DeadlineStatus> getAll() {
        return deadlineStatusRepository.findAll();
    }

    @Override
    public DeadlineStatus getById(Long id) {
        var retorno = deadlineStatusRepository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;

    }

    @Override
    public DeadlineStatus delete(Long id) {
        DeadlineStatus deadlineStatus = getById(id);
        if (deadlineStatus != null) {
            deadlineStatusRepository.deleteById(id);
        }
        return deadlineStatus;
    }

}