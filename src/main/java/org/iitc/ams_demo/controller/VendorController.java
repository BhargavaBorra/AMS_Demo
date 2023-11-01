package org.iitc.ams_demo.controller;

import org.iitc.ams_demo.DTO.VendorDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendorController {

    VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/vendors")
    public List<VendorDTO> getAllVendors() {
        return vendorService.getVendors();
    }

    @GetMapping("/vendor/{id}")
    public VendorDTO getspecificVendors(@PathVariable Long id) throws ResourceNotFoundException {
        return vendorService.getVendorDetails(id);
    }

    @PostMapping("/vendor")
    public void createVendor(@RequestBody VendorDTO vendor) {
        vendorService.addVendor(vendor);
    }

    @PutMapping("/vendor/{id}")
    public void changeVendorDetails(@PathVariable(value = "id") Long id,
                                    @RequestBody VendorDTO vendor) throws ResourceNotFoundException {
        vendorService.updateVendor(vendor, id);
    }

    @DeleteMapping("/vendor/{id}")
    public void removeVendorDetails(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        vendorService.deleteVendor(id);
    }
}
