package org.adword.models.ad;

import java.util.List;

public record AdvertiserAd(AdvertiserId id, List<Ad> ads) {

    public record AdvertiserId(String id) {
    }
}
