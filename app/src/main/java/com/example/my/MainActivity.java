package com.example.my;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
public class MainActivity extends AppCompatActivity {

    ImageView facebook;
    ImageView insta;
    ImageView game;
    ImageView booking;
    ImageView business;
    ImageView live;
    ImageView chess;
    ImageView Wiki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        String backgroundValue = sharedPreferences.getString("background_image", "default_bg"); // Sử dụng khóa "background_image"
        RelativeLayout mainLayout = findViewById(R.id.mainlayout);
        if (backgroundValue.equals("bg1")) {
            // Đặt `background` dựa trên giá trị, có thể là một hình ảnh
            mainLayout.setBackgroundResource(R.drawable.bg1); // đặt ảnh nền
        }
        else if (backgroundValue.equals("bg2")){
            mainLayout.setBackgroundResource(R.drawable.bg2);
        }
        else if(backgroundValue.equals("bg3")){
            mainLayout.setBackgroundResource(R.drawable.bg3);
        }
        else if (backgroundValue.equals("bg4")){
            mainLayout.setBackgroundResource(R.drawable.bg4);
        }
        else {
            // Thiết lập giá trị mặc định
            mainLayout.setBackgroundResource(R.drawable.bggg); // đặt ảnh nền mặc định
        }

    }
    public void imageClicked_1(View view) {
        int id = view.getId();
        Intent intent = new Intent(this, third.class);
        String url = "";

        switch (id) {
            case R.id.fb:
                url = "https://facebook.com";
                break;
            case R.id.insta:
                url = "https://instagram.com";
                break;
            case R.id.chess:
                url = "https://chess.com";
                break;
            case R.id.wiki:
                url = "https://wikipedia.com";
                break;
            case R.id.gg:
                url = "https://www.google.com/?hl=vi&authuser=1";
                break;
            case R.id.livefb:
                url = "https://www.livesoccertv.com/";
                break;
            case R.id.game:
                url = "https://www.game.com";
                break;
            case R.id.business:
                url = "https://business.com";
                break;
            case R.id.booking:
                url = "https://booking.com";
                break;
        }

        intent.putExtra("URL", url);
        startActivity(intent);
    }

    public void imageClicked(View view) {
        int id = view.getId();

        // Nếu hình ảnh là google hoặc search_view
        if (id == R.id.search_view || id == R.id.web_search) {
            // Tạo Intent để chuyển sang layout mới (second.xml)
            Intent intent = new Intent(this, second.class);
            startActivity(intent);
        }

        if(id == R.id.web_account){
            Intent intent = new Intent(this, fourth.class);
            startActivity(intent);
        }
        if (id == R.id.add){
            Intent intent = new Intent(this, Add_widget.class);
            startActivity(intent);
        }
    }

}
