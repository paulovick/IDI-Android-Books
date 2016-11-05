package com.example.pr_idi.mydatabaseexample.Presentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.pr_idi.mydatabaseexample.Infrastructure.BookData;
import com.example.pr_idi.mydatabaseexample.R;

public class MainActivity extends Activity {

    private BookData bookData;

    private MainListFragment mainListFragment;
    private LeftMenuDrawerFragment leftMenuDrawerFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bookData = new BookData(this);
        bookData.open();

        mainListFragment = (MainListFragment)this.getFragmentManager().findFragmentById(R.id.mainListFragment);
        mainListFragment.initialize(this.bookData);

        leftMenuDrawerFragment = (LeftMenuDrawerFragment)this.getFragmentManager().findFragmentById(R.id.leftMenuDrawerFragment);
        leftMenuDrawerFragment.initialize(this.bookData);
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