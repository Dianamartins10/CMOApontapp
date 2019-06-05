package com.example.cmoapontapp.Regist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.cmoapontapp.Login.LoginViewModel;
import com.example.cmoapontapp.R;

public class RegistActivity extends AppCompatActivity {

    public Button btnRegist;
    public EditText name;
    public EditText email;
    public EditText password;
    public EditText passwordConfirm;
    private RegistViewModel RegistViewModel=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        RegistViewModel = ViewModelProviders.of(this).get(RegistViewModel.class);

        btnRegist= (Button) findViewById(R.id.btn_Regist);
        name= (EditText) findViewById(R.id.editName);
        email= (EditText) findViewById(R.id.editEmail);
        password= (EditText) findViewById(R.id.editPass);
        passwordConfirm= (EditText) findViewById(R.id.editPassConfirm);

    }


    private void startSignUp(){
        String emailR = email.getText().toString();
        String passwordR = password.getText().toString();
        String passwordConfirmR = passwordConfirm.getText().toString();
        String nameR = name.getText().toString();

        //RegistViewModel.regist(emailR,passwordR);

    }
}


