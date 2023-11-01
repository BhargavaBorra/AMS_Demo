package org.iitc.ams_demo.service;

import org.iitc.ams_demo.DTO.LocationDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.repository.ILocationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    private ILocationRepository locationRepository;

    public LocationService(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationDTO> getLocations() {
        List<LocationDTO> Locations = new ArrayList<>();
        locationRepository.findAll().forEach(Locations::add);
        return Locations;
    }

    public void addLocation(LocationDTO location) {
        locationRepository.save(location);
    }

    public void updateLocation(LocationDTO location, Long id) throws ResourceNotFoundException {
        LocationDTO existingLocation = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found for this id :: " + id));
        if (location.getAddressLine1() != null)
            existingLocation.setAddressLine1(location.getAddressLine1());
        if (location.getAddressLine2() != null)
            existingLocation.setAddressLine2(location.getAddressLine2());
        if (location.getCity() != null)
            existingLocation.setCity(location.getCity());
        if (location.getState() != null)
            existingLocation.setState(location.getState());
        if (location.getZipCode() != null)
            existingLocation.setZipCode(location.getZipCode());
        locationRepository.save(existingLocation);
    }

    public void deleteLocation(Long id) throws ResourceNotFoundException {
        LocationDTO existingLocation = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found for this id :: " + id));
        locationRepository.delete(existingLocation);
    }

    public LocationDTO getLocationDetails(Long id) throws ResourceNotFoundException {
        return locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found for this id :: " + id));
    }
}
