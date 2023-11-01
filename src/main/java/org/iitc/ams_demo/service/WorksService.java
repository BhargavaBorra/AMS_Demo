package org.iitc.ams_demo.service;

import org.iitc.ams_demo.DTO.WorksDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.repository.IWorksRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorksService {

    private IWorksRepository worksRepository;

    public WorksService(IWorksRepository worksRepository) {
        this.worksRepository = worksRepository;
    }

    public List<WorksDTO> getWorks() {
        List<WorksDTO> Works = new ArrayList<>();
        worksRepository.findAll().forEach(Works::add);
        return Works;
    }

    public void addWork(WorksDTO work) {
        worksRepository.save(work);
    }

    public void updateWork(WorksDTO work, Long id) throws ResourceNotFoundException {
        WorksDTO existingWork = worksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Work not found for this id :: " + id));
        if (work.getProject() != null)
            existingWork.setProject(work.getProject());
        if (work.getUserRole() != null)
            existingWork.setUserRole(work.getUserRole());
        if (work.getUser().getUserId() != null)
            existingWork.setUser(work.getUser());
        if (work.getDepartment().getDepartmentId() != null)
            existingWork.setDepartment(work.getDepartment());
        worksRepository.save(existingWork);
    }

    public void deleteWork(Long id) throws ResourceNotFoundException {
        WorksDTO existingWork = worksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Work not found for this id :: " + id));
        worksRepository.delete(existingWork);
    }

    public WorksDTO getWorkDetails(Long id) throws ResourceNotFoundException {
        return worksRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Work not found for this id :: " + id));
    }
}
