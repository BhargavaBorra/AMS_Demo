package org.iitc.ams_demo.controller;

import org.iitc.ams_demo.DTO.AssetDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetController {

    AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping("/assets")
    public List<AssetDTO> getAllAssets() {
        return assetService.getAssets();
    }

    @GetMapping("/asset/{id}")
    public AssetDTO getspecificAsset(@PathVariable Long id) throws ResourceNotFoundException {
        return assetService.getAssetDetails(id);
    }

    @PostMapping("/asset")
    public void createAsset(@RequestBody AssetDTO asset) {
        assetService.addAsset(asset);
    }

    @PutMapping("/asset/{id}")
    public void changeAssetDetails(@PathVariable(value = "id") Long id,
                                   @RequestBody AssetDTO asset) throws ResourceNotFoundException {
        assetService.updateAsset(asset, id);
    }

    @DeleteMapping("/asset/{id}")
    public void removeAssets(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        assetService.deleteAsset(id);
    }
}
