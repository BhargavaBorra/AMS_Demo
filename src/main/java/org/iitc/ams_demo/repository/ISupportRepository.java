package org.iitc.ams_demo.repository;

import org.iitc.ams_demo.DTO.SupportDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupportRepository extends CrudRepository<SupportDTO, Long> {
}
