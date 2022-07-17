package fr.esgi.cookRecipe.domain.util.service;

import fr.esgi.cookRecipe.domain.product.entity.NutriScore;
import fr.esgi.cookRecipe.domain.util.entity.MeasureUnit;
import fr.esgi.cookRecipe.domain.util.repository.MeasureUniteRepository;
import kernel.NoSuchEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MeasureUniteService {

    private final MeasureUniteRepository measureUniteRepository;

    @Autowired
    public MeasureUniteService(MeasureUniteRepository measureUniteRepository){
        this.measureUniteRepository = measureUniteRepository;
    }

    public List<MeasureUnit> getAllMeasureUnite() {
        return this.measureUniteRepository.findAll();
    }

    public MeasureUnit getMeasureUniteById(UUID id) {
       Optional<MeasureUnit> measureUnitOptional = this.measureUniteRepository.getMeasureUniteById(id);
        if(measureUnitOptional.isEmpty()){
            throw NoSuchEntityException.withIdAndElem(id,"measureUnit");
        }
        return measureUnitOptional.get();
    }

    public MeasureUnit getMeasureUniteByUnite(String unite) {
        Optional<MeasureUnit> measureUnitOptional = this.measureUniteRepository.getMeasureUnitsByUnit(unite);
        if(measureUnitOptional.isEmpty()){
            throw NoSuchEntityException.withNameAndElem(unite,"measureUnit");
        }
        return measureUnitOptional.get();
    }
}
