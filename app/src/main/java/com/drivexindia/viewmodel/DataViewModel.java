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

package com.drivexindia.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.zetterstrom.com.forecast.models.DataPoint;
import android.zetterstrom.com.forecast.models.Forecast;

import com.drivexindia.BR;
import com.drivexindia.adapter.DataAdapter;
import com.drivexindia.model.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinita Jain on 8/1/18.
 */

public class DataViewModel extends BaseObservable {
    private DataAdapter adapter;
    private List<DataModel> data;

    public DataViewModel() {
        data = new ArrayList<>();
        adapter = new DataAdapter();
    }

    public void setUp(Forecast forecast) {
        // perform set up tasks, such as adding listeners, data population, etc.
        populateData(forecast);
    }

    public void tearDown() {
        // perform tear down tasks, such as removing listeners
        data.clear();
        notifyPropertyChanged(BR.data);
    }

    @Bindable
    public List<DataModel> getData() {
        return this.data;
    }

    @Bindable
    public DataAdapter getAdapter() {
        return this.adapter;
    }

    /**
     * Android Client Wrapper Library by Kevin Zetterstrom used to integrate the Forecast API of Dark SKy into application
     * @param forecast contains response of library
     */
    private void populateData(Forecast forecast) {
        /* populate the data from the source Forecast */
        ArrayList<DataPoint> dailyDataPoints = forecast.getDaily().getDataPoints();
        for (DataPoint dataPoint : dailyDataPoints) {
            DataModel dataModel = new DataModel();
            dataModel.setSummary(dataPoint.getSummary());
            dataModel.setHumidity(dataPoint.getHumidity().toString());
            dataModel.setIcon(dataPoint.getIcon().toString());
            dataModel.setSunriseTime(dataPoint.getSunriseTime().toString());
            dataModel.setSunsetTime(dataPoint.getSunsetTime().toString());
            dataModel.setTemperatureMax(dataPoint.getTemperatureMax().toString());
            dataModel.setTemperatureMin(dataPoint.getTemperatureMin().toString());
            dataModel.setTime(dataPoint.getTime().toString());
            dataModel.setWindspeed(dataPoint.getWindSpeed().toString());
            data.add(dataModel);
        }
        notifyPropertyChanged(BR.data);
    }
}
