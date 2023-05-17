package io.github.tomaskul.dddroomwithviewdomain.RoomReservation;

import io.github.tomaskul.dddroomwithviewdomain.DomainEvent;

import java.time.LocalDateTime;

public class ReserveRoomEvent extends DomainEvent {

    public long VenueId;
    public long RoomId;
    public LocalDateTime ReserveFrom;
    public LocalDateTime ReserveTo;

    public ReserveRoomEvent(long venueId, long roomId, LocalDateTime reserveFrom, LocalDateTime reserveTo) {
        if (venueId < 0) {
            throw new IllegalArgumentException("Invalid venue ID");
        }
        if (roomId < 0) {
            throw new IllegalArgumentException("Invalid room ID");
        }
        LocalDateTime now = LocalDateTime.now();
        if (reserveFrom.isBefore(now)) {
            throw new IllegalArgumentException("Invalid reserveFrom date");
        }
        if (reserveTo.isBefore(reserveFrom)) {
            throw new IllegalArgumentException("Invalid reserveTo date");
        }

        VenueId = venueId;
        RoomId = roomId;
        ReserveFrom = reserveFrom;
        ReserveTo = reserveTo;
    }
}
