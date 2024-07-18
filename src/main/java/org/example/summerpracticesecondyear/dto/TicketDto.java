package org.example.summerpracticesecondyear.dto;

public class TicketDto {

    private Long id;
    private int seat;
    private boolean refund;


    public TicketDto() {
    }

    public TicketDto(Long id, int seat, boolean refund) {
        this.id = id;
        this.seat = seat;
        this.refund = refund;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }
}
