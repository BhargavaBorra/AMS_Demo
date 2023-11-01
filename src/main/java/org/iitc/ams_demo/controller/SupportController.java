package org.iitc.ams_demo.controller;

import org.iitc.ams_demo.DTO.SupportDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.service.SupportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupportController {

    SupportService supportService;

    public SupportController(SupportService supportService) {
        this.supportService = supportService;
    }

    @GetMapping("/supports")
    public List<SupportDTO> getAllSupports() {
        return supportService.getSupports();
    }

    @GetMapping("/support/{id}")
    public SupportDTO getspecificSupports(@PathVariable Long id) throws ResourceNotFoundException {
        return supportService.getSupportDetails(id);
    }

    @PostMapping("/support")
    public void createSupport(@RequestBody SupportDTO support) {
        supportService.addSupport(support);
    }

    @PutMapping("/support/{id}")
    public void changeSupportDetails(@PathVariable(value = "id") Long id,
                                     @RequestBody SupportDTO support) throws ResourceNotFoundException {
        supportService.updateSupport(support, id);
    }

    @DeleteMapping("/support/{id}")
    public void removeSupportDetails(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        supportService.deleteSupport(id);
    }
}
