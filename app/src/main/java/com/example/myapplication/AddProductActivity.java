package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddProductActivity extends AppCompatActivity {
    TextView textView;
    EditText edtname,edtphone,edtemail;
    Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        textView = findViewById(R.id.tvtest);
        edtname = findViewById(R.id.edtname);
        edtphone = findViewById(R.id.edtphone);
        edtemail = findViewById(R.id.edtemail);
        btnadd = findViewById(R.id.btnadd);

        //lấy giá trị truyền
        Intent intent = getIntent();

        String nameAdd = intent.getStringExtra("name");
        boolean isADD = intent.getBooleanExtra("keyAdd",false);

        textView.setText(nameAdd);
        edtname.setText(nameAdd);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = edtname.getText().toString();
                String newPhone = edtphone.getText().toString();
                String newEmail = edtemail.getText().toString();

                Intent intent1 = new Intent();
                intent1.putExtra("newName",newName);

                setResult(RESULT_OK,intent1);
                finish();
            }
        });

    }
}