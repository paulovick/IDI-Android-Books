package com.example.pr_idi.mydatabaseexample.Presentation;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.pr_idi.mydatabaseexample.Domain.Entities.Book;
import com.example.pr_idi.mydatabaseexample.Infrastructure.BookData;
import com.example.pr_idi.mydatabaseexample.R;

import java.util.List;
import java.util.Random;

public class MainListFragment extends ListFragment {

    private BookData bookData;

    public void initialize(BookData bookData) {
        this.bookData = bookData;
        List<Book> values = bookData.getAllBooks();

        ArrayAdapter<Book> adapter = new ArrayAdapter<>(this.getActivity(),
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.main_list_fragment, container, false);
    }

    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Book> adapter = (ArrayAdapter<Book>) getListAdapter();
        Book book;
        switch (view.getId()) {
            case R.id.add:
                String[] newBook = new String[] { "Miguel Strogoff", "Jules Verne", "Ulysses", "James Joyce", "Don Quijote", "Miguel de Cervantes", "Metamorphosis", "Kafka" };
                int nextInt = new Random().nextInt(4);
                // save the new book to the database
                book = bookData.createBook(newBook[nextInt*2], newBook[nextInt*2 + 1]);

                // After I get the book data, I add it to the adapter
                adapter.add(book);
                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    book = (Book) getListAdapter().getItem(0);
                    bookData.deleteBook(book);
                    adapter.remove(book);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }
}
