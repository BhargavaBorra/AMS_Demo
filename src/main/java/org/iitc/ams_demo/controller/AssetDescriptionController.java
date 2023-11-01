package org.iitc.ams_demo.controller;

import org.iitc.ams_demo.DTO.AssetDescriptionDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.service.AssetDescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetDescriptionController {

    AssetDescriptionService assetDescriptionService;

    public AssetDescriptionController(AssetDescriptionService assetDescriptionService) {
        this.assetDescriptionService = assetDescriptionService;
    }

    @GetMapping("/asset/descriptions")
    public List<AssetDescriptionDTO> getAllAssetDescriptions() {
        return assetDescriptionService.getAssetDescriptions();
    }

    @GetMapping("/asset/description/{id}")
    public AssetDescriptionDTO getspecificAssetDescriptions(@PathVariable Long id) throws ResourceNotFoundException {
        return assetDescriptionService.getAssetDescriptionDetails(id);
    }

    @PostMapping("/asset/description")
    public void createAssetDescription(@RequestBody AssetDescriptionDTO assetDescription) {
        assetDescriptionService.addAssetDescription(assetDescription);
    }

    @PutMapping("/asset/description/{id}")
    public void changeAssetDescriptionDetails(@PathVariable(value = "id") Long id,
                                              @RequestBody AssetDescriptionDTO assetDescription) throws ResourceNotFoundException {
        assetDescriptionService.updateAssetDescription(assetDescription, id);
    }

    @DeleteMapping("/asset/description/{id}")
    public void removeAssetDescriptionDetails(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        assetDescriptionService.deleteAssetDescription(id);
    }
}
