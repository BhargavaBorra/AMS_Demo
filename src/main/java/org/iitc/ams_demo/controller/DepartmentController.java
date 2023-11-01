package org.iitc.ams_demo.controller;

import org.iitc.ams_demo.DTO.DepartmentDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/department/{id}")
    public DepartmentDTO getspecificDepartments(@PathVariable Long id) throws ResourceNotFoundException {
        return departmentService.getDepartmentDetails(id);
    }

    @PostMapping("/department")
    public void createDepartment(@RequestBody DepartmentDTO department) {
        departmentService.addDepartment(department);
    }

    @PutMapping("/department/{id}")
    public void changeDepartmentDetails(@PathVariable(value = "id") Long id,
                                        @RequestBody DepartmentDTO department) throws ResourceNotFoundException {
        departmentService.updateDepartment(department, id);
    }

    @DeleteMapping("/department/{id}")
    public void removeDepartmentDetails(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        departmentService.deleteDepartment(id);
    }
}
