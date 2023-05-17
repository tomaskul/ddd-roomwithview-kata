package io.github.tomaskul.dddroomwithviewdomain.RoomReservation;

import io.github.tomaskul.dddroomwithviewdomain.DomainEvent;

public class ReserveRoomEvent extends DomainEvent {

    public long VenueId;
    public long RoomId;
    public RoomType RoomType;
    public ReservationPeriod Period;

    protected ReserveRoomEvent(long venueId, ReservationPeriod period){
        if (venueId < 0) {
            throw new IllegalArgumentException("Invalid venue ID");
        }
        VenueId = venueId;
        Period = period;

        RoomType = RoomType.Unknown;
    }

    public ReserveRoomEvent(long venueId, long roomId, ReservationPeriod period) {
        this(venueId, period);

        if (roomId < 0) {
            throw new IllegalArgumentException("Invalid room ID");
        }

        RoomId = roomId;
    }

    public ReserveRoomEvent(long venueId, RoomType type, ReservationPeriod period) {
        this(venueId, period);

        if (type == RoomType.Unknown) throw new IllegalArgumentException("Invalid room type");

        RoomType = type;
    }
}
