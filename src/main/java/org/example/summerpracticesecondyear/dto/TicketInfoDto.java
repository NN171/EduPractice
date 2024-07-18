package org.example.summerpracticesecondyear.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketInfoDto {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("movie_id")
    private Long movieId;

    @JsonProperty("session_id")
    private Long sessionId;

    @JsonProperty("seat")
    private int seat;

    public TicketInfoDto(Long userId, Long movieId, Long sessionId, int seat) {
        this.userId = userId;
        this.movieId = movieId;
        this.sessionId = sessionId;
        this.seat = seat;
    }

    public TicketInfoDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
