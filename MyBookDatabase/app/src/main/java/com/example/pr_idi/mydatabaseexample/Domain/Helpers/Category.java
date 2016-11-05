package com.example.pr_idi.mydatabaseexample.Domain.Helpers;

/**
 * Created by pautorrents on 5/11/16.
 */

public enum Category {
    ScienceFiction ("Science Fiction"),
    Satire ("Satire"),
    Drama ("Drama"),
    ActionAndAventure ("Action and Adventure"),
    Romance ("Romance"),
    Mistery ("Mistery"),
    Horror ("Horror"),
    SelfHelp ("Self Help"),
    Health ("Health"),
    Guide ("Guia"),
    Viatges ("Guide"),
    Childrens ("Children's"),
    Religion ("Religion"),
    Science ("Science"),
    History ("History"),
    Math ("Math"),
    Anthology ("Anthology"),
    Poetry ("Poetry"),
    Encyclopedia ("Encyclopedia"),
    Dictionari ("Dictionari"),
    Comic ("Comic"),
    Art ("Art"),
    Cookbook ("Cookbook"),
    Diary ("Diary"),
    Trilogy ("Trilogy"),
    Biography ("Biography"),
    AutoBiography ("AutoBiography"),
    Fantasy ("Fantasy"),
    None ("None");

    private final String name;

    private Category(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        return (otherName != null && this.name.equals(otherName));
    }

    public String toString() {
        return this.name;
    }

    public static Category findCategoryByName(String name) {
        try {
            Category result = Category.valueOf(name);
            return result;
        } catch (Exception ex) {
            return Category.None;
        }
    }
}
