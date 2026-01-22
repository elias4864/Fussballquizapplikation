package org.example.controller;


import org.example.model.Category;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")

public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @GetMapping("/allanswers")
    public List<Category> getAll() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id) {
        return service.getCategoryById(id);
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category category) {
        return service.saveCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteCategory(id);
    }





}



