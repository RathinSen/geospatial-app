package com.rothin.geospatialapp.model;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DistanceRequest {

    @NotNull
    private Double lat1;
    
    @NotNull
    private Double lon1;
    
    @NotNull
    private Double lat2;
    
    @NotNull
    private Double lon2;
}
