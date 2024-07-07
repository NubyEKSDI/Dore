// EquipmentAdapter.java
package com.example.mobileclient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EquipmentAdapter extends RecyclerView.Adapter<EquipmentAdapter.ViewHolder> {

    private List<Equipment> equipmentList;

    public EquipmentAdapter(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_equipment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Equipment equipment = equipmentList.get(position);
        holder.idTextView.setText(String.valueOf(equipment.getId()));
        holder.nameTextView.setText(equipment.getName());
        holder.quantityTextView.setText(String.valueOf(equipment.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return equipmentList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView idTextView, nameTextView, quantityTextView;

        public ViewHolder(View view) {
            super(view);
            idTextView = view.findViewById(R.id.equipmentId);
            nameTextView = view.findViewById(R.id.equipmentName);
            quantityTextView = view.findViewById(R.id.equipmentQuantity);
        }
    }
}
