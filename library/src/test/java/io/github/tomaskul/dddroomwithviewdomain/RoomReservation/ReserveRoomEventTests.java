package io.github.tomaskul.dddroomwithviewdomain.RoomReservation;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

class ReserveRoomEventTests {

    private static ReservationPeriod validReservationPeriod;

    @BeforeAll
    public static void beforeAll(){
        validReservationPeriod = new ReservationPeriod(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2));
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, Long.MIN_VALUE})
    void Cant_reserve_with_invalid_venue_id(long venueId) {
        assertThatThrownBy(() -> { new ReserveRoomEvent(venueId,15, validReservationPeriod); })
                .hasMessage("Invalid venue ID");
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, Long.MIN_VALUE})
    void Cant_reserve_with_invalid_room_id(long roomId) {
        assertThatThrownBy(() -> { new ReserveRoomEvent(1, roomId, validReservationPeriod); })
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

    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"Unknown"})
    void Can_reserve_by_type(RoomType type){
        ReserveRoomEvent event = new ReserveRoomEvent(1, type, validReservationPeriod);
        assertThat(event.RoomType).isEqualTo(type);
    }

    @Test
    void Cant_reserve_by_unknown_room_type(){
        assertThatThrownBy(() -> { new ReserveRoomEvent(1, RoomType.Unknown, validReservationPeriod); })
                .hasMessage("Invalid room type");
    }
}
