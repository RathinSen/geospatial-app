package com.rothin.geospatialapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class GeospatialCoordinate {

    
    private Double latitude;
    private Double longitude;
    private Double distance;
}
