package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

//Tabelle Player mit F 1. Entitität
@Entity
@Table(name="player")
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 200)
    private String lastName;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Enumerated(EnumType.STRING)
    private Position position;
    @Column(name="nationality")
    private String nationality;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "team_id",nullable = false)
    @JsonBackReference
    private Team team;
    @Column(name="stats")
    private String stats;

    private boolean isactive;

    //  Separate  Enum Box mit  definierten Werten entweder kann ein Spieler Torwart, Verteidiger oder MItteldfeld oder Sturm als Value haben
    public enum Position {
        Torwart, Verteidiger, Mittelfeld, Sturm
    }

    //Leerer Konstruktor
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

