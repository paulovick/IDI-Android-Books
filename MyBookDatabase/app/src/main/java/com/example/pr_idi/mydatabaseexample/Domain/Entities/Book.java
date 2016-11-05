package com.example.pr_idi.mydatabaseexample.Domain.Entities;

import com.example.pr_idi.mydatabaseexample.Domain.Helpers.Category;

/**
 * Book
 * Created by pr_idi on 10/11/16.
 */
public class Book {

    // Basic book data manipulation class
    // Contains basic information on the book

    private long id;
    private String title;
    private String author;
    private int year;
    private String publisher;
    private Category category;
    private String personal_evaluation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title= title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year= year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher= publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPersonalEvaluation() {
        return personal_evaluation;
    }

    public void setPersonalEvaluation(String personal_evaluation) {
        this.personal_evaluation = personal_evaluation;
    }

    // Will be used by the ArrayAdapter in the ListView
    // Note that it only produces the title and the author
    // Extra information should be created by modifying this
    // method or by adding the methods required
    @Override
    public String toString() {
        return String.format("%s - %s", title, author);
    }
}