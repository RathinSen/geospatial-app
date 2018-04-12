package com.rothin.geospatialapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.rothin.geospatialapp.model.GeospatialCoordinate;
import com.rothin.geospatialapp.service.IGeospatialService;
import com.rothin.geospatialapp.utils.GeospatialUtils;

@Service
public class GeospatialServiceImpl implements IGeospatialService{


    @Override
    public List<GeospatialCoordinate> getCoordinatesWithinDistance(GeospatialCoordinate referencePoint, Double distanceKM, List<GeospatialCoordinate> array) {
        return array.stream().filter(coordinate -> distanceKM >= GeospatialUtils.getDistanceFromLatLonInKm(referencePoint.getLatitude(), referencePoint.getLongitude(), coordinate.getLatitude(), coordinate.getLongitude())).collect(Collectors.toList());
    }

    @Override
    public List<GeospatialCoordinate> sort(GeospatialCoordinate referencePoint, List<GeospatialCoordinate> array) {
        return array
                .stream()
                .sorted((c1, c2) -> GeospatialUtils.getDistanceFromLatLonInKm(referencePoint.getLatitude(), referencePoint.getLongitude(), c1.getLatitude(), c1.getLongitude()).compareTo(GeospatialUtils.getDistanceFromLatLonInKm(referencePoint.getLatitude(), referencePoint.getLongitude(), c2.getLatitude(), c2.getLongitude())))
                //.peek(c -> c.setDistance(GeospatialUtils.getDistanceFromLatLonInKm(referencePoint.getLatitude(), referencePoint.getLongitude(), c.getLatitude(), c.getLongitude())))
                .collect(Collectors.toList());
    }

}
