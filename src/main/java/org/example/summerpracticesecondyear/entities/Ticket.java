package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    private int seat;
    private User user;
    private Session session;
    private Movie movie;

    public Ticket() {
    }

    public Ticket(User user, Session session, int seat, Movie movie) {
        this.user = user;
        this.session = session;
        this.seat = seat;
        this.movie = movie;
    }

    @Column(name = "seat")
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
