package org.iitc.ams_demo.service;

import org.iitc.ams_demo.DTO.MaintenanceDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.repository.IMaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceService {

    private IMaintenanceRepository maintenanceRepository;

    public MaintenanceService(IMaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public List<MaintenanceDTO> getMaintenances() {
        List<MaintenanceDTO> Maintenances = new ArrayList<>();
        maintenanceRepository.findAll().forEach(Maintenances::add);
        return Maintenances;
    }

    public void addMaintenance(MaintenanceDTO maintenance) {
        maintenanceRepository.save(maintenance);
    }

    public void updateMaintenance(MaintenanceDTO maintenance, Long id) throws ResourceNotFoundException {
        MaintenanceDTO existingMaintenance = maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance not found for this id :: " + id));
        if (maintenance.getErrorCode() != null)
            existingMaintenance.setErrorCode(maintenance.getErrorCode());
        if (maintenance.getErrorDescription() != null)
            existingMaintenance.setErrorDescription(maintenance.getErrorDescription());
        if (maintenance.getStatus() != null)
            existingMaintenance.setStatus(maintenance.getStatus());
        maintenanceRepository.save(existingMaintenance);
    }

    public void deleteMaintenance(Long id) throws ResourceNotFoundException {
        MaintenanceDTO existingMaintenance = maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance not found for this id :: " + id));
        maintenanceRepository.delete(existingMaintenance);
    }

    public MaintenanceDTO getMaintenanceDetails(Long id) throws ResourceNotFoundException {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance not found for this id :: " + id));
    }
}
