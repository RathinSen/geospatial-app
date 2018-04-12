package com.rothin.geospatialapp.service;

import java.util.List;
import com.rothin.geospatialapp.model.GeospatialCoordinate;

public interface IGeospatialService {
    
    public List<GeospatialCoordinate> getCoordinatesWithinDistance(GeospatialCoordinate referencePoint, Double distanceKM, List<GeospatialCoordinate> array);

    public List<GeospatialCoordinate> sort(GeospatialCoordinate referencePoint, List<GeospatialCoordinate> array); 
    

}
