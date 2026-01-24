package org.example.service;

import org.example.model.Category;
import org.example.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service

public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Category addCategory(Category category) {
        return repository.save(category);
    }

    public void deleteCategoryById(Integer id) {
        if (repository.existsById(id)) {repository.deleteById(id);
        } else {
            throw new RuntimeException("Kategorie mit ID " + id + " nicht gefunden.");
        }
    }



    public void deleteCategory(Integer id) {
        repository.deleteById(id);
    }






}
