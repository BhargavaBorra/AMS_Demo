package org.iitc.ams_demo.repository;

import org.iitc.ams_demo.DTO.LocationDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends CrudRepository<LocationDTO, Long> {
}
