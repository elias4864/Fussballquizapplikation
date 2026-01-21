package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "league")

public class League {

    @Id
    @Column(length = 10)
    private String id;

    @Column(nullable = false, length = 200)
    private String name;


    public League(){

    }
    public League(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // GETTER / SETTER
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "League{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
