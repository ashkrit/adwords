package org.adword.repository;

import org.adword.models.ad.Ad;
import org.adword.models.query.UserQuery;

public interface AdRepository {

    float score(Ad ad, UserQuery userQuery);
}
