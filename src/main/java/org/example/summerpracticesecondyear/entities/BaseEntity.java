package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;

@Entity
public abstract class BaseEntity {

    protected int id;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
}
