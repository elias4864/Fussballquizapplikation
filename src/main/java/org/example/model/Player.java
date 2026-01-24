package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//Tabelle Player mit F 1. Entitität
@Entity
@Table(name="player")
public class Player {


    /**
     *  @author elias
     *   @version 1.0
     */



    /**
     * Id automatisch generierte
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * FirstName
     */

    @Column(name = "first_name", length = 100)
    private String firstName;


    /**
     * lastName Row wird hinzugefügt
     */
    @Column(name = "last_name", length = 200)
    private String lastName;


    /**
     * Attribut birth_year
     * @param birthYear
     * @return Integer
     */

    @Column(name = "birth_year")
    private Integer birthYear;

    /**
     * Position mit Aufzählungen(Enums) Values entweder  Torwart, Mitelfeld, Sturm oder erteidiger
     */

    @Enumerated(EnumType.STRING)
    private Position position;




    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonBackReference
    private Team team;

    /**
     * Managed Reference der Player Tabelle und Antowrten Liste
     */


    @OneToOne
    @JoinColumn(name = "question_id")
    @JsonManagedReference
    private Question question;

    @OneToMany(mappedBy = "player")
    @JsonManagedReference
    private List<Answer> answers = new ArrayList<>();






    /**
     * Nationalität
     */
    @Column(name="nationality")
    private String nationality;


    @Column(name="stats")
    private String stats;


    /**
     *Attribute iactive mit boolean überprufen ob Aussage wahr oder falsch ist.
     */

    private boolean isactive;

    //  Separate  Enum Box mit  definierten Werten entweder kann ein Spieler Torwart, Verteidiger oder MItteldfeld oder Sturm als Value haben
    public enum Position {
        Torwart, Verteidiger, Mittelfeld, Sturm
    }

    /**
     * Leerer Konstruktor
     */

    public Player() {
    }
    public Player(Integer id,String firstName,String lastName,Integer birthYear,Position position,String nationality, Team team, String stats, boolean isactive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.position = position;
        this.nationality = nationality;
        this.team = team;
        this.stats = stats;
        this.isactive=isactive;
    }

    public Integer getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                ", position=" + position +
                ", nationality='" + nationality + '\'' +
                ", team=" + team +
                ", stats='" + stats + '\'' +
                ", isactive=" + isactive +
                '}';
    }
}

