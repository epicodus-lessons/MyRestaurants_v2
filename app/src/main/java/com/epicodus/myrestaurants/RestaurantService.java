package com.epicodus.myrestaurants;
import okhttp3.Request;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;

public class RestaurantService {
    static String apiUrl = "http://138.197.214.133/api/v1/foodtruck";

    public static void findRestaurants(String location, Callback callback){
        Request request= new Request.Builder()
                .url(apiUrl)
                .build();

        OkHttpClient client = new OkHttpClient.Builder().build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

}

