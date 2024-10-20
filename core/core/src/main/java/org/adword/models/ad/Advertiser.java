package org.adword.models.ad;

import java.time.LocalDateTime;

public record Advertiser(String id, String name, Company company, Email email, boolean active,
                         LocalDateTime createdAt) {

    public record Company(String name) {
    }

    public record Email(String email) {
    }
}
