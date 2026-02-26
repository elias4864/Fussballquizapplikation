package org.example.controller;

import org.example.model.Category;
import org.example.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller für die Verwaltung von Quiz-Kategorien.
 * Bietet Endpunkte zum Abrufen, Erstellen und Löschen von Kategorien.
 */
@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:5173") // Erlaubt Anfragen vom Frontend (Vite/React/Vue)
public class CategoryController {

    private final CategoryService service;

    /**
     * Konstruktor-Injektion des CategoryService.
     */
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    /**
     * Ruft alle Kategorien aus der Datenbank ab.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = service.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    /**
     * Findet eine Kategorie anhand ihrer ID.
     * @param id Die ID der Kategorie.
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<Category> getById(@PathVariable Integer id) {
        Category category = service.getCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Erstellt eine neue Kategorie.
     * @param category Die als JSON empfangene Kategorie.
     */
    @PostMapping("/createcategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        try {
            Category savedCategory = service.addCategory(category);
            return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Löscht eine Kategorie anhand ihrer ID.
     * @param id Die ID der zu löschenden Kategorie.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        try {
            service.deleteCategoryById(id);
            return ResponseEntity.ok("Die Kategorie mit der ID " + id + " wurde erfolgreich entfernt.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Fehler beim Löschen der Kategorie: " + e.getMessage());
        }
    }
}