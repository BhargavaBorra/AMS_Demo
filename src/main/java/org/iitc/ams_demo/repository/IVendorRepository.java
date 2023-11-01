package org.iitc.ams_demo.repository;

import org.iitc.ams_demo.DTO.VendorDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendorRepository extends CrudRepository<VendorDTO, Long> {
}
