package org.example.controller;


import org.example.model.Category;
import org.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Category controller.
 */
@RestController
@RequestMapping("/categories")

public class CategoryController {

    /**
     * ALle für die CategoryController benötigten Methoden werden initalisiert
     */
    private final CategoryService service;

    /**
     * Instantiates a new Category controller.
     *
     * @param service the service
     */
    public CategoryController(CategoryService service) {
        this.service = service;
    }


            //Alle Antworten  der Liste

    /**
     * Alle Kategorien mit allen Ressourcen der Datenbank werden in einer Liste zurückgegeben
     *
     * @return Category List
     */
    @GetMapping("/all")
    public List<Category> getAll() {
        return service.getAllCategories();
    }


    /**
     * Gets by id.
     *
     * @param id the id
     * @return Integer Eine Kategory wird nach der Id mit der zugehörigen Frage ausgelesen und  alle Fragen und Antworten welcher  zu eine Kategory gehören werden angezeigt und üebr den Primary Key Id der Kategorie angezeigt wird
     */
    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id) {
        return service.getCategoryById(id);
    }

    /**
     * DIe Kategorie wird anhand der ID eins bestimmten Spielers zugeordnet inklsuvie der Fragen un der restliche Informationen zugeordnete
     *
     * @param id the id
     * @return Integer
     */
    @GetMapping("/player/{id}")
    public Category getCategoryByPlayerId(@PathVariable Integer id) {
        return service.getCategoryById(id);
    }


    /**
     * Eine Kategory zur Category Liste hinzufügen und in der Datnebnk gespeichert
     *
     * @param category the category
     * @return Category List
     */
    @PostMapping("/createcategory")
    public Category createCategory(@RequestBody Category category) {
        return service.addCategory(category);
    }


    /**
     * Löscht eine Kategorie anhand ihrer ID.
     *
     * @param id Die ID der zu löschenden Kategorie.
     * @return the response entity
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        service.deleteCategoryById(id);
        return ResponseEntity.ok("Die Kategorie mit der ID " + id + " wurde aus der Kategorienliste entfernt");
    }



}



