package org.iitc.ams_demo.controller;

import org.iitc.ams_demo.DTO.LocationDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public List<LocationDTO> getAllLocations() {
        return locationService.getLocations();
    }

    @GetMapping("/location/{id}")
    public LocationDTO getspecificLocations(@PathVariable Long id) throws ResourceNotFoundException {
        return locationService.getLocationDetails(id);
    }

    @PostMapping("/location")
    public void createLocation(@RequestBody LocationDTO location) {
        locationService.addLocation(location);
    }

    @PutMapping("/location/{id}")
    public void changeLocationDetails(@PathVariable(value = "id") Long id,
                                      @RequestBody LocationDTO location) throws ResourceNotFoundException {
        locationService.updateLocation(location, id);
    }

    @DeleteMapping("/location/{id}")
    public void removeLocationDetails(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        locationService.deleteLocation(id);
    }
}
