package org.iitc.ams_demo.repository;

import org.iitc.ams_demo.DTO.MaintenanceDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMaintenanceRepository extends CrudRepository<MaintenanceDTO, Long> {
}
