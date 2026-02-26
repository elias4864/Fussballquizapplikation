package org.example.service;

import org.example.model.Category;
import org.example.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Service;

// Diese beiden fehlen in deinem Entwurf:
import java.util.List;



/**
 * spezielle Annotation damit Spring weiss dass es  bei dieser Klasse tatsächlich um Service handelt
 */
@Service

public class CategoryService {

    /**
     * Category klasse mit Dependency Injetion zum Categoryrepository mit allen bentötigten Methoden  für Category Controller  damit HTTp Requests Daten zuerste an Repository vor dem Service sendet.
     *
     */

    private final CategoryRepository repository;

    /**
     * Instantiates a new Category service.
     *
     * @param repository the repository
     */
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    /**
     * Gets all categories.
     *
     * @return the all categories
     */
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    /**
     * Gets category by id.
     *
     * @param id the id
     * @return the category by id
     */
    public Category getCategoryById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Add category category.
     *
     * @param category the category
     * @return the category
     */
    public Category addCategory(Category category) {
        return repository.save(category);
    }

    /**
     * Methode welche  anhand der Methode  deleteCategoryBId mit dem PrimaryKey der Category als Parameter löscht
     * Die HTTP Anfrage wrid von Servie an das Repository weitergebgen und mit einer IF/Else Scheleife überprüft ob diese ID existiert, falls sie nicht existier erhötl man die Nahrich im Respone das die Kategory nicht gefunden werden kan duerh eine Exception Message
     *
     * @param id the id
     */
    public void deleteCategoryById(Integer id) {
        if (repository.existsById(id)) {repository.deleteById(id);
        } else {
            throw new RuntimeException("Kategorie mit ID " + id + " nicht gefunden.");
        }
    }


    /**
     * Delete category.
     *
     * @param id the id
     */
    public void deleteCategory(Integer id) {
        repository.deleteById(id);
    }






}
