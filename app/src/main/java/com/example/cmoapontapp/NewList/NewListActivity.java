package com.example.cmoapontapp.NewList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.cmoapontapp.Home.HomeActivity;
import com.example.cmoapontapp.R;



public class NewListActivity extends AppCompatActivity {


    public EditText nameList;
    public Button createList;
    private NewListViewModel NewListViewModel = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        NewListViewModel = ViewModelProviders.of(this).get(NewListViewModel.class);

        NewListViewModel.livedata.observe(this, new Observer<NewListViewModel.ResultTypeList>() {
            @Override
            public void onChanged(NewListViewModel.ResultTypeList resultTypeList) {

                switch(resultTypeList){
                    case CHECKNAME:
                        Toast.makeText(NewListActivity.this, "Nome da Lista Obrigatório!", Toast.LENGTH_LONG)
                                .show();
                        break;
                    case SUCCESS:
                        startActivity(new Intent(NewListActivity.this, HomeActivity.class));
                        Toast.makeText(NewListActivity.this, "A sua Lista foi Criada com Sucesso!", Toast.LENGTH_LONG)
                                .show();
                        finish();
                        break;

                }
            }
        });


        createList= (Button) findViewById(R.id.btn_NewList);
        nameList= (EditText) findViewById(R.id.editNewList);

        createList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createList();
            }
        });


    }



    private void createList(){
        String name = nameList.getText().toString();
        NewListViewModel.createList(name);
    }
}
