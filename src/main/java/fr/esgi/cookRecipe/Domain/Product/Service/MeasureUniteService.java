package fr.esgi.cookRecipe.Domain.Product.Service;

import fr.esgi.cookRecipe.Domain.Product.Repository.MeasureUniteRepository;
import fr.esgi.cookRecipe.Domain.Util.Entity.MeasureUnit;
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
