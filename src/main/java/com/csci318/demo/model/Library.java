package com.csci318.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Library {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    // build a one-to-one relationship between
    // library and address
    // other relationships: @ManyToOne, @OneToMany
    @OneToOne
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private Address address;

    public Library() {};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}