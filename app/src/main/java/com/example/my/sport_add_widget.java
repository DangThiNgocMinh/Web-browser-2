package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sport_add_widget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_add_widget);
    }
    public void imageClick_sport_add(View view){
        int id = view.getId();
        if(id == R.id.back_sport){
            Intent intent = new Intent(this, Add_widget.class);
            startActivity(intent);
        }
    }
    public void imageClick_sport(View view){
        int id = view.getId();
        Intent intent = new Intent(this, third.class);
        String url = "";
        switch (id){
            case R.id.espn:
                url = "https://www.espn.com/esports/";
                break;
            case R.id.euro:
                url = "https://www.eurosport.com/";
                break;
            case R.id.nfl:
                url = "https://www.nfl.com/";
                break;
            case R.id.sport247:
                url = "https://247sport.vn/";
                break;
            case R.id.si:
                url = "https://www.si.com/";
                break;
            case R.id.skeedaa:
                url = "https://www.sportskeeda.com/";
                break;
            case R.id.dakar:
                url = "https://www.dakar.com/en/";
                break;
            case R.id.cbs:
                url = "https://www.cbssports.com/nfl/";
                break;
        }
        intent.putExtra("URL", url);
        startActivity(intent);
    }

}