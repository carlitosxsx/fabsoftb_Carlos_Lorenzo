package br.univille.projfabsoftmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftmp.repository.DemandRepository;
import br.univille.projfabsoftmp.service.DemandService;
import br.univille.projfabsoftmp.entity.Demand;

@Service
public class DemandServiceImpl implements DemandService {

    @Autowired
    private DemandRepository demandRepository;

    public DemandServiceImpl(DemandRepository demandRepository) {
        this.demandRepository = demandRepository;
    }

    @Override
    public Demand save(Demand demand) {
        return demandRepository.save(demand);
    }

    @Override
    public List<Demand> getAll() {
        return demandRepository.findAll();
    }

    @Override
    public Demand getById(Long id) {
        var retorno = demandRepository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;

    }

    @Override
    public Demand delete(Long id) {
        Demand demand = getById(id);
        if (demand != null) {
            demandRepository.deleteById(id);
        }
        return demand;
    }

}