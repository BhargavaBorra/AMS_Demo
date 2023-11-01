package org.iitc.ams_demo.controller;

import org.iitc.ams_demo.DTO.CategoryDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/category/{id}")
    public CategoryDTO getspecificCategories(@PathVariable Long id) throws ResourceNotFoundException {
        return categoryService.getCategoryDetails(id);
    }

    @PostMapping("/category")
    public void createCategory(@RequestBody CategoryDTO category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/category/{id}")
    public void changeCategoryDetails(@PathVariable(value = "id") Long id,
                                      @RequestBody CategoryDTO category) throws ResourceNotFoundException {
        categoryService.updateCategory(category, id);
    }

    @DeleteMapping("/category/{id}")
    public void removeCategoryDetails(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        categoryService.deleteCategory(id);
    }
}
