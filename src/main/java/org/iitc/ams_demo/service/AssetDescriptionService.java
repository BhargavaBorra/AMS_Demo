package org.iitc.ams_demo.service;

import org.iitc.ams_demo.DTO.AssetDescriptionDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.repository.IAssetDescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssetDescriptionService {

    private IAssetDescriptionRepository assetDescriptionRepository;

    public AssetDescriptionService(IAssetDescriptionRepository assetDescriptionRepository) {
        this.assetDescriptionRepository = assetDescriptionRepository;
    }

    public List<AssetDescriptionDTO> getAssetDescriptions() {
        List<AssetDescriptionDTO> AssetDescriptions = new ArrayList<>();
        assetDescriptionRepository.findAll().forEach(AssetDescriptions::add);
        return AssetDescriptions;
    }

    public void addAssetDescription(AssetDescriptionDTO assetDescription) {
        assetDescriptionRepository.save(assetDescription);
    }

    public void updateAssetDescription(AssetDescriptionDTO assetDescription, Long id)
            throws ResourceNotFoundException {
        AssetDescriptionDTO existingAssetDescription = assetDescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AssetDescription not found for this id :: " + id));
        if (assetDescription.getCategory().getCategoryId() != null)
            existingAssetDescription.setCategory(assetDescription.getCategory());
        if (assetDescription.getCondition() != null)
            existingAssetDescription.setCondition(assetDescription.getCondition());
        if (assetDescription.getSpecifications() != null)
            existingAssetDescription.setSpecifications(assetDescription.getSpecifications());
        if (assetDescription.getAsset().getAssetId() != null)
            existingAssetDescription.setAsset(assetDescription.getAsset());
        assetDescriptionRepository.save(existingAssetDescription);
    }

    public void deleteAssetDescription(Long id) throws ResourceNotFoundException {
        AssetDescriptionDTO existingAssetDescription = assetDescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AssetDescription not found for this id :: " + id));
        assetDescriptionRepository.delete(existingAssetDescription);
    }

    public AssetDescriptionDTO getAssetDescriptionDetails(Long id) throws ResourceNotFoundException {
        return assetDescriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AssetDescription not found for this id :: " + id));
    }
}
