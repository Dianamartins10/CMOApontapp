package com.example.cmoapontapp.Regist;

import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import com.example.cmoapontapp.Login.LoginViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegistViewModel extends ViewModel {

    enum ResultTypeRegist {
        SUCCESS, ERROR, CHECKBOTH, CHECKEMAIL, CHECKPASS , CHECKPASSCONFIRM,  CHECKNAME, COMPARE
    }

    private String TAG = "RegistViewModel";

    MutableLiveData<RegistViewModel.ResultTypeRegist> liveData = new MutableLiveData<>();
    private FirebaseAuth mAuth;




    public void regist(String username, String password, String passwordConfirm, String email){

        if (email.isEmpty() && password.isEmpty()&& username.isEmpty()) {
            liveData.postValue(ResultTypeRegist.CHECKBOTH);
        } else if (password.isEmpty()) {
            liveData.postValue(ResultTypeRegist.CHECKPASS);
        } else if (email.isEmpty()) {
            liveData.postValue(ResultTypeRegist.CHECKEMAIL);
        } else if (username.isEmpty()) {
            liveData.postValue(ResultTypeRegist.CHECKNAME);
        }else if(passwordConfirm.isEmpty()) {
            liveData.postValue(ResultTypeRegist.CHECKPASSCONFIRM);
        }else if(!passwordConfirm.equals(password)){
            liveData.postValue(ResultTypeRegist.COMPARE);
        }else{

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        liveData.postValue(ResultTypeRegist.ERROR);
                    } else {
                        liveData.postValue(ResultTypeRegist.SUCCESS);
                    }
                }
            });


        }



    }

    public void registUser(String name, String Password, String email){

    }
}
