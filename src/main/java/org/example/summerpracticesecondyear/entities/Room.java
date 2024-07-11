package org.example.summerpracticesecondyear.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "rooms")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Room extends BaseEntity {

    private int capacity;
    private String title;
    private Set<Session> session;
    private Set<Movie> movies;

    public Room() {
    }

    public Room(int capacity, String title, Set<Session> session, Set<Movie> movies) {
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
    public Set<Session> getSession() {
        return session;
    }

    public void setSession(Set<Session> session) {
        this.session = session;
    }

    @ManyToMany
    @JoinTable(name = "rooms_movies",
            joinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id",
                    referencedColumnName = "id"))
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
