package com.epicodus.myrestaurants.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.epicodus.myrestaurants.adapters.RestaurantListAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.epicodus.myrestaurants.R;
import com.epicodus.myrestaurants.models.Restaurant;
import com.epicodus.myrestaurants.services.RestaurantService;
import java.util.ArrayList;


public class RestaurantsActivity extends AppCompatActivity {
    private RestaurantListAdapter mAdapter;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    public ArrayList<Restaurant> mRestaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        getRestaurants(location);
    }

    private void getRestaurants(String location) {
        final RestaurantService restaurantService = new RestaurantService();
        restaurantService.findRestaurants(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mRestaurants = restaurantService.processResults(response);

                RestaurantsActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mAdapter = new RestaurantListAdapter(getApplicationContext(), mRestaurants);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(RestaurantsActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }

}

