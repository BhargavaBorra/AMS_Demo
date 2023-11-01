package org.iitc.ams_demo.repository;

import org.iitc.ams_demo.DTO.CategoryDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends CrudRepository<CategoryDTO, Long> {
}
