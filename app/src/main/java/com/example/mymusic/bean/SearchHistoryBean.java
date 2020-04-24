package com.example.mymusic.bean;

import org.litepal.crud.LitePalSupport;

/**
 * Created by SJC on 2020/4/23.
 * Describe：
 */
public class SearchHistoryBean extends LitePalSupport {
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
