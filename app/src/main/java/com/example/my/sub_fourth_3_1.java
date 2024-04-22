package com.example.my;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class sub_fourth_3_1 extends AppCompatActivity {
    EditText number, date, name, address;
    Button insert, delete, view;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_fourth3_1);

        number = findViewById(R.id.number);
        date = findViewById(R.id.date);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        insert = findViewById(R.id.btnInsert);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnViewData);
        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberTXT = number.getText().toString();
                String dateTXT = date.getText().toString();
                String nameTXT = name.getText().toString();
                String addressTXT = address.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(numberTXT, dateTXT, nameTXT, addressTXT);
                if(checkinsertdata==true)
                    Toast.makeText(sub_fourth_3_1.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(sub_fourth_3_1.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(sub_fourth_3_1.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(sub_fourth_3_1.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(sub_fourth_3_1.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Number :"+res.getString(0)+"\n");
                    buffer.append("Date :"+res.getString(1)+"\n");
                    buffer.append("Name :"+res.getString(2)+"\n");
                    buffer.append("Address:"+res.getString(3)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(sub_fourth_3_1.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
    public void imageClick_sub_fourth_3(View view){
        int id = view.getId();
        if(id == R.id.web_back_8){
            Intent intent = new Intent(this, sub_fourth_3.class);
            startActivity(intent);
        }
    }
}