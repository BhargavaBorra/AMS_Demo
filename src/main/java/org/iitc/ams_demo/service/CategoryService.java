package org.iitc.ams_demo.service;

import org.iitc.ams_demo.DTO.CategoryDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getCategories() {
        List<CategoryDTO> Categories = new ArrayList<>();
        categoryRepository.findAll().forEach(Categories::add);
        return Categories;
    }

    public void addCategory(CategoryDTO category) {
        categoryRepository.save(category);
    }

    public void updateCategory(CategoryDTO category, Long id) throws ResourceNotFoundException {
        CategoryDTO existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + id));
        if (category.getName() != null)
            existingCategory.setName(category.getName());
        if (category.getAvailable() != null)
            existingCategory.setAvailable(category.getAvailable());
        if (category.getAssigned() != null)
            existingCategory.setAssigned(category.getAssigned());
        if (category.getTotal() != null)
            existingCategory.setTotal(category.getTotal());
        categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Long id) throws ResourceNotFoundException {
        CategoryDTO existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + id));
        categoryRepository.delete(existingCategory);
    }

    public CategoryDTO getCategoryDetails(Long id) throws ResourceNotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + id));
    }
}
