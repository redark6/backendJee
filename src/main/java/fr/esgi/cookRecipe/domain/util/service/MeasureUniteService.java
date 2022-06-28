package fr.esgi.cookRecipe.domain.util.service;

import fr.esgi.cookRecipe.domain.util.entity.MeasureUnit;
import fr.esgi.cookRecipe.domain.util.repository.MeasureUniteRepository;
import kernel.NoSuchEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MeasureUniteService {

    private final MeasureUniteRepository measureUniteRepository;

    @Autowired
    public MeasureUniteService(MeasureUniteRepository measureUniteRepository){
        this.measureUniteRepository = measureUniteRepository;
    }

    public MeasureUnit getMeasureUniteById(UUID id) {
       Optional<MeasureUnit> measureUnitOptional = this.measureUniteRepository.getMeasureUniteById(id);
        if(measureUnitOptional.isEmpty()){
            throw NoSuchEntityException.withIdAndElem(id,"measureUnit");
        }
        return measureUnitOptional.get();
    }
}
