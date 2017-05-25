package com.epicodus.myrestaurants;
import okhttp3.Request;

public class RestaurantService {
    static String apiUrl = "http://138.197.214.133/api/v1/foodtruck";

    public static void findRestaurants(String location){
        Request request= new Request.Builder()
                .url(apiUrl)
                .build();
    }

}

