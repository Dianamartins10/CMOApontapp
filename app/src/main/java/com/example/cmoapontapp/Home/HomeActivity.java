package com.example.cmoapontapp.Home;

import android.content.Intent;
import android.os.Bundle;
import com.example.cmoapontapp.NewList.NewListActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import com.example.cmoapontapp.R;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



     /*   recyclerView =  findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new Adapter(myDataset);
        recyclerView.setAdapter(mAdapter);*/


        FloatingActionButton fab = findViewById(R.id.fab);
        //
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newScreen = new Intent(HomeActivity.this, NewListActivity.class);
                startActivity(newScreen);
            }
        });

    }

}
