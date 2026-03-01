package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Player.
 */
//Tabelle Player mit F 1. Entitität
@Entity
@Table(name="player")
public class Player {


    /**
     *  @author elias
     *   @version 1.0
     */



    /**
     * Annotation Generated Value markiert Id als Primarry Keys  für die HTTP Request Abfrage im PlayerCOntroller
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Firstname mit der Länge 100 Zeichen
     */

    @Column(name = "first_name", length = 100)
    private String firstName;


    /**
     * lastName Row wird hinzugefügt und mit der Länge 200
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


    /**
     * ALle  bidirektionbalen Beziehungen werden  wie Felder ignoriert werden
     */
    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;



    /**
     * Managed Reference der Player Tabelle und Antowrten Liste mit gegenseitiger Beziehung
     */

    /**
     * Die Frage, die sich direkt auf diesen Spieler bezieht (1:1).
     */


    @OneToOne // Falls es 1:1 ist, sonst @ManyToOne wie in deinem Code
    @JoinColumn(name = "question_id")
    @JsonBackReference(value = "question-player") // MUSS exakt wie der Wert in Question heißen
    private Question question;
    /**
     * Managed Reference der Player Tabelle und Antowrten Liste
     */








    @Column(name="nationality")
    private String nationality;


    @Column(name="stats")
    private String stats;





    @Column(name = "isactive")
    private boolean isactive;

    /**
     * The enum Position.
     */
//  Separate  Enum Box mit  definierten Werten entweder kann ein Spieler Torwart, Verteidiger oder MItteldfeld oder Sturm als Value haben
    public enum Position {
        /**
         * Torwart position.
         */
        Torwart,
        /**
         * Verteidiger position.
         */
        Verteidiger,
        /**
         * Mittelfeld position.
         */
        Mittelfeld,
        /**
         * Sturm position.
         */
        Sturm
    }

    /**
     * Leerer Konstruktor Playdsr bei zu vielen Attributen verwendet
     */
    public Player() {
    }


    /**
     * Instantiates a new Player.
     *
     * @param id          the id
     * @param firstName   the first name
     * @param lastName    the last name
     * @param birthYear   the birth year
     * @param position    the position
     * @param nationality the nationality
     * @param team        the team
     * @param stats       the stats
     * @param isactive    the isactive
     */
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
     * Gets question.
     *
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Sets question.
     *
     * @param question the question
     */
    public void setQuestion(Question question) {
        this.question = question;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Gets birth year.
     *
     * @return the birth year
     */
    public Integer getBirthYear() {
        return birthYear;
    }

    /**
     * Sets birth year.
     *
     * @param birthYear the birth year
     */
    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
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

    /**
     * Gets team.
     *
     * @return the team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Sets team.
     *
     * @param team the team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Gets stats.
     *
     * @return the stats
     */
    public String getStats() {
        return stats;
    }

    /**
     * Sets stats.
     *
     * @param stats the stats
     */
    public void setStats(String stats) {
        this.stats = stats;
    }

    /**
     * Is isactive boolean.
     *
     * @return the boolean
     */
    public boolean isIsactive() {
        return isactive;
    }

    /**
     * Sets isactive.
     *
     * @param isactive the isactive
     */
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

