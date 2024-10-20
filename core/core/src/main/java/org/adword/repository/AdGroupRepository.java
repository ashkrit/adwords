package org.adword.repository;

import org.adword.models.ad.AdGroup;
import org.adword.models.keyword.SearchKeyWord;

import java.util.List;

public interface AdGroupRepository{

    List<AdGroup> find(SearchKeyWord keyWord);

}
