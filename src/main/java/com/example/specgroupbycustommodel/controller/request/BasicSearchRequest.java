package com.example.specgroupbycustommodel.controller.request;

/**
 * Модель для поиска
 */
public class BasicSearchRequest {

    private String search;
    private boolean active = true;

    public BasicSearchRequest() {
    }

    public String getSearch() {
        return search;
    }

    public BasicSearchRequest setSearch(String search) {
        this.search = search;
        return this;
    }

    public boolean getActive() {
        return active;
    }

    public BasicSearchRequest setActive(boolean active) {
        this.active = active;
        return this;
    }
}
