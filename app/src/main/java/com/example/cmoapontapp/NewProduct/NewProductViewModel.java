package com.example.cmoapontapp.NewProduct;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cmoapontapp.Models.List;
import com.example.cmoapontapp.Models.Product;
import com.example.cmoapontapp.NewList.NewListViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class NewProductViewModel extends ViewModel {

    enum ResultTypeProduct{
        SUCCESS, CHECKNAME, CHECKCATEGORY, CHECKBOTH
    }

    private FirebaseAuth mAuth;
    MutableLiveData<NewProductViewModel.ResultTypeProduct> livedata = new MutableLiveData<>();
    private FirebaseFirestore db;




    public void createProduct (final String name, final String category){
        mAuth= FirebaseAuth.getInstance();


        if(name.isEmpty() && category.isEmpty()){
            livedata.postValue(ResultTypeProduct.CHECKBOTH);
        }else if (name.isEmpty()) {
            livedata.postValue(ResultTypeProduct.CHECKNAME);
        }else if (category.isEmpty()) {
            livedata.postValue(ResultTypeProduct.CHECKCATEGORY);
        }else{
            livedata.postValue(ResultTypeProduct.SUCCESS);

            mAuth = FirebaseAuth.getInstance();
            db = FirebaseFirestore.getInstance();
            DocumentReference newProduct = db.collection("productsUser").document();
            String user_id = mAuth.getCurrentUser().getUid();

            Product product = new Product(user_id, name, category);

            newProduct.set(product);
        }

    }
}


