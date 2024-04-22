package com.example.my;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.speech.RecognizerIntent;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Locale;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class sub_fourth_6 extends AppCompatActivity {
    private static final int REQUEST_CODE_SPEECH_INPUT = 100;
    private Switch mSwitch;
    private RadioButton mRadioButton, radioBtn11, radioBtn12, radioBtn13;
    private RadioGroup mRadioGroup;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editorSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_fourth6);
        mRadioGroup = findViewById(R.id.idgroup);
        radioBtn11 = findViewById(R.id.radioButton11);
        radioBtn12 = findViewById(R.id.radioButton12);
        radioBtn13 = findViewById(R.id.radioButton13);
        mSwitch = findViewById(R.id.switch5);
        mRadioButton = findViewById(R.id.radioButton10);
        sharedPreferences = getSharedPreferences("pref1", 0);

        // Mặc định là không có nút được chọn và switch bật
        int btnSP = sharedPreferences.getInt("btnSP", 0);
        int switchSP = sharedPreferences.getInt("swtSP", 1);
        editorSP = sharedPreferences.edit();

        if (switchSP == 0) {
            mSwitch.setChecked(false);
            mRadioButton.setEnabled(false);
            radioBtn11.setEnabled(false);
            radioBtn12.setEnabled(false);
            radioBtn13.setEnabled(false);
        } else if (switchSP == 1) {
            mSwitch.setChecked(true);
            mRadioButton.setEnabled(true);
            radioBtn11.setEnabled(true);
            radioBtn12.setEnabled(true);
            radioBtn13.setEnabled(true);
        }

        if (btnSP == 1) {
            radioBtn11.setChecked(true);
        } else if (btnSP == 2) {
            radioBtn12.setChecked(true);
        } else if (btnSP == 3) {
            radioBtn13.setChecked(true);
        } else if (btnSP == 4) {
            mRadioButton.setChecked(true);
        }

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Nếu Switch được bật, kích hoạt RadioButton và cho phép tương tác với chúng
                    mRadioButton.setEnabled(true);// Đặt mặc định RadioButton được chọn
                    radioBtn11.setEnabled(true);
                    radioBtn12.setEnabled(true);
                    radioBtn13.setEnabled(true);
                    editorSP.putInt("swtSP", 1);
                } else {
                    // Nếu Switch không được bật, vô hiệu hóa RadioButton và ngăn tương tác với chúng
                    mRadioButton.setEnabled(false);
                    radioBtn11.setEnabled(false);
                    radioBtn12.setEnabled(false);
                    radioBtn13.setEnabled(false);
                    editorSP.putInt("swtSP", 0);
                }
                editorSP.commit();
            }
        });

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton11) {
                    editorSP.putInt("btnSP", 1);
                } else if (checkedId == R.id.radioButton12) {
                    editorSP.putInt("btnSP", 2);
                } else if (checkedId == R.id.radioButton13) {
                    editorSP.putInt("btnSP", 3);
                    startVoiceInput();
                } else if (checkedId == R.id.radioButton10) {
                    editorSP.putInt("btnSP", 4);
                }
                editorSP.commit();
            }
        });

    }
    private void startVoiceInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hãy nói điều gì đó...");

        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void imageClick_sub_fourth_6(View view){
        int id = view.getId();
        if(id == R.id.web_back_12){
            Intent intent = new Intent(this, fourth.class);
            startActivity(intent);
        }
    }
}