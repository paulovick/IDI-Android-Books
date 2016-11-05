package com.example.pr_idi.mydatabaseexample.Infrastructure;

/**
 * BookData
 * Created by pr_idi on 10/11/16.
 */
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.pr_idi.mydatabaseexample.Domain.Entities.Book;
import com.example.pr_idi.mydatabaseexample.Domain.Helpers.Category;
import com.example.pr_idi.mydatabaseexample.Domain.Helpers.Evaluation;

public class BookData {

    // Database fields
    private SQLiteDatabase database;

    // Helper to manipulate table
    private MySQLiteHelper dbHelper;

    private String[] allColumns = {
            MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_TITLE,
            MySQLiteHelper.COLUMN_AUTHOR,
            MySQLiteHelper.COLUMN_YEAR,
            MySQLiteHelper.COLUMN_PUBLISHER,
            MySQLiteHelper.COLUMN_CATEGORY,
            MySQLiteHelper.COLUMN_PERSONAL_EVALUATION
    };

    public BookData(Context context) {
        dbHelper = new MySQLiteHelper(context);
        // STUB
        this.open();
        this.database.delete(MySQLiteHelper.TABLE_BOOKS, null, null);
        this.close();
        // END STUB
    }

    public void open() throws SQLException {
        this.database = this.dbHelper.getWritableDatabase();
    }

    public void close() {
        this.dbHelper.close();
    }

    public Book createBook(String title, String author) {
        ContentValues values = new ContentValues();
        Log.d("Creating", "Creating " + title + " " + author);

        // Add data: Note that this method only provides title and author
        // Must modify the method to add the full data
        values.put(MySQLiteHelper.COLUMN_TITLE, title);
        values.put(MySQLiteHelper.COLUMN_AUTHOR, author);

        // Invented data
        values.put(MySQLiteHelper.COLUMN_PUBLISHER, "Do not know");
        values.put(MySQLiteHelper.COLUMN_YEAR, 2030);
        values.put(MySQLiteHelper.COLUMN_CATEGORY, Category.Fantasy.toString());
        values.put(MySQLiteHelper.COLUMN_PERSONAL_EVALUATION, Evaluation.Regular.toString());

        // Actual insertion of the data using the values variable
        long insertId = this.database.insert(MySQLiteHelper.TABLE_BOOKS, null,
                values);

        // Main activity calls this procedure to create a new book
        // and uses the result to update the listview.
        // Therefore, we need to get the data from the database
        // (you can use this as a query example)
        // to feed the view.

        Cursor cursor = this.database.query(MySQLiteHelper.TABLE_BOOKS,
                this.allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Book newBook = cursorToBook(cursor);

        // Do not forget to close the cursor
        cursor.close();

        // Return the book
        return newBook;
    }

    public void deleteBook(Book book) {
        long id = book.getId();
        System.out.println("Book deleted with id: " + id);
        this.database.delete(MySQLiteHelper.TABLE_BOOKS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        Cursor cursor = this.database.query(MySQLiteHelper.TABLE_BOOKS,
                this.allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Book book = cursorToBook(cursor);
            books.add(book);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();

        // STUB
        if (books.size() == 0) {
            this.createBook("Harry Potter and Deathly Hallows", "J. K. Rowling");
            this.createBook("The godfather", "Mario Puzzo");
            this.createBook("The kid with the rayas pyjama", "Anonymus");
            this.createBook("Hamlet", "William Shakespeare");
            return this.getAllBooks();
        }
        // END STUB

        return books;
    }

    private Book cursorToBook(Cursor cursor) {
        Book book = new Book();
        book.setId(cursor.getLong(0));
        book.setTitle(cursor.getString(1));
        book.setAuthor(cursor.getString(2));
        book.setYear(cursor.getInt(3));
        book.setPublisher(cursor.getString(4));
        book.setCategory(Category.findByName(cursor.getString(5)));
        book.setPersonalEvaluation(Evaluation.findByName(cursor.getString(6)));
        return book;
    }
}