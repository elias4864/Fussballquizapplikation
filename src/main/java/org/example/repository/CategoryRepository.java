package org.example.repository;

import org.example.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository  extends  JpaRepository<Category, Integer> {

    /**
     * Methode welche alle Kategorien anhand von Framework vorhanden Methode findALL ausgibt alle Datensätze aufruft
     * @return List
     */
    List<Category> findAll();

}
