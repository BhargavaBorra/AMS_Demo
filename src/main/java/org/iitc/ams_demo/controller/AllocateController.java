package org.iitc.ams_demo.controller;

import org.iitc.ams_demo.DTO.AllocateDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.service.AllocateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AllocateController {

    AllocateService allocateService;

    public AllocateController(AllocateService allocateService) {
        this.allocateService = allocateService;
    }

    @GetMapping("/allocates")
    public List<AllocateDTO> getAllAllocates() {
        return allocateService.getAllocates();
    }

    @GetMapping("/allocate/{id}")
    public AllocateDTO getspecificAllocates(@PathVariable Long id) throws ResourceNotFoundException {
        return allocateService.getAllocateDetails(id);
    }

    @PostMapping("/allocate")
    public void createAllocate(@RequestBody AllocateDTO allocate) {
        allocateService.addAllocate(allocate);
    }

    @PutMapping("/allocate/{id}")
    public void changeAllocateDetails(@PathVariable(value = "id") Long id,
                                      @RequestBody AllocateDTO allocate) throws ResourceNotFoundException {
        allocateService.updateAllocate(allocate, id);
    }

    @DeleteMapping("/allocate/{id}")
    public void removeAllocateDetails(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        allocateService.deleteAllocate(id);
    }
}
