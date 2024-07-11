package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "sessions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Session extends BaseEntity {

    private LocalDate sessionDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Movie movie;
    private Room room;

    public Session() {
    }

    public Session(LocalDate sessionDate, LocalDateTime startTime, LocalDateTime endTime, Movie movie, Room room) {
        this.sessionDate = sessionDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
        this.room = room;
    }

    @Column(name = "session_date")
    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    @Column(name = "start_time")
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Column(name = "end_time")
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
