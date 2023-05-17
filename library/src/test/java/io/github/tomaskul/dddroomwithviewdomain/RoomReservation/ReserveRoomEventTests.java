package io.github.tomaskul.dddroomwithviewdomain.RoomReservation;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

class ReserveRoomEventTests {

    @ParameterizedTest
    @ValueSource(longs = {-1, Long.MIN_VALUE})
    void Cant_reserve_with_invalid_venue_id(long venueId) {
        assertThatThrownBy(() -> { new ReserveRoomEvent(venueId,15, new ReservationPeriod(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2))); })
                .hasMessage("Invalid venue ID");
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, Long.MIN_VALUE})
    void Cant_reserve_with_invalid_room_id(long roomId) {
        assertThatThrownBy(() -> { new ReserveRoomEvent(1, roomId, new ReservationPeriod(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2))); })
                .hasMessage("Invalid room ID");
    }

    @Test
    void Can_only_reserve_with_future_date(){
        assertThatThrownBy(() -> { new ReserveRoomEvent(1, 1, new ReservationPeriod(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(2))); })
                .hasMessage("Invalid from date");
    }

    @Test
    void Cant_reserve_with_from_date_ahead_of_to_date(){
        assertThatThrownBy(() -> { new ReserveRoomEvent(1, 1, new ReservationPeriod(LocalDateTime.now(), LocalDateTime.now().minusDays(2))); })
                .hasMessage("Invalid to date");
    }
}
