package org.adword.models.keyword;

import org.adword.models.query.UserQuery;

// id , text and match type
public record SearchKeyWord(String id, String text, KeyWordMatchType matchType) {
    public boolean match(UserQuery query) {
        return false;
    }
}
