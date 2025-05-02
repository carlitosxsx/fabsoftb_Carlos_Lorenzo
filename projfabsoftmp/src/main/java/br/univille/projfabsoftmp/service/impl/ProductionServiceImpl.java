package br.univille.projfabsoftmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftmp.repository.ProductionRepository;
import br.univille.projfabsoftmp.service.ProductionService;
import br.univille.projfabsoftmp.entity.Production;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionRepository productionRepository;

    public ProductionServiceImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    @Override
    public Production save(Production production) {
        return productionRepository.save(production);
    }

    @Override
    public List<Production> getAll() {
        return productionRepository.findAll();
    }

    @Override
    public Production getById(Long id) {
        var retorno = productionRepository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;

    }

    @Override
    public Production delete(Long id) {
        Production production = getById(id);
        if (production != null) {
            productionRepository.deleteById(id);
        }
        return production;
    }

}