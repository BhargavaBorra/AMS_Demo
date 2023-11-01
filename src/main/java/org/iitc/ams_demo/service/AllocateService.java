package org.iitc.ams_demo.service;

import org.iitc.ams_demo.DTO.AllocateDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.repository.IAllocateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllocateService {

    private IAllocateRepository allocateRepository;

    public AllocateService(IAllocateRepository allocateRepository) {
        this.allocateRepository = allocateRepository;
    }

    public List<AllocateDTO> getAllocates() {
        List<AllocateDTO> Allocates = new ArrayList<>();
        allocateRepository.findAll().forEach(Allocates::add);
        return Allocates;
    }

    public void addAllocate(AllocateDTO allocate) {
        allocateRepository.save(allocate);
    }

    public void updateAllocate(AllocateDTO allocate, Long id) throws ResourceNotFoundException {
        AllocateDTO existingAllocate = allocateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Allocate not found for this id :: " + id));
        if (allocate.getAllocationDate() != null)
            existingAllocate.setAllocationDate(allocate.getAllocationDate());
        if (allocate.getDeAllocationDate() != null)
            existingAllocate.setDeAllocationDate(allocate.getDeAllocationDate());
        if (allocate.getUser().getUserId() != null)
            existingAllocate.setUser(allocate.getUser());
        if (allocate.getAsset().getAssetId() != null)
            existingAllocate.setAsset(allocate.getAsset());
        allocateRepository.save(existingAllocate);
    }

    public void deleteAllocate(Long id) throws ResourceNotFoundException {
        AllocateDTO existingAllocate = allocateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Allocate not found for this id :: " + id));
        allocateRepository.delete(existingAllocate);
    }

    public AllocateDTO getAllocateDetails(Long id) throws ResourceNotFoundException {
        return allocateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Allocate not found for this id :: " + id));
    }
}
