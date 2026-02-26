package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * Repräsentiert eine Quiz-Kategorie (z. B. Nationalität, Verein).
 * Verwaltet die bidirektionalen Beziehungen zu Fragen und Antworten
 * mittels Jackson-Referenzen zur Vermeidung von Rekursionen.
 * Mit At Tbael erstltl einen Tabelle Category
 */
@Entity
@Table(name = "category")
public class Category {


    /**
     * Automatisch geneirtet Attribut id  das Primary Key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    /**
     *Attribut name
     */
    @Column(name = "category_name", nullable = false)
    private String category_name;

    /**
     *Team Attribut wird hinzugefügt
     */
    @Column(name="team")
    private String team;




    /**
     * Positition Attibut
     */
    @Column(name="position")
    private String position;
    @Column(name="nationality")
    private String nationality;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // Verhindert Fehler beim POST
    @JsonManagedReference(value = "category-answers") // Eindeutiger Name!
    private List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    @JsonManagedReference(value = "category-questions") // Eindeutiger Name!
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // Verhindert Fehler beim POST
    private List<Question> questions = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference(value = "category-questions") // Hier BackReference, da Category die Liste hält
    private Category category;

    /**
     * Instantiates a new Category mit einem Kontruktor an empty  Constructor.
     */
    public Category(){

    }


    /**
     * Instantiates a new Category mit dem Konstruktor mit dne Attributen id, name, team, position und nationality x.
     *
     * @param id          the id
     * @param category_name        the name
     * @param team        the team
     * @param position    the position
     * @param nationality the nationality
     */
    public Category( Integer id, String category_name, String team, String position, String nationality) {
        this.id = id;
        this.category_name = category_name;
        this.team = team;
        this.position = position;
        this.nationality = nationality;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    /**
     * Gets answers.
     *
     * @return the answers
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * Sets answers.
     *
     * @param answers the answers
     */
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    /**
     * Gets questions.
     *
     * @return the questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Sets questions.
     *
     * @param questions the questions
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */

    /**
     * Gets team.
     *
     * @return the team
     */
    public String getTeam() {
        return team;
    }

    /**
     * Sets team.
     *
     * @param team the team
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Gets nationality.
     *
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets nationality.
     *
     * @param nationality the nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


}
