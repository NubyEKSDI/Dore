package com.example.mobileclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileclient.ApiInterface;
import com.example.mobileclient.BorrowRecord;
import com.example.mobileclient.BorrowRecordsAdapter;
import com.example.mobileclient.RetrofitClient;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BorrowRecordsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BorrowRecordsAdapter adapter;
    private Button backButton;
    private int user_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_records);

        recyclerView = findViewById(R.id.recyclerViewBorrowRecords);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        user_id = getIntent().getIntExtra("user_id", -1);

        fetchBorrowRecords(user_id);
    }

    private void fetchBorrowRecords(int user_id) {
        ApiInterface apiInterface = RetrofitClient.getClient("http://192.168.1.17:3000/").create(ApiInterface.class);
        Call<List<BorrowRecord>> call = apiInterface.getBorrowRecords(user_id);

        call.enqueue(new Callback<List<BorrowRecord>>() {
            @Override
            public void onResponse(Call<List<BorrowRecord>> call, Response<List<BorrowRecord>> response) {
                if (response.isSuccessful()) {
                    List<BorrowRecord> borrowRecords = response.body();
                    adapter = new BorrowRecordsAdapter(borrowRecords);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<BorrowRecord>> call, Throwable t) {
                // Handle failure
            }
        });
    }
}
