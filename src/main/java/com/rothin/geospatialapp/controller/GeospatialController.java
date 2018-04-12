package com.rothin.geospatialapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rothin.geospatialapp.model.DistanceRequest;
import com.rothin.geospatialapp.model.GeospatialCoordinate;
import com.rothin.geospatialapp.model.SortRequest;
import com.rothin.geospatialapp.model.WithinDistanceRequest;
import com.rothin.geospatialapp.service.IGeospatialService;
import com.rothin.geospatialapp.utils.GeospatialUtils;

@RestController
public class GeospatialController {

    IGeospatialService geoSpatialService;
    
    public GeospatialController(IGeospatialService geoSpatialService) {
        this.geoSpatialService = geoSpatialService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/determinedistance")
    public Map<String, Object> determineDistance(@Valid @RequestBody(required=true) DistanceRequest request){
        Map<String, Object> response  = new HashMap<>();
        response.put("distanceKM", GeospatialUtils.getDistanceFromLatLonInKm(request.getLat1(), request.getLon1(), request.getLat2(), request.getLon2()));
        return response;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/withindistance")
    public Map<String, Object> withinDistance(@Valid @RequestBody(required=true) WithinDistanceRequest request){
        Map<String, Object> response  = new HashMap<>();
        List<GeospatialCoordinate> coordinates = geoSpatialService.getCoordinatesWithinDistance(request.getReferencePoint(), request.getDistanceKM(), request.getArray());
        response.put("result", coordinates);
        return response;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/sort")
    public Map<String, Object> sort(@Valid  @RequestBody(required=true) SortRequest request){
        Map<String, Object> response  = new HashMap<>();
        List<GeospatialCoordinate> coordinates = geoSpatialService.sort(request.getReferencePoint(), request.getArray());
        response.put("sortedArray", coordinates);
        return response;
    }
}
