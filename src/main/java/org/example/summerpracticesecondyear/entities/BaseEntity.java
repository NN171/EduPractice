package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    protected Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
