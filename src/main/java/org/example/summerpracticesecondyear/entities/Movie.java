package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Movie extends BaseEntity {

    private String title;
    private String genre;
    private int duration;
    private Set<Room> rooms;

    public Movie() {
    }

    public Movie(String title, String genre, int duration, Set<Room> rooms) {
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
    @JoinTable(name = "rooms_movies",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "room_id",
                    referencedColumnName = "id"))
    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
