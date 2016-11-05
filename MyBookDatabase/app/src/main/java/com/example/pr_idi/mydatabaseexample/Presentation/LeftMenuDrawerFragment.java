package com.example.pr_idi.mydatabaseexample.Presentation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pr_idi.mydatabaseexample.Infrastructure.BookData;
import com.example.pr_idi.mydatabaseexample.R;

public class LeftMenuDrawerFragment extends Fragment {

    private BookData bookData;

    public void initialize(BookData bookData) {
        this.bookData = bookData;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        return inflater.inflate(R.layout.left_menu_drawer_fragment, container, false);
    }
}
