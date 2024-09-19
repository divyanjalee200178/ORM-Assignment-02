package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class IdCard {
    @Id
    private int id;
    private String type;
    private String name;
    @ManyToOne
    //owener's side
    @JoinColumn(name ="card_id")
    private Person person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public IdCard(int id, String type, String name, Person person) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.person = person;
    }

    public IdCard() {
    }
}