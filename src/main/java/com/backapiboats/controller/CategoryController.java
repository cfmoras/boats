package com.backapiboats.controller;

import com.backapiboats.model.CategoryModel;
import com.backapiboats.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryModel> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<CategoryModel> getCategory(@PathVariable Integer id) {
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    public CategoryModel saveCategory(@RequestBody CategoryModel categoryModel) {
        return categoryService.saveCategory(categoryModel);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCategory(@PathVariable Integer id) {
        return categoryService.deleteCategory(id);
    }

    @PutMapping("/update")
    public CategoryModel updateCategory(@RequestBody CategoryModel categoryModel) {
        return categoryService.updateCategory(categoryModel);
    }
}
