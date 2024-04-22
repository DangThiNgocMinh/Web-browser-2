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

public class sub_fourth_4_1 extends AppCompatActivity {

    EditText nation, name, organization, address, city, phone, email;
    Button insert, delete;
    DBHelper_2 DB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_fourth4_1);

        nation = findViewById(R.id.nation);
        name = findViewById(R.id.name);
        organization = findViewById(R.id.organization);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);

        insert = findViewById(R.id.btnInsert);
        delete = findViewById(R.id.btnDelete);
        DB2 = new DBHelper_2(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nationTXT = nation.getText().toString();
                String nameTXT = name.getText().toString();
                String organizationTXT = organization.getText().toString();
                String addressTXT = address.getText().toString();
                String cityTXT = city.getText().toString();
                String phoneTXT = phone.getText().toString();
                String emailTXT = email.getText().toString();

                Boolean checkinsertdata = DB2.insertuserdata(nationTXT, nameTXT, organizationTXT, addressTXT, cityTXT, phoneTXT, emailTXT );
                if(checkinsertdata==true)
                    Toast.makeText(sub_fourth_4_1.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(sub_fourth_4_1.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB2.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(sub_fourth_4_1.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(sub_fourth_4_1.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void imageClick_sub_fourth_4(View view){
        int id = view.getId();
        if(id == R.id.web_back_10){
            Intent intent = new Intent(this, sub_fourth_4.class);
            startActivity(intent);
        }
    }
}