package org.iitc.ams_demo.repository;

import org.iitc.ams_demo.DTO.WorksDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWorksRepository extends CrudRepository<WorksDTO, Long> {
}
