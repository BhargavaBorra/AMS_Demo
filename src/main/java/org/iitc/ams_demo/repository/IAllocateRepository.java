package org.iitc.ams_demo.repository;

import org.iitc.ams_demo.DTO.AllocateDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAllocateRepository extends CrudRepository<AllocateDTO, Long> {
}
