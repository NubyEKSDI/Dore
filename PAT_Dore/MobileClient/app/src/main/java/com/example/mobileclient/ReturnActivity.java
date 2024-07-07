// ReturnActivity.java
package com.example.mobileclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReturnActivity extends AppCompatActivity {

    private EditText equipmentIdEditText, quantityEditText;
    private Button submitButton, backButton;
    private int userId;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);

        equipmentIdEditText = findViewById(R.id.equipmentId);
        quantityEditText = findViewById(R.id.quantity);
        submitButton = findViewById(R.id.submitButton);
        backButton = findViewById(R.id.backButton);

        userId = getIntent().getIntExtra("user_id", -1);
        apiInterface = RetrofitClient.getClient("http://192.168.1.17:3000/").create(ApiInterface.class);

        submitButton.setOnClickListener(v -> returnEquipment());
        backButton.setOnClickListener(v -> finish());
    }

    private void returnEquipment() {
        int equipmentId = Integer.parseInt(equipmentIdEditText.getText().toString());
        int quantity = Integer.parseInt(quantityEditText.getText().toString());

        BorrowRequest request = new BorrowRequest(userId, equipmentId, quantity);

        apiInterface.returnEquipment(request).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ReturnActivity.this, "Equipment returned", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ReturnActivity.this, "Failed to return equipment", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(ReturnActivity.this, "Failed to return equipment", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
