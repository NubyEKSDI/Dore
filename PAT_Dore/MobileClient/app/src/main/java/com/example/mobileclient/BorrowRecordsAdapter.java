package com.example.mobileclient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BorrowRecordsAdapter extends RecyclerView.Adapter<BorrowRecordsAdapter.ViewHolder> {

    private List<BorrowRecord> borrowRecords;

    public BorrowRecordsAdapter(List<BorrowRecord> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_borrow_record, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BorrowRecord record = borrowRecords.get(position);
        holder.userId.setText("User ID: " + record.getUser_id());
        holder.equipmentId.setText("Equipment ID: " + record.getEquipment_id());
        holder.quantity.setText("Quantity: " + record.getQuantity());
        holder.borrowedAt.setText("Borrowed At: " + formatDateTime(record.getBorrowed_at()));
        holder.returnedAt.setText("Returned At: " + formatDateTime(record.getReturned_at()));
    }

    @Override
    public int getItemCount() {
        return borrowRecords.size();
    }

    private String formatDateTime(String dateTime) {
        if (dateTime == null) {
            return "Not returned";
        }
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
            Date date = inputFormat.parse(dateTime);
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
            return outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return dateTime;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userId, equipmentId, quantity, borrowedAt, returnedAt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userId);
            equipmentId = itemView.findViewById(R.id.equipmentId);
            quantity = itemView.findViewById(R.id.quantity);
            borrowedAt = itemView.findViewById(R.id.borrowedAt);
            returnedAt = itemView.findViewById(R.id.returnedAt);
        }
    }
}
