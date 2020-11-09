package com.example.backgrounddataupdater.util;

//http://blog.mikeclassic.ca/post/android-populating-spinner-with-strings-and-id

public class StringWithTag {

    public String string;
    public Object tag;

    public StringWithTag(String string, Object tag) {
        this.string = string;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return string;
    }
}
