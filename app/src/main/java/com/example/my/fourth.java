package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class fourth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        ArrayList<String> lvDataModels = new ArrayList<>();
        lvDataModels.add("Công cụ tìm kiếm");
        lvDataModels.add("Chủ đề");
        lvDataModels.add("Phương thức thanh toán");
        lvDataModels.add("Địa chỉ và các lựa chọn khác");

        // Khởi tạo Adapter cho lv
        ArrayAdapter<String> lvAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lvDataModels);
        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(lvAdapter);

        // Khởi tạo dữ liệu mẫu cho lv2
        ArrayList<String> lv2DataModels = new ArrayList<>();
        lv2DataModels.add("Trang chủ");
        lv2DataModels.add("Lối tắt trên thanh công cụ");

        // Khởi tạo Adapter cho lv2
        ArrayAdapter<String> lv2Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lv2DataModels);
        ListView lv2 = findViewById(R.id.lv2);
        lv2.setAdapter(lv2Adapter);

        // Thêm Listener cho lv
        lv.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = (String) parent.getItemAtPosition(position);
            switch (selectedItem) {
                case "Công cụ tìm kiếm":
                    Intent intent = new Intent(this, sub_fourth.class);
                    startActivity(intent);
                    break;
                case "Chủ đề":
                    intent = new Intent(this, sub_fourth_2.class);
                    startActivity(intent);
                    break;
                case "Phương thức thanh toán":
                    intent = new Intent(this, sub_fourth_3.class);
                    startActivity(intent);
                    break;
                case "Địa chỉ và các lựa chọn khác":
                    intent = new Intent(this, sub_fourth_4.class);
                    startActivity(intent);
                    break;
            }
        });

        // Thêm Listener cho lv2
        lv2.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = (String) parent.getItemAtPosition(position);
            switch (selectedItem) {
                case "Trang chủ":
                    Intent intent = new Intent(this, sub_fourth_5.class);
                    startActivity(intent);
                    break;
                case "Lối tắt trên thanh công cụ":
                    intent = new Intent(this, sub_fourth_6.class);
                    startActivity(intent);
                case "Thay đổi mẫu":
                    intent = new Intent(this, sub_fourth_7.class);
                    startActivity(intent);
            }
        });
    }
    public void imageClick_fourth(View view){
        int id = view.getId();
        if(id == R.id.web_back_5){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}