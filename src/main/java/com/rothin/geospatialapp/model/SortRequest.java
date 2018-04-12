package com.rothin.geospatialapp.model;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SortRequest {

    @NotNull
    private GeospatialCoordinate referencePoint;
    
    @NotNull
    private List<GeospatialCoordinate> array;
}
