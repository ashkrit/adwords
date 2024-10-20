package org.adword.repository;

import org.adword.models.keyword.SearchKeyWord;

import java.util.List;

public interface KeyWordRepository {

    List<SearchKeyWord> findAll();

}
