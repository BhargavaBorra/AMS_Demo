package org.iitc.ams_demo.controller;

import org.iitc.ams_demo.DTO.AssetDTO;
import org.iitc.ams_demo.DTO.SupplyDTO;
import org.iitc.ams_demo.DTO.VendorDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.model.SupplyID;
import org.iitc.ams_demo.service.SupplyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplyController {

    SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @GetMapping("/suppliers")
    public List<SupplyDTO> getAllSuppliers() {
        return supplyService.getSuppliers();
    }

    @GetMapping("/supplier")
    public SupplyDTO getspecificSuppliers(@RequestParam Long assetId,
                                          @RequestParam Long vendorId) throws ResourceNotFoundException {
        AssetDTO asset = new AssetDTO();
        asset.setAssetId(assetId);
        VendorDTO vendor = new VendorDTO();
        vendor.setVendorId(vendorId);
        SupplyID id = new SupplyID(asset, vendor);
        return supplyService.getSupplierDetails(id);
    }

    @PostMapping("/supplier")
    public void createSupplier(@RequestBody SupplyDTO supplier) {
        supplyService.addSupplier(supplier);
    }

    @PutMapping("/supplier")
    public void changeSupplierDetails(@RequestBody SupplyDTO supplier) {
        supplyService.updateSupplier(supplier);
    }

    @DeleteMapping("/supplier")
    public void removeSupplierDetails(@RequestParam Long assetId,
                                      @RequestParam Long vendorId) throws ResourceNotFoundException {
        AssetDTO asset = new AssetDTO();
        asset.setAssetId(assetId);
        VendorDTO vendor = new VendorDTO();
        vendor.setVendorId(vendorId);
        SupplyID id = new SupplyID(asset, vendor);
        supplyService.deleteSupplier(id);
    }
}
