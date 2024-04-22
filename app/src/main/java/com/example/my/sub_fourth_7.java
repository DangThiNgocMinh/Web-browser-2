package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class sub_fourth_7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_fourth7);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        ImageView choose1 = findViewById(R.id.choose_1);
        ImageView choose2 = findViewById(R.id.choose_2);
        ImageView choose3 = findViewById(R.id.choose_3);
        ImageView choose4 = findViewById(R.id.choose_4);
        choose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("background_image", "bg1"); // Lưu giá trị
                editor.apply(); // Xác nhận thay đổi

                // Chuyển về MainActivity
                Intent intent = new Intent(sub_fourth_7.this, MainActivity.class);
                startActivity(intent);
            }
        });
        choose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("background_image", "bg2"); // Lưu giá trị
                editor.apply(); // Xác nhận thay đổi

                // Chuyển về MainActivity
                Intent intent = new Intent(sub_fourth_7.this, MainActivity.class);
                startActivity(intent);
            }
        });
        choose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("background_image", "bg3"); // Lưu giá trị
                editor.apply(); // Xác nhận thay đổi

                // Chuyển về MainActivity
                Intent intent = new Intent(sub_fourth_7.this, MainActivity.class);
                startActivity(intent);
            }
        });
        choose4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("background_image", "bg4"); // Lưu giá trị
                editor.apply(); // Xác nhận thay đổi

                // Chuyển về MainActivity
                Intent intent = new Intent(sub_fourth_7.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void imageClick_sub_fourth_7(View view){
        int id = view.getId();
        if(id == R.id.web_back_13){
            Intent intent = new Intent(this, fourth.class);
            startActivity(intent);
        }
    }
}