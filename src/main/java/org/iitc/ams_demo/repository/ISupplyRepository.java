package org.iitc.ams_demo.repository;

import org.iitc.ams_demo.DTO.SupplyDTO;
import org.iitc.ams_demo.model.SupplyID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplyRepository extends CrudRepository<SupplyDTO, SupplyID> {
}
