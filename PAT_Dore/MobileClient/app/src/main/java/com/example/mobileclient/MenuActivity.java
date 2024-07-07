// MenuActivity.java
package com.example.mobileclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private Button borrowButton, returnButton, checkAvailableButton, logoutButton, recordButton;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        userId = getIntent().getIntExtra("user_id", -1);

        borrowButton = findViewById(R.id.borrowButton);
        returnButton = findViewById(R.id.returnButton);
        checkAvailableButton = findViewById(R.id.checkAvailableButton);
        logoutButton = findViewById(R.id.logoutButton);
        recordButton = findViewById(R.id.borrowRecordButton);

        borrowButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, BorrowActivity.class);
            intent.putExtra("user_id", userId);
            startActivity(intent);
        });

        returnButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ReturnActivity.class);
            intent.putExtra("user_id", userId);
            startActivity(intent);
        });

        checkAvailableButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, AvailableEquipmentActivity.class);
            startActivity(intent);
        });

        recordButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, BorrowRecordsActivity.class);
            intent.putExtra("user_id", userId);
            startActivity(intent);
        });

        logoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });


    }
}

