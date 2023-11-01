package org.iitc.ams_demo.service;

import org.iitc.ams_demo.DTO.VendorDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.repository.IVendorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorService {

    private IVendorRepository vendorRepository;

    public VendorService(IVendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<VendorDTO> getVendors() {
        List<VendorDTO> Vendors = new ArrayList<>();
        vendorRepository.findAll().forEach(Vendors::add);
        return Vendors;
    }

    public void addVendor(VendorDTO vendor) {
        vendorRepository.save(vendor);
    }

    public void updateVendor(VendorDTO vendor, Long id) throws ResourceNotFoundException {
        VendorDTO existingVendor = vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found for this id :: " + id));
        if (vendor.getName() != null)
            existingVendor.setName(vendor.getName());
        if (vendor.getEmail() != null)
            existingVendor.setEmail(vendor.getEmail());
        if (vendor.getContractDuration() != null)
            existingVendor.setContractDuration(vendor.getContractDuration());
        if (vendor.getPhoneNumber() != null)
            existingVendor.setPhoneNumber(vendor.getPhoneNumber());
        if (vendor.isContractStatus() != existingVendor.isContractStatus())
            existingVendor.setContractStatus(vendor.isContractStatus());
        vendorRepository.save(existingVendor);
    }

    public void deleteVendor(Long id) throws ResourceNotFoundException {
        VendorDTO existingVendor = vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found for this id :: " + id));
        vendorRepository.delete(existingVendor);
    }

    public VendorDTO getVendorDetails(Long id) throws ResourceNotFoundException {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found for this id :: " + id));
    }
}
