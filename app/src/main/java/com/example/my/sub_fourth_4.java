package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sub_fourth_4 extends AppCompatActivity {
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_fourth4);
        btn2 = findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sub_fourth_4_1.class);
                startActivity(intent);
            }
        });
    }
    public void imageClick_sub_fourth_4(View view){
        int id = view.getId();
        if(id == R.id.web_back_9){
            Intent intent = new Intent(this, fourth.class);
            startActivity(intent);
        }
    }
}