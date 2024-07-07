package com.example.mobileclient;

public class BorrowRequest {
    private int user_id;
    private int equipment_id;
    private int quantity;

    // Constructor, getters and setters
    public BorrowRequest(int user_id, int equipment_id, int quantity) {
        this.user_id = user_id;
        this.equipment_id = equipment_id;
        this.quantity = quantity;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
