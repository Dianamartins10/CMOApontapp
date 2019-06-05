package com.example.cmoapontapp.Login;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    MutableLiveData<Boolean> emailPasswordComplete = new MutableLiveData<>();
    MutableLiveData<FirebaseUser> currentUser = new MutableLiveData<>();

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public LoginViewModel() {
        // Apontapp.INSTANCE.getX()


        mAuth = FirebaseAuth.getInstance();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                if (currentUser != null) {
                    LoginViewModel.this.currentUser.postValue(currentUser);
                }
            }
        };

        mAuth.addAuthStateListener(mAuthListener);
    }

    public void login(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                emailPasswordComplete.postValue(task.isSuccessful());
            }
        });

    }

}