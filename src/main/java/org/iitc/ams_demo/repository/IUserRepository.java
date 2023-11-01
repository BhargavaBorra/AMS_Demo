package org.iitc.ams_demo.repository;

import org.iitc.ams_demo.DTO.UserDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<UserDTO, Long> {
}
