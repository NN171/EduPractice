package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie extends BaseEntity {

    private String title;
    private String genre;
    private int duration;
    private List<Room> rooms;

    public Movie() {
    }

    public Movie(String title, String genre, int duration, List<Room> rooms) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rooms = rooms;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @ManyToMany
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
