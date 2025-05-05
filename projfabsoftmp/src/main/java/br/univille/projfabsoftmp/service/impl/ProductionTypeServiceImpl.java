package br.univille.projfabsoftmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftmp.repository.ProductionTypeRepository;
import br.univille.projfabsoftmp.service.ProductionTypeService;
import br.univille.projfabsoftmp.entity.ProductionType;

@Service
public class ProductionTypeServiceImpl implements ProductionTypeService {

    @Autowired
    private ProductionTypeRepository productionTypeRepository;

    public ProductionTypeServiceImpl(ProductionTypeRepository productionTypeRepository) {
        this.productionTypeRepository = productionTypeRepository;
    }

    @Override
    public ProductionType save(ProductionType productionType) {
        return productionTypeRepository.save(productionType);
    }

    @Override
    public List<ProductionType> getAll() {
        return productionTypeRepository.findAll();
    }

    @Override
    public ProductionType getById(Long id) {
        var retorno = productionTypeRepository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;

    }

    @Override
    public ProductionType delete(Long id) {
        ProductionType productionType = getById(id);
        if (productionType != null) {
            productionTypeRepository.deleteById(id);
        }
        return productionType;
    }

}