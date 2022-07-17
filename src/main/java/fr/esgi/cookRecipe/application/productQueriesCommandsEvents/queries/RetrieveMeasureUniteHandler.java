package fr.esgi.cookRecipe.application.productQueriesCommandsEvents.queries;

import fr.esgi.cookRecipe.application.EntityToDTOSerializer;
import fr.esgi.cookRecipe.domain.util.entity.MeasureUnit;
import fr.esgi.cookRecipe.domain.util.service.MeasureUniteService;
import fr.esgi.cookRecipe.exposition.ProductDTO.MeasuresUniteDTO;
import kernel.QueryHandler;


import java.util.List;

public class RetrieveMeasureUniteHandler implements QueryHandler<RetrieveMeasureUnite, MeasuresUniteDTO> {

    private final MeasureUniteService measureUniteService;

    public RetrieveMeasureUniteHandler(MeasureUniteService measureUniteService) {
        this.measureUniteService = measureUniteService;
    }

    @Override
    public MeasuresUniteDTO handle(RetrieveMeasureUnite query) {
        List<MeasureUnit> measureUnits = this.measureUniteService.getAllMeasureUnite();
        return EntityToDTOSerializer.measuresUniteListToMeasuresUniteDTO(measureUnits);
    }
}
