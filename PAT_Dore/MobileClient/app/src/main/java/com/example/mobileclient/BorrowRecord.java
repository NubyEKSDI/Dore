package com.example.mobileclient;

public class BorrowRecord {
    private int user_id;
    private int equipment_id;
    private int quantity;
    private String borrowed_at;
    private String returned_at;

    // Getters and setters

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

    public String getBorrowed_at() {
        return borrowed_at;
    }

    public void setBorrowed_at(String borrowed_at) {
        this.borrowed_at = borrowed_at;
    }

    public String getReturned_at() {
        return returned_at;
    }

    public void setReturned_at(String returned_at) {
        this.returned_at = returned_at;
    }
}
