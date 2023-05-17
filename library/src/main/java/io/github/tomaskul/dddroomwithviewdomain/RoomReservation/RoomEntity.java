package io.github.tomaskul.dddroomwithviewdomain.RoomReservation;

import io.github.tomaskul.dddroomwithviewdomain.DomainEntity;

import java.util.List;

public class RoomEntity extends DomainEntity<Long> {
    public List<RoomFeature> Features;

    public RoomEntity(Long id, List<RoomFeature> features) {
        Id = id;
        Features = features;
    }
}
