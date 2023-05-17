package io.github.tomaskul.dddroomwithviewdomain.RoomReservation;

import io.github.tomaskul.dddroomwithviewdomain.DomainEvent;

public class ReserveRoomEvent extends DomainEvent {

    public long VenueId;
    public long RoomId;
    public ReservationPeriod Period;

    public ReserveRoomEvent(long venueId, long roomId, ReservationPeriod period) {
        if (venueId < 0) {
            throw new IllegalArgumentException("Invalid venue ID");
        }
        if (roomId < 0) {
            throw new IllegalArgumentException("Invalid room ID");
        }

        VenueId = venueId;
        RoomId = roomId;
        Period = period;
    }
}
