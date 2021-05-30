/*
 * Copyright (c) 2018 Vinita Jain.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drivexindia.view;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.zetterstrom.com.forecast.ForecastClient;
import android.zetterstrom.com.forecast.models.Forecast;

import com.drivexindia.R;
import com.drivexindia.databinding.ActivityMainBinding;
import com.drivexindia.utils.AppConstants;
import com.drivexindia.viewmodel.DataViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vinita Jain on 8/1/18.
 */
public class MainActivity extends AppCompatActivity {

    private DataViewModel dataViewModel;
    TextView txtZone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = bind();
        initRecyclerView(view);
        AppConstants.context = MainActivity.this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //check for internet connection
        if (AppConstants.isInternetConnected(this))
            getDarkSkyWeatherData();
        else
            Toast.makeText(MainActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dataViewModel.tearDown();
    }

    private View bind() {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        txtZone = findViewById(R.id.txtZone);
        dataViewModel = new DataViewModel();
        binding.setViewModel(dataViewModel);
        return binding.getRoot();
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), 0));
    }

    public void getDarkSkyWeatherData() {
        //set default lat long of San Diego
        ForecastClient.getInstance()
                .getForecast(32.715736, -117.161087, new Callback<Forecast>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(Call<Forecast> forecastCall, Response<Forecast> response) {
                        if (response.isSuccessful()) {
                            Forecast forecast = response.body();
                            txtZone.setText("TIME ZONE : " + forecast.getTimezone());
                            dataViewModel.setUp(forecast);
                        }
                    }

                    @Override
                    public void onFailure(Call<Forecast> forecastCall, Throwable t) {
                        Toast.makeText(getApplicationContext(), "There is some Technical issue..Please check", Toast.LENGTH_LONG).show();
                    }
                });
    }
}
