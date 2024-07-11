package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    private int userId;
    private int sessionId;
    private int seat;
    private Movie movie;

    public Ticket() {
    }

    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "session_id")
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Column(name = "seat_id")
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
}
