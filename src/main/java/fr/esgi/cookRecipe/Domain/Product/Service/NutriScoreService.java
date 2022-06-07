package fr.esgi.cookRecipe.Domain.Product.Service;

import fr.esgi.cookRecipe.Domain.Product.Entity.NutriScore;
import fr.esgi.cookRecipe.Domain.Product.Repository.NutriScoreRepository;
import kernel.NoSuchEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NutriScoreService {

    private final NutriScoreRepository nutriScoreRepository;

    @Autowired
    public NutriScoreService(NutriScoreRepository nutriScoreRepository) {
        this.nutriScoreRepository = nutriScoreRepository;
    }

    public void addNutriScore(NutriScore nutrisScore) {
        this.saveNutriScore(nutrisScore);
    }

    public List<NutriScore> getAllNutriScores() {
        return this.nutriScoreRepository.findAll();
    }

    public NutriScore getNutrisScoreById(UUID id) {
        Optional<NutriScore> nutrisScore = this.nutriScoreRepository.findById(id);
        if(nutrisScore.isEmpty()){
            throw NoSuchEntityException.withIdAndElem(id,"nutriScore");
        }
        return nutrisScore.get();
    }

    public NutriScore getNutrisScoreByGrade(char grade) {
        Optional<NutriScore> nutrisScore = this.nutriScoreRepository.getNutriScoreByGrade(grade);
        if(nutrisScore.isEmpty()){
            throw NoSuchEntityException.withNameAndElem(Character.toString(grade),"nutriScore");
        }
        return nutrisScore.get();
    }

    public void deleteNutriScoreById(UUID id) {
        this.nutriScoreRepository.delete(this.getNutrisScoreById(id));
    }

    private void saveNutriScore(NutriScore nutrisScore) {
        this.nutriScoreRepository.save(nutrisScore);
    }
}
