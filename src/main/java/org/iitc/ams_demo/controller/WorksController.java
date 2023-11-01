package org.iitc.ams_demo.controller;

import org.iitc.ams_demo.DTO.WorksDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.service.WorksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorksController {

    WorksService worksService;

    public WorksController(WorksService worksService) {
        this.worksService = worksService;
    }

    @GetMapping("/works")
    public List<WorksDTO> getAllWorks() {
        return worksService.getWorks();
    }

    @GetMapping("/work/{id}")
    public WorksDTO getspecificWorks(@PathVariable Long id) throws ResourceNotFoundException {
        return worksService.getWorkDetails(id);
    }

    @PostMapping("/work")
    public void createWork(@RequestBody WorksDTO work) {
        worksService.addWork(work);
    }

    @PutMapping("/work/{id}")
    public void changeWorkDetails(@PathVariable(value = "id") Long id,
                                  @RequestBody WorksDTO work) throws ResourceNotFoundException {
        worksService.updateWork(work, id);
    }

    @DeleteMapping("/work/{id}")
    public void removeWorkDetails(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        worksService.deleteWork(id);
    }
}
