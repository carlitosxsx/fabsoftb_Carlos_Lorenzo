package br.univille.projfabsoftmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftmp.repository.ColectRepository;
import br.univille.projfabsoftmp.service.ColectService;
import br.univille.projfabsoftmp.entity.Colect;

@Service
public class ColectServiceImpl implements ColectService {

    @Autowired
    private ColectRepository colectRepository;

    public ColectServiceImpl(ColectRepository colectRepository) {
        this.colectRepository = colectRepository;
    }

    @Override
    public Colect save(Colect colect) {
        return colectRepository.save(colect);
    }

    @Override
    public List<Colect> getAll() {
        return colectRepository.findAll();
    }

    @Override
    public Colect getById(Long id) {
        var retorno = colectRepository.findById(id);
        if (retorno.isPresent())
            return retorno.get();
        return null;

    }

    @Override
    public Colect delete(Long id) {
        Colect colect = getById(id);
        if (colect != null) {
            colectRepository.deleteById(id);
        }
        return colect;
    }

}