package com.example.cmoapontapp.Regist;

import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistViewModel extends ViewModel {

    private String TAG = "RegistViewModel";

    MutableLiveData<Boolean> registComplete = new MutableLiveData<>();
    private FirebaseAuth mAuth;






    public void regist(String username, String password, String email){

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "createUserWithEmail :success");
                    FirebaseUser user = mAuth.getCurrentUser();
                //    updateUI(user);
                }else{
                    Log.w(TAG, "createUserWithEmail :failure", task.getException());
                 //  Toast.makeText(RegistViewModel.this, "Authentication failed.",Toast.LENGTH_LONG).show();
                 //   updateUI(null);
                }
            }
        });


    }

    public void registUser(String name, String Password, String email){

    }
}
