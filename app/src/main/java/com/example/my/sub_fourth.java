package com.example.my;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class sub_fourth extends AppCompatActivity {
    RadioGroup idgroup;
    RadioButton radioButton3, radioButton4, radioButton5, radioButton6, radioButton7;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_fourth);
        sharedPreferences = getSharedPreferences("pref",0);
        int searchSP = sharedPreferences.getInt("searchSP", 6);
        editor = sharedPreferences.edit();
        idgroup = findViewById(R.id.idgroup);
        radioButton3 =findViewById(R.id.radioButton3);
        radioButton4 =findViewById(R.id.radioButton4);
        radioButton5 =findViewById(R.id.radioButton5);
        radioButton6 =findViewById(R.id.radioButton6);
        radioButton7 =findViewById(R.id.radioButton7);

        switch(searchSP){
            case 4:
                radioButton3.setChecked(true);
                break;
            case 3:
                radioButton4.setChecked(true);
                break;
            case 2:
                radioButton5.setChecked(true);
                break;
            case 1:
                radioButton6.setChecked(true);
                break;
            case 0:
                radioButton7.setChecked(true);
                break;

        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        idgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton3){
                    editor.putInt("search",4);
                }else if(checkedId == R.id.radioButton4){
                    editor.putInt("search", 3);
                }
                else if(checkedId == R.id.radioButton5){
                    editor.putInt("search", 2);
                }
                else if(checkedId == R.id.radioButton6){
                    editor.putInt("search", 1);
                }
                else if(checkedId == R.id.radioButton7){
                    editor.putInt("search", 0);
                }
                editor.commit();
            }
        }) ;
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Lưu trạng thái của RadioButton được chọn vào SharedPreferences khi Activity bị tạm dừng
        editor.putInt("searchSP", sharedPreferences.getInt("search", 6));
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Khôi phục trạng thái của RadioButton khi Activity tiếp tục hoạt động
        int searchSP = sharedPreferences.getInt("searchSP", 6);
        switch (searchSP) {
            case 4:
                radioButton3.setChecked(true);
                break;
            case 3:
                radioButton4.setChecked(true);
                break;
            case 2:
                radioButton5.setChecked(true);
                break;
            case 1:
                radioButton6.setChecked(true);
                break;
            case 0:
                radioButton7.setChecked(true);
                break;
            default:
                break;
        }
    }
    public void imageOnclick_sub_fourth(View view){
        int id = view.getId();
        if(id == R.id.web_back_4){
            Intent intent = new Intent(this, fourth.class);
            startActivity(intent);
        }
    }
}