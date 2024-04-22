package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class education_add_widget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_add_widget);
    }
    public void imageClick_education(View view){
        int id = view.getId();
        Intent intent = new Intent(this, third.class);
        String url = "";
        switch (id){
            case R.id.duo:
                url = "https://www.duolingo.com/welcome?welcomeStep=coursePicker";
                break;
            case R.id.quizlet:
                url = "https://quizlet.com/latest";
                break;
            case R.id.dictionary:
                url = "https://dictionary.cambridge.org/";
                break;
            case R.id.wikihow:
                url = "https://www.wikihow.com/Special:CategoryListing";
                break;
            case R.id.wattpad:
                url = "https://www.wattpad.com/";
                break;
            case R.id.vietjack:
                url = "https://www.vietjack.com/";
                break;
            case R.id.scrib:
                url = "https://fr.scribd.com/";
                break;
            case R.id.elsa:
                url = "https://vn.elsaspeak.com/";
                break;
        }
        intent.putExtra("URL", url);
        startActivity(intent);
    }
    public void imageClick_edu_back(View view){
        int id = view.getId();
        if(id == R.id.back_education){
            Intent intent = new Intent(this, Add_widget.class);
            startActivity(intent);
        }
    }
}