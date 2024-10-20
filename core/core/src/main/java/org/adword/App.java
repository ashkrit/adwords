package org.adword;

import org.adword.models.ad.Ad;
import org.adword.models.ad.AdGroup;
import org.adword.models.ad.Advertiser;
import org.adword.models.keyword.SearchKeyWord;
import org.adword.models.query.UserQuery;
import org.adword.repository.AdGroupRepository;
import org.adword.repository.AdRepository;
import org.adword.repository.AdvertiserRepository;
import org.adword.repository.KeyWordRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var noLocation = new UserQuery.UserLocation(0.0f, 0.0f);
        var query = new UserQuery(UUID.randomUUID().toString(), "fast food", noLocation, LocalDateTime.now());

        var keyWords = keyWords();
        var adGroups = adsGroups();
        var ads = ads();
        var advertiserRepository = advertiserRepository();


        var adsToServe = keyWords
                .findAll()
                .stream()
                .filter(x -> findKeyWord(x, query))
                .flatMap(key -> matchAdGroup(key, adGroups))
                .flatMap(g -> g.ads().stream())
                .map(ad -> toAddInfo(ad, ads, query, advertiserRepository))
                .filter(App::dropLowQuality)
                .toList();


        System.out.println(adsToServe);


    }

    private static boolean dropLowQuality(AddInfo adInfo) {
        return adInfo.score > .5f;
    }

    private static AddInfo toAddInfo(Ad ad, AdRepository ads, UserQuery query, AdvertiserRepository advertiserRepository) {
        var score = ads.score(ad, query);
        var advertiser = advertiserRepository.findAdvertiser(ad);
        var bid = advertiserRepository.bid(ad, advertiser);
        return new AddInfo(advertiser, ad, score, bid);
    }

    private static Stream<AdGroup> matchAdGroup(SearchKeyWord key, AdGroupRepository adGroups) {
        return adGroups.find(key).stream();
    }

    private static boolean findKeyWord(SearchKeyWord x, UserQuery query) {
        return x.match(query);
    }


    record AddInfo(Advertiser advertiser, Ad ad, float score, float bid) {
    }

    private static AdRepository ads() {
        return new AdRepository() {
            @Override
            public float score(Ad ad, UserQuery userQuery) {
                return 0;
            }
        };
    }

    private static AdGroupRepository adsGroups() {
        return keyWord -> List.of();
    }

    private static KeyWordRepository keyWords() {
        return List::of;
    }

    private static AdvertiserRepository advertiserRepository() {
        return new AdvertiserRepository() {
            @Override
            public float bid(Ad ad, Advertiser advertiser) {
                return 0;
            }

            @Override
            public Advertiser findAdvertiser(Ad ad) {
                return null;
            }
        };
    }
}
