package org.iitc.ams_demo.repository;

import org.iitc.ams_demo.DTO.DepartmentDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends CrudRepository<DepartmentDTO, Long> {
}
