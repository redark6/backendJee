package fr.esgi.cookRecipe.exposition.ProductDTO;

public class MeasureUniteDTO {

    public String id;
    public String unit;

    public static MeasureUniteDTO of(String id, String unit) {
        return new MeasureUniteDTO(id, unit);
    }

    private MeasureUniteDTO(String id, String unit) {
        this.id = id;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "MeasureUniteDTO{" +
                "id='" + id + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
