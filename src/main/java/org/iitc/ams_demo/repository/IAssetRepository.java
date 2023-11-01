package org.iitc.ams_demo.repository;

import org.iitc.ams_demo.DTO.AssetDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssetRepository extends CrudRepository<AssetDTO, Long> {
}
