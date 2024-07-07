package com.example.mobileclient;

public class User {
    private String username;
    private String password;
    private String name;
    private String nrp;
    private String jurusan;

    // Constructor, getters and setters

    public User(String username, String password, String name, String nrp, String jurusan) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nrp = nrp;
        this.jurusan = jurusan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
}
