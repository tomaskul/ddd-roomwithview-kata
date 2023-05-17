package io.github.tomaskul.dddroomwithviewdomain.RoomReservation;

import io.github.tomaskul.dddroomwithviewdomain.Common.DomainEntity;

import java.util.List;

public class VenueEntity extends DomainEntity<Long> {

    public String Name;
    public List<RoomEntity> AvailableRooms;

    public VenueEntity(long id, String name, List<RoomEntity> availableRooms) {
        this.Id = id;
        this.Name = name;
        this.AvailableRooms = availableRooms;
    }
}
