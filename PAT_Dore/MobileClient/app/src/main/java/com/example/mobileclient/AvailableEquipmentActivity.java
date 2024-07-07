// AvailableEquipmentActivity.java
package com.example.mobileclient;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableEquipmentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EquipmentAdapter adapter;
    private Button backButton;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_equipment);

        recyclerView = findViewById(R.id.recyclerView);
        backButton = findViewById(R.id.backButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiInterface = RetrofitClient.getClient("http://192.168.1.17:8000/").create(ApiInterface.class);

        fetchAvailableEquipment();

        backButton.setOnClickListener(v -> finish());
    }

    private void fetchAvailableEquipment() {
        apiInterface.getAvailableEquipment().enqueue(new Callback<List<Equipment>>() {
            @Override
            public void onResponse(Call<List<Equipment>> call, Response<List<Equipment>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Equipment> equipmentList = response.body();
                    adapter = new EquipmentAdapter(equipmentList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Equipment>> call, Throwable t) {
                // Handle failure
            }
        });
    }
}
