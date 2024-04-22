package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class finance_add_widget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_add_widget);
    }
    public void imageClick_finance_back(View view){
        int id = view.getId();
        if(id == R.id.back_finance){
            Intent intent = new Intent(this, Add_widget.class);
            startActivity(intent);
        }
    }
    public void imageClick_finance(View view){
        int id = view.getId();
        Intent intent = new Intent(this, third.class);
        String url = "";
        switch (id){
            case R.id.paypal:
                url = "https://www.paypal.com/vn/home";
                break;
            case R.id.zillow:
                url = "https://www.zillow.com/";
                break;
            case R.id.latoken:
                url = "https://latoken.com/";
                break;
            case R.id.okx:
                url = "https://www.okx.com/vi";
                break;
            case R.id.plus500:
                url = "https://www.plus500.com/en/";
                break;
            case R.id.coinmarket:
                url = "https://coinmarketcap.com/vi/";
                break;
            case R.id.xmza:
                url = "https://www.xmza.com/";
                break;
            case R.id.kotak:
                url = "https://www.kotak.com/en/home.html";
                break;
        }
        intent.putExtra("URL", url);
        startActivity(intent);
    }

}