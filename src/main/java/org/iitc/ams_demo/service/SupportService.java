package org.iitc.ams_demo.service;

import org.iitc.ams_demo.DTO.SupportDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.repository.ISupportRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupportService {

    private ISupportRepository supportRepository;

    public SupportService(ISupportRepository supportRepository) {
        this.supportRepository = supportRepository;
    }

    public List<SupportDTO> getSupports() {
        List<SupportDTO> Supports = new ArrayList<>();
        supportRepository.findAll().forEach(Supports::add);
        return Supports;
    }

    public void addSupport(SupportDTO support) {
        supportRepository.save(support);
    }

    public void updateSupport(SupportDTO support, Long id) throws ResourceNotFoundException {
        SupportDTO existingSupport = supportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Support not found for this id :: " + id));
        if (support.getRequestDate() != null)
            existingSupport.setRequestDate(support.getRequestDate());
        if (support.getExpectedRepairDate() != null)
            existingSupport.setExpectedRepairDate(support.getExpectedRepairDate());
        if (support.getRequestDescription() != null)
            existingSupport.setRequestDescription(support.getRequestDescription());
        if (support.getAsset().getAssetId() != null)
            existingSupport.setAsset(support.getAsset());
        if (support.getMaintenance().getMaintenanceId() != null)
            existingSupport.setMaintenance(support.getMaintenance());
        supportRepository.save(existingSupport);
    }

    public void deleteSupport(Long id) throws ResourceNotFoundException {
        SupportDTO existingSupport = supportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Support not found for this id :: " + id));
        supportRepository.delete(existingSupport);
    }

    public SupportDTO getSupportDetails(Long id) throws ResourceNotFoundException {
        return supportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Support not found for this id :: " + id));
    }
}
