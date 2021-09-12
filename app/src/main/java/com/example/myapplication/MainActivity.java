package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv1;
    List<Product> products;
    Product product, product01, product02, product03, product04, product05;
    AdapterProduct adapterProduct;
    int numberPosition = 0;
    View btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = findViewById(R.id.lv1);
        btnadd = findViewById(R.id.btnadd);
        products = new ArrayList<>();

        product = new Product("android 44", "01234567", "android@gmail.com", true);

        product01 = new Product("son", "0331238912", "son@gamil.com", false);

        product02 = new Product("tien", "0331238912", "tien@gamil.com", true);

        product03 = new Product("dat", "09312389", "dat@gamil.com", false);

        product04 = new Product("trung", "0473847577", "trung@gamil.com", true);

        product05 = new Product("nam", "0645645785", "nam@gamil.com", true);

        products.add(product);
        products.add(product01);
        products.add(product02);
        products.add(product03);
        products.add(product04);
        products.add(product05);

        adapterProduct = new AdapterProduct(products);
        lv1.setAdapter(adapterProduct);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product = products.get(i);

                String name = product.getName();
                String phone = product.getNumberphone();
                Toast.makeText(getBaseContext(), name, Toast.LENGTH_LONG).show();
                Toast.makeText(getBaseContext(), phone, Toast.LENGTH_LONG).show();

                //chuyển sang 1 activivy khác
                Intent intent = new Intent(getBaseContext(),AddProductActivity.class);
                intent.putExtra("name",name);
//                startActivity(intent);


                //chuyển sang 1 activity khác nx chờ kết quả trả về


            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),AddProductActivity.class);
            //    intent.putExtra("KeyAdd",true);
                startActivityForResult(intent,115);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String newName = data.getStringExtra("newName");
        String newPhone = data.getStringExtra("newPhone");
        String newEmail = data.getStringExtra("newEmail");

        if (requestCode == 113){
            Product product = products.get(numberPosition);
            products.set(numberPosition, new Product(newName,
                    product.numberphone,
                    product.email,
                    product.isAvatarUser()));
        }else if(requestCode == 115){
            products.add(new Product(newName,newPhone,newEmail,true));
            adapterProduct.notifyDataSetChanged();
        }


    }
}