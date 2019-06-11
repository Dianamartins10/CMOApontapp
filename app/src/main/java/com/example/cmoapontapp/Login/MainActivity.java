package com.example.cmoapontapp.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmoapontapp.AccountActivity;
import com.example.cmoapontapp.R;
import com.example.cmoapontapp.Regist.RegistActivity;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private Button register;
    private LoginViewModel loginViewModel = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        //*******************************************************************************************
        loginViewModel.liveData.observe(this, new Observer<LoginViewModel.ResultType>() {
            @Override
            public void onChanged(LoginViewModel.ResultType resultType) {

                switch (resultType) {
                    case SUCCESS:
                        startActivity(new Intent(MainActivity.this, AccountActivity.class));
                        finish();
                        break;
                    case CHECKEMAIL:
                        Toast.makeText(MainActivity.this, "Email Obrigatório!", Toast.LENGTH_LONG)
                                .show();
                        break;
                    case CHECKPASS:
                        Toast.makeText(MainActivity.this, "Password Obrigatória", Toast.LENGTH_LONG)
                                .show();
                        break;
                    case CHECKBOTH:
                        Toast.makeText(MainActivity.this, "Credênciais Necessárias!", Toast.LENGTH_LONG)
                                .show();
                    case ERROR:
                        Toast.makeText(MainActivity.this, "Combinação de Email/Password Errada!", Toast.LENGTH_LONG)
                                .show();
                        break;
                }
            }

        });
        //*******************************************************************************************
        loginViewModel.currentUser.observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser user) {
                startActivity(new Intent(MainActivity.this, AccountActivity.class));
            }
        });

        email = (EditText) findViewById(R.id.editemail);
        password = (EditText) findViewById(R.id.editpwd);
        login = (Button) findViewById(R.id.btn_Login);
        register = (Button) findViewById(R.id.btn_Registar);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startSignIn();

            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newScreen = new Intent(MainActivity.this, RegistActivity.class);
                startActivity(newScreen);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }





    private void startSignIn() {
        String emailN = email.getText().toString();
        String passwordN = password.getText().toString();

        loginViewModel.login(emailN, passwordN);


    }

}
