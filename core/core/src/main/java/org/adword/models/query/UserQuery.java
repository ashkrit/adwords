package org.adword.models.query;

import java.time.LocalDateTime;

public record UserQuery(String id, String rawQuery, UserLocation userLocation, LocalDateTime queryTime) {

    public record UserLocation(float lat, float lng) {
    }
}
