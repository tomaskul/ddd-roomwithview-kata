package io.github.tomaskul.dddroomwithviewdomain.RoomReservation;

import io.github.tomaskul.dddroomwithviewdomain.ValueObject;

import java.time.LocalDateTime;

public class ReservationPeriod extends ValueObject {
    public LocalDateTime From;
    public LocalDateTime To;

    public ReservationPeriod(LocalDateTime from, LocalDateTime to) {
        LocalDateTime now = LocalDateTime.now();
        if (from.isBefore(now)) {
            throw new IllegalArgumentException("Invalid from date");
        }
        if (to.isBefore(from)) {
            throw new IllegalArgumentException("Invalid to date");
        }

        From = from;
        To = to;
    }
}
