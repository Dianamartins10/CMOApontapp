package com.example.cmoapontapp.NewProduct;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmoapontapp.Products.ProductsActivity;
import com.example.cmoapontapp.R;

public class NewProductActivity extends AppCompatActivity {

    public EditText nameProduct;
    public EditText categoryProduct;
    public Button createProduct;
    private com.example.cmoapontapp.NewProduct.NewProductViewModel NewProductViewModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        NewProductViewModel = ViewModelProviders.of(this).get(NewProductViewModel.class);

        NewProductViewModel.livedata.observe(this, new Observer<NewProductViewModel.ResultTypeProduct>() {
            @Override
            public void onChanged(NewProductViewModel.ResultTypeProduct resultTypeProduct) {

                switch(resultTypeProduct){
                    case CHECKBOTH:
                        Toast.makeText(NewProductActivity.this, "Nome e Categoria Obrigatórios!", Toast.LENGTH_LONG)
                                .show();
                        finish();
                        break;

                    case CHECKNAME:
                        Toast.makeText(NewProductActivity.this, "Nome de Produto Necessário!", Toast.LENGTH_LONG)
                                .show();
                        finish();
                        break;

                    case CHECKCATEGORY:
                        Toast.makeText(NewProductActivity.this, "Categoria de Produto Necessário!", Toast.LENGTH_LONG)
                                .show();
                        finish();
                        break;

                    case SUCCESS:
                        startActivity(new Intent(NewProductActivity.this, ProductsActivity.class));
                        finish();
                        break;
                }

            }
        });


        createProduct = findViewById(R.id.btn_NewProduct);
        categoryProduct= findViewById(R.id.editNewProductCategory);
        nameProduct = findViewById(R.id.editNewProductName);


        createProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProduct();
            }
        });

    }


    private void createProduct(){
        String name = nameProduct.getText().toString();
        String category = categoryProduct.getText().toString();
        NewProductViewModel.createProduct(name, category);
    }

}
