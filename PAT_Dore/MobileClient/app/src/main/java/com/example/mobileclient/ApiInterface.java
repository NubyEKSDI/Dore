// ApiInterface.java
package com.example.mobileclient;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("/signup")
    Call<Void> signup(@Body User user);

    @POST("/signup_admin")
    Call<Void> signupAdmin(@Body User user);

    @POST("/login")
    Call<UserResponse> login(@Body LoginRequest loginRequest);

    @POST("/borrow")
    Call<Void> borrow(@Body BorrowRequest request);

    @POST("/return")
    Call<Void> returnEquipment(@Body BorrowRequest request);

    @GET("/available_equipment")
    Call<List<Equipment>> getAvailableEquipment();

    @GET("/check_borrow_records")
    Call<List<BorrowRecord>> getBorrowRecords(@Query("user_id") int user_id);
}
