package io.github.tomaskul.dddroomwithviewdomain.ReservationCancellation;

import io.github.tomaskul.dddroomwithviewdomain.DomainEvent;

public class CancelRoomReservationEvent extends DomainEvent {

    public long ReservationId;
    public CancelledBy By;
    public String Reason;
    public CancelRoomReservationEvent(long reservationId, CancelledBy by, String reason) {
        this.By = by;
        this.ReservationId = reservationId;
        this.Reason = reason;
    }
}
