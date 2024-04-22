package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class shopping_add_widget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_add_widget);
    }
    public void imageClick_shop_back(View view){
        int id = view.getId();
        if(id == R.id.back_shop){
            Intent intent = new Intent(this, Add_widget.class);
            startActivity(intent);
        }
    }
    public void imageClick_shopping(View view){
        int id = view.getId();
        Intent intent = new Intent(this, third.class);
        String url = "";
        switch (id){
            case R.id.shopee:
                url = "https://shopee.vn/";
                break;
            case R.id.tiki:
                url = "https://tiki.vn/";
                break;
            case R.id.taobao:
                url = "https://world.taobao.com/";
                break;
            case R.id.lazada:
                url = "https://www.lazada.vn/";
                break;
            case R.id.walmart:
                url = "https://www.walmart.com/";
                break;
            case R.id.ikea:
                url = "https://www.ikea.com/";
                break;
            case R.id.ebay:
                url = "https://www.ebay.com/";
                break;
            case R.id.etsy:
                url = "https://www.etsy.com/";
                break;
        }
        intent.putExtra("URL", url);
        startActivity(intent);
    }

}