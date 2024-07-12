package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private Set<Ticket> ticket;

    public User() {
    }

    public User(String firstName, String lastName, String email, Set<Ticket> ticket) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ticket = ticket;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user", targetEntity = Ticket.class,
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(Set<Ticket> ticket) {
        this.ticket = ticket;
    }
}
