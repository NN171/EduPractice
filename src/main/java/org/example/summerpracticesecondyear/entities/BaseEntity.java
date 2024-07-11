package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    protected int id;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
