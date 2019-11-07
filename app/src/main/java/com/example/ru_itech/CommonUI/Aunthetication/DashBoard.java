package com.example.ru_itech.CommonUI.Aunthetication;

import android.os.Bundle;

import com.example.ru_itech.CommonUI.Adapters.DashBoardAdapter;
import com.example.ru_itech.CommonUI.DasboardModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.example.ru_itech.R;

import java.util.List;

public class DashBoard extends AppCompatActivity {

    List<DasboardModel> models;
    DashBoardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
}
