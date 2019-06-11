package com.example.cmoapontapp.Regist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmoapontapp.AccountActivity;
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

        RegistViewModel.liveData.observe(this, new Observer<RegistViewModel.ResultTypeRegist>() {
            @Override
            public void onChanged(RegistViewModel.ResultTypeRegist resultTypeRegist) {

                switch (resultTypeRegist) {
                    case SUCCESS:
                        startActivity(new Intent(RegistActivity.this, AccountActivity.class));
                        finish();
                        break;
                    case CHECKNAME:
                        Toast.makeText(RegistActivity.this, "Nome Obrigatório!", Toast.LENGTH_LONG)
                                .show();
                    case CHECKEMAIL:
                        Toast.makeText(RegistActivity.this, "Email Obrigatório!", Toast.LENGTH_LONG)
                                .show();
                        break;
                    case CHECKPASS:
                        Toast.makeText(RegistActivity.this, "Password Obrigatória!", Toast.LENGTH_LONG)
                                .show();
                        break;
                    case CHECKPASSCONFIRM:
                        Toast.makeText(RegistActivity.this, "As Passwords Não Coincidem!", Toast.LENGTH_LONG)
                                .show();
                    case CHECKBOTH:
                        Toast.makeText(RegistActivity.this, "Todos os campos são de preenchimento obrigatório!", Toast.LENGTH_LONG)
                                .show();
                }

            }
        });



        btnRegist= (Button) findViewById(R.id.btn_Regist);
        name= (EditText) findViewById(R.id.editName);
        email= (EditText) findViewById(R.id.editEmail);
        password= (EditText) findViewById(R.id.editPass);
        passwordConfirm= (EditText) findViewById(R.id.editPassConfirm);

        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignUp();
            }
        });

    }




    private void startSignUp(){
        String emailR = email.getText().toString();
        String passwordR = password.getText().toString();
        String passwordConfirmR = passwordConfirm.getText().toString();
        String nameR = name.getText().toString();

        RegistViewModel.regist(nameR,passwordR,passwordConfirmR,emailR );

    }
}


