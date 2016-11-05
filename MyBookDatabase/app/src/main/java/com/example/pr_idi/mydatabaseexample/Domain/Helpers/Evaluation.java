package com.example.pr_idi.mydatabaseexample.Domain.Helpers;

/**
 * Created by pautorrents on 5/11/16.
 */

public enum Evaluation {
    VeryBad ("Very bad"),
    Bad ("Bad"),
    Regular ("Regular"),
    Good ("Good"),
    VeryGood ("Very good");

    private final String name;

    private Evaluation(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        return (otherName != null && this.name.equals(otherName));
    }

    public String toString() {
        return this.name;
    }

    public static Evaluation findByName(String name) {
        try {
            Evaluation result = Evaluation.valueOf(name);
            return result;
        } catch (Exception ex) {
            return Evaluation.Regular;
        }
    }
}
