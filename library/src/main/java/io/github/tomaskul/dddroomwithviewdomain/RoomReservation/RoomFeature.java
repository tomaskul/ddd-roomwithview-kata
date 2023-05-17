package io.github.tomaskul.dddroomwithviewdomain.RoomReservation;

import io.github.tomaskul.dddroomwithviewdomain.Common.ValueObject;

public class RoomFeature extends ValueObject {
    public String Name;
    public String Description;

    public RoomFeature(String name, String description) {
        if (name == null || name == "") {
            throw new IllegalArgumentException("Invalid name");
        }
        Name = name;
        Description = description;
    }
}
