package org.iitc.ams_demo.controller;

import org.iitc.ams_demo.DTO.MaintenanceDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.service.MaintenanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaintenanceController {

    MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping("/maintenances")
    public List<MaintenanceDTO> getAllMaintenances() {
        return maintenanceService.getMaintenances();
    }

    @GetMapping("/maintenance/{id}")
    public MaintenanceDTO getspecificMaintenances(@PathVariable Long id) throws ResourceNotFoundException {
        return maintenanceService.getMaintenanceDetails(id);
    }

    @PostMapping("/maintenance")
    public void createMaintenance(@RequestBody MaintenanceDTO maintenance) {
        maintenanceService.addMaintenance(maintenance);
    }

    @PutMapping("/maintenance/{id}")
    public void changeMaintenanceDetails(@PathVariable(value = "id") Long id,
                                         @RequestBody MaintenanceDTO maintenance) throws ResourceNotFoundException {
        maintenanceService.updateMaintenance(maintenance, id);
    }

    @DeleteMapping("/maintenance/{id}")
    public void removeMaintenanceDetails(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        maintenanceService.deleteMaintenance(id);
    }
}
