package fr.esgi.cookRecipe.exposition.ProductDTO;

import java.util.List;

public class MeasuresUniteDTO {

    public final List<MeasureUniteDTO> measureUnite;

    public static MeasuresUniteDTO of(List<MeasureUniteDTO> measureUnite) {
        return new MeasuresUniteDTO(measureUnite);
    }

    private MeasuresUniteDTO(List<MeasureUniteDTO> measureUnite) {
        this.measureUnite = measureUnite;
    }
}
