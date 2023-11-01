package org.iitc.ams_demo.service;

import org.iitc.ams_demo.DTO.AssetDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.repository.IAssetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssetService {

    IAssetRepository assetRepository;

    public AssetService(IAssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<AssetDTO> getAssets() {
        List<AssetDTO> assets = new ArrayList<>();
        assetRepository.findAll().forEach(assets::add);
        return assets;
    }

    public AssetDTO getAssetDetails(Long id) throws ResourceNotFoundException {
        return assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found for this id :: " + id));
    }

    public void addAsset(AssetDTO asset) {
        assetRepository.save(asset);
    }

    public void updateAsset(AssetDTO asset, Long id) throws ResourceNotFoundException {
        AssetDTO existingAsset = assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found for this id :: " + id));
        if (asset.getAssetName() != null)
            existingAsset.setAssetName(asset.getAssetName());
        if (asset.getSerialNumber() != null)
            existingAsset.setSerialNumber(asset.getSerialNumber());
        if (existingAsset.getWarranty() != asset.getWarranty() && asset.getWarranty() != 0)
            existingAsset.setWarranty(asset.getWarranty());
        if (asset.getWarrantyExpiryDate() != null)
            existingAsset.setWarrantyExpiryDate(asset.getWarrantyExpiryDate());
        if (asset.getShippedDate() != null)
            existingAsset.setShippedDate(asset.getShippedDate());
        if (existingAsset.getLocation() != null)
            existingAsset.setLocation(asset.getLocation());
        assetRepository.save(existingAsset);
    }

    public void deleteAsset(Long id) throws ResourceNotFoundException {
        AssetDTO existingAsset = assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found for this id :: " + id));
        assetRepository.delete(existingAsset);
    }
}
