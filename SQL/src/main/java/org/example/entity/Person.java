package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {
    @Id
    private int id;
    @Column
    private String name;
    private String address;
    //Inverse side
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)

    private List<IdCard> idCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<IdCard> getIdCard() {
        return idCard;
    }

    public void setIdCard(List<IdCard> idCard) {
        this.idCard = idCard;
    }

    public Person(int id, String name, String address, List<IdCard> idCard) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.idCard = idCard;
    }

    public Person() {
    }
}