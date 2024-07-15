package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private double bonusBalance;
    private List<Movie> viewHistory;
    private List<Ticket> ticket;

    public User() {
    }

    public User(String firstName, String lastName, String email, List<Ticket> ticket, double bonusBalance, List<Movie> viewHistory) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ticket = ticket;
        this.bonusBalance = bonusBalance;
        this.viewHistory = viewHistory;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "bonus_balance")
    public double getBonusBalance() {
        return bonusBalance;
    }

    public void setBonusBalance(double bonusBalance) {
        this.bonusBalance = bonusBalance;
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

    @ManyToMany
    @JoinTable(name = "user_movies",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id",
                    referencedColumnName = "id"))
    public List<Movie> getViewHistory() {
        return viewHistory;
    }

    public void setViewHistory(List<Movie> viewHistory) {
        this.viewHistory = viewHistory;
    }

    @OneToMany(mappedBy = "user", targetEntity = Ticket.class,
    fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }
}
