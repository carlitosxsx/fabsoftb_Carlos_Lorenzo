package br.univille.projfabsoftmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftmp.repository.ImplementationRepository;
import br.univille.projfabsoftmp.service.ImplementationService;
import br.univille.projfabsoftmp.entity.Implementation;

@Service
public class ImplementationServiceImpl implements ImplementationService {

    @Autowired
    private ImplementationRepository implementationRepository;

    public ImplementationServiceImpl(ImplementationRepository implementationRepository) {
        this.implementationRepository = implementationRepository;
    }

    @Override
    public Implementation save(Implementation implementation) {
        return implementationRepository.save(implementation);
    }

    @Override
    public List<Implementation> getAll() {
        return implementationRepository.findAll();
    }

    @Override
    public Implementation getById(Long id) {
        var retorno = implementationRepository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;

    }

    @Override
    public Implementation delete(Long id) {
        Implementation implementation = getById(id);
        if (implementation != null) {
            implementationRepository.deleteById(id);
        }
        return implementation;
    }

}