package org.example.summerpracticesecondyear.dto;

public class TicketDto {

    private int seat;
    private String title;
    private String genre;

    public TicketDto() {
    }

    public TicketDto(int seat, String title, String genre) {
        this.seat = seat;
        this.title = title;
        this.genre = genre;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
