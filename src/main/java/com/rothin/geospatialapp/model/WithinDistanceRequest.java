package com.rothin.geospatialapp.model;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WithinDistanceRequest {

    @NotNull
    private GeospatialCoordinate referencePoint;
    
    @NotNull
    private Double distanceKM;
    
    @NotNull
    private List<GeospatialCoordinate> array;
}
