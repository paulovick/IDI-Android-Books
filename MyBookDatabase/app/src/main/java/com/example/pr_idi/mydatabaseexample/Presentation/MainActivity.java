package com.example.pr_idi.mydatabaseexample.Presentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.pr_idi.mydatabaseexample.Infrastructure.BookData;
import com.example.pr_idi.mydatabaseexample.R;

public class MainActivity extends Activity {

    private BookData bookData;
    private MainListFragment mainListFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bookData = new BookData(this);
        bookData.open();

        mainListFragment = (MainListFragment)getFragmentManager().findFragmentById(R.id.mainListFragment);
        mainListFragment.initialize(this.bookData);
    }

    public void onClick(View view) {
        this.mainListFragment.onClick(view);
    }

    // Life cycle methods. Check whether it is necessary to reimplement them

    @Override
    protected void onResume() {
        bookData.open();
        super.onResume();
    }

    // Life cycle methods. Check whether it is necessary to reimplement them

    @Override
    protected void onPause() {
        bookData.close();
        super.onPause();
    }

}