package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    private int seat;
    private boolean refund;
    private User user;
    private Session session;
    private Movie movie;

    public Ticket() {
    }

    public Ticket(User user, Session session, int seat, Movie movie) {
        this.user = user;
        this.refund = false;
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

    @Column(name = "refund")
    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
