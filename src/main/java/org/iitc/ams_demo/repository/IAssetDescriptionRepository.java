package org.iitc.ams_demo.repository;

import org.iitc.ams_demo.DTO.AssetDescriptionDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssetDescriptionRepository extends CrudRepository<AssetDescriptionDTO, Long> {
}
