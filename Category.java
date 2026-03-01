package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * KORREKTUR: Dies ist ein einfaches Textfeld.
     * @ManyToOne und @JoinColumn wurden hier entfernt.
     */
    @Column(name = "category_name", nullable = false)
    private String category_name;

    @Column(name="team")
    private String team;

    @Column(name="position")
    private String position;

    @Column(name="nationality")
    private String nationality;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "category-answers")
    private List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    @JsonManagedReference(value = "category-questions")
    private List<Question> questions = new ArrayList<>();

    /**
     * Falls eine Kategorie einer Ober-Kategorie untergeordnet ist.
     * KORREKTUR: Eindeutiger Name für value in JsonBackReference.
     */
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category(){
    }

    public Category(Integer id, String category_name, String team, String position, String nationality) {
        this.id = id;
        this.category_name = category_name;
        this.team = team;
        this.position = position;
        this.nationality = nationality;
    }

    // GETTER UND SETTER
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public String getCategory_name() { return category_name; }
    public void setCategory_name(String category_name) { this.category_name = category_name; }

    public List<Answer> getAnswers() { return answers; }
    public void setAnswers(List<Answer> answers) { this.answers = answers; }

    public List<Question> getQuestions() { return questions; }
    public void setQuestions(List<Question> questions) { this.questions = questions; }

    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category_name='" + category_name + '\'' +
                ", team='" + team + '\'' +
                ", position='" + position + '\'' +
                ", nationality='" + nationality + '\'' +
                ", answers=" + answers +
                ", questions=" + questions +
                ", category=" + category +
                '}';
    }
}