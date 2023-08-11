package com.android.expandablelistexample;

import java.io.Serializable;
import java.util.List;

public class ModelNewList implements Serializable {
        String titleGods;

    public ModelNewList(String titleGods) {
        this.titleGods = titleGods;
    }

    public String getTitleGods() {
        return titleGods;
    }
}
