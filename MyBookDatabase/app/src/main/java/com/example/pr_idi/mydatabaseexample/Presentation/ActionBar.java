package com.example.pr_idi.mydatabaseexample.Presentation;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pr_idi.mydatabaseexample.R;

public class ActionBar extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View result = inflater.inflate(R.layout.action_bar_fragment, container, false);

        Toolbar toolbar = (Toolbar)result.findViewById(R.id.main_toolbar);
        toolbar.setTitle("myBooks");
        ((AppCompatActivity)this.getActivity()).setSupportActionBar(toolbar);

        return result;
    }
}
