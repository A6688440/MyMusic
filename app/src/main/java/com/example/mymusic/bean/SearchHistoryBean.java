package com.example.mymusic.bean;

import org.litepal.crud.LitePalSupport;

/**
 * Created by SJC on 2020/4/23.
 * Describe：
 */
public class SearchHistoryBean extends LitePalSupport {
    private String SearchHistory;

    public SearchHistoryBean() {

    }

    public String getSearchHistory() {
        return SearchHistory;
    }

    public void setSearchHistory(String searchHistory) {
        SearchHistory = searchHistory;
    }
}
