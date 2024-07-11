package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
