package io.github.tomaskul.dddroomwithviewdomain.RoomReservation;

import io.github.tomaskul.dddroomwithviewdomain.DomainEntity;

import java.util.List;

public class RoomEntity extends DomainEntity<Long> {
    public RoomType Type;
    public List<RoomFeature> Features;

    public RoomEntity(Long id, RoomType type, List<RoomFeature> features) {
        Id = id;
        Type = type;
        Features = features;
    }
}
