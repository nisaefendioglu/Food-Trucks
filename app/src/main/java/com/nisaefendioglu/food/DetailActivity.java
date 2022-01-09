package com.nisaefendioglu.food;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    ImageButton back;
    TextView name,desc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_detail);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });

        name = findViewById(R.id.name);
        desc = findViewById(R.id.desc);

        String nameExtra = getIntent().getStringExtra("name");
        String descExtra = getIntent().getStringExtra("desc");

        name.setText(nameExtra);
        desc.setText(descExtra);



    }
}
