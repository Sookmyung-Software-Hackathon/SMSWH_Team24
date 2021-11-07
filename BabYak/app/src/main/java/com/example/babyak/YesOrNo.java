package com.example.babyak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class YesOrNo extends AppCompatActivity {
    ImageButton btn_yes;
    ImageButton btn_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_yes_or_no);

        btn_yes = (ImageButton) findViewById(R.id.btn_yes);
        btn_no = (ImageButton) findViewById(R.id.btn_no);

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "밥약 성공!!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "밥약 실패...", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}