package org.adword.repository;

import org.adword.models.ad.Ad;
import org.adword.models.ad.Advertiser;

public interface AdvertiserRepository {

    float bid(Ad ad, Advertiser advertiser);
    Advertiser findAdvertiser(Ad ad);
}
