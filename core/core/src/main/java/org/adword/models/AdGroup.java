package org.adword.models;

import org.adword.models.keyword.KeyWord;

import java.util.Set;

public record AdGroup(String id, String name, Set<KeyWord> keyWords, Set<Ad> ads) {
}
