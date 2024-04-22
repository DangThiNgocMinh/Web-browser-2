package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Add_widget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_widget);
    }
    public void imageClick_add(View view) {
        int id = view.getId();

        if (id == R.id.back ) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
    public void imageClick_add_1(View view){
        int id = view.getId();
        Intent intent = new Intent(this, third.class);
        String url = "";
        switch (id){
            case R.id.vk:
                url = "https://vk.company/en/";
                break;
            case R.id.flipkart:
                url = "https://www.flipkart.com/";
                break;
            case R.id.X:
                url = "https://twitter.com";
                break;
            case R.id.reddit:
                url = "https://reddit.com";
                break;
            case R.id.amazon:
                url = "https://amazon.com";
                break;
            case R.id.quora:
                url = "https://www.quora.com/";
                break;
            case R.id.steam:
                url = "https://store.steampowered.com/";
                break;
            case R.id.weather:
                url = "https://weather.com";
                break;
        }
        intent.putExtra("URL", url);
        startActivity(intent);
    }
    public void imageClick_add_widget(View view){
        int id = view.getId();
        if (id == R.id.url_input_add){
            Intent intent = new Intent(this, second.class);
            startActivity(intent);
        }
        if(id == R.id.sport_add){
            Intent intent = new Intent(this, sport_add_widget.class);
            startActivity(intent);
        }
        if (id == R.id.shopping_add){
            Intent intent = new Intent(this, shopping_add_widget.class);
            startActivity(intent);
        }
        if(id == R.id.finace_add){
            Intent intent = new Intent(this, finance_add_widget.class);
            startActivity(intent);
        }
        if(id == R.id.education_add){
            Intent intent = new Intent(this, education_add_widget.class);
            startActivity(intent);
        }
    }
}
