package org.iitc.ams_demo.service;

import org.iitc.ams_demo.DTO.DepartmentDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.repository.IDepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private IDepartmentRepository departmentRepository;

    public DepartmentService(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDTO> getDepartments() {
        List<DepartmentDTO> Departments = new ArrayList<>();
        departmentRepository.findAll().forEach(Departments::add);
        return Departments;
    }

    public void addDepartment(DepartmentDTO department) {
        departmentRepository.save(department);
    }

    public void updateDepartment(DepartmentDTO department, Long id) throws ResourceNotFoundException {
        DepartmentDTO existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + id));
        if (department.getName() != null)
            existingDepartment.setName(department.getName());
        if (department.getEmail() != null)
            existingDepartment.setEmail(department.getEmail());
        if (department.getPhoneNumber() != null)
            existingDepartment.setPhoneNumber(department.getPhoneNumber());
        departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(Long id) throws ResourceNotFoundException {
        DepartmentDTO existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + id));
        departmentRepository.delete(existingDepartment);
    }

    public DepartmentDTO getDepartmentDetails(Long id) throws ResourceNotFoundException {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + id));
    }
}
