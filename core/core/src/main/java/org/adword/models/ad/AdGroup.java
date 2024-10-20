package org.adword.models.ad;

import org.adword.models.keyword.SearchKeyWord;

import java.util.Set;

public record AdGroup(String id, String name, Set<SearchKeyWord> searchKeyWords, Set<Ad> ads) {
}
