package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rooms")
public class Room extends BaseEntity {

    private int capacity;
    private String title;
    private List<Session> session;
    private List<Movie> movies;

    public Room() {
    }

    public Room(int capacity, String title, List<Session> session, List<Movie> movies) {
        this.capacity = capacity;
        this.title = title;
        this.session = session;
        this.movies = movies;
    }

    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany(mappedBy = "room", targetEntity = Session.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Session> getSession() {
        return session;
    }

    public void setSession(List<Session> session) {
        this.session = session;
    }

    @ManyToMany
    @JoinTable(name = "rooms_movies",
            joinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id",
                    referencedColumnName = "id"))
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
