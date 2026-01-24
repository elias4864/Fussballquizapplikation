package org.example.controller;


import org.example.model.Category;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")

public class CategoryController {

    /**
     * ALle für die CategoryController benötigten Methoden werden initalisiert
     */
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


            //Alle Antworten  der Liste

    /**
     *

     */
    @GetMapping("/all")
    public List<Category> getAll() {
        return service.getAllCategories();
    }


    /**
     * @param id
     * @return Integer
     * Eine Kategory wird nach der Id mit der zugehörigen Frage ausgelesen und  alle Fragen und Antworten welcher  zu eine Kategory gehören werden angezeigt und ü
ebr den Primary Key Id der Kategorie angezeigt wird     */
    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id) {
        return service.getCategoryById(id);
    }

    /**
     * DIe Kategorie wird anhand der ID eins bestimmten Spielers zugeordnet inklsuvie der Fragen un der restliche Informationen
     * @param playerId
     * @return Integer
     */

    @GetMapping("/player/{playerid}")
    public Category getCategoryByPlayerId(@PathVariable Integer playerId) {
        return service.getCategoryById(playerId);
    }


    /**
     * Eine Kategory zur Category Liste hinzufügen
     * @param category
     * @return Category List
     */

    @PostMapping("/createcategory")
    public Category createCategory(@RequestBody Category category) {
        return service.addCategory(category);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        service.deleteCategoryById(id);
        return ResponseEntity.ok("Die Kategorie mit der ID " + id + " wurde aus der Kategorienliste entfernt.");
    }

}



