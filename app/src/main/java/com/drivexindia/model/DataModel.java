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

package com.drivexindia.model;

import android.support.annotation.Nullable;

/**
 * Created by Vinita Jain on 8/1/18.
 */
public class DataModel {
    private String summary,icon,temperatureMin,temperatureMax,sunriseTime,sunsetTime,time, windspeed, humidity;

    public DataModel() {
    }

    @Nullable
    public String getSummary() {
        return summary;
    }

    public void setSummary(@Nullable String summary) {
        this.summary = summary;
    }

    @Nullable
    public String getIcon() {
        return icon;
    }

    public void setIcon(@Nullable String icon) {
        this.icon = icon;
    }

    @Nullable
    public String getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(@Nullable String temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    @Nullable
    public String getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(@Nullable String temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    @Nullable
    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(@Nullable String humidity) {
        this.humidity = humidity;
    }

    @Nullable
    public String getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(@Nullable String sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    @Nullable
    public String getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(@Nullable String sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    @Nullable
    public String getTime() {
        return time;
    }

    public void setTime(@Nullable String time) {
        this.time = time;
    }

    @Nullable
    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed( @Nullable String windspeed) {
        this.windspeed = windspeed;
    }
}
