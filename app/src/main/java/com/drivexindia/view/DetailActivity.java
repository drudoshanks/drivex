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
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.drivexindia.R;
import com.drivexindia.model.DataModel;
import com.drivexindia.utils.AppConstants;
import com.thbs.skycons.library.CloudFogView;
import com.thbs.skycons.library.CloudMoonView;
import com.thbs.skycons.library.CloudSnowView;
import com.thbs.skycons.library.CloudSunView;
import com.thbs.skycons.library.CloudThunderView;
import com.thbs.skycons.library.CloudView;
import com.thbs.skycons.library.MoonView;
import com.thbs.skycons.library.SunView;
import com.thbs.skycons.library.WindView;

/**
 * Created by Vinita Jain on 8/1/18.
 */

public class DetailActivity extends AppCompatActivity {

    TextView txtdetailSummary, txtdetailSunrise, txtdetailSunset, txtdetailHumidity, txtdetailWindspeed;
    LinearLayout parentLayout;
    private static final String DATA_HUMIDITY = "Humidity";
    private static final String DATA_SUMMARY = "Summary";
    private static final String DATA_SUNRISE = "Sunrise";
    private static final String DATA_SUNSET = "Sunset";
    private static final String DATA_ICON = "Icon";
    private static final String DATA_WINDSPEED = "Windspeed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetail);
        getExtrasFromIntent();
    }

    /**
     * Intent passed on recyclerView item click
     * @param context  context of item from which intent is called
     * @param datamodel     clicked item data which is binded in model class
     */
    public static Intent fillDetail(Context context, DataModel datamodel) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(DATA_SUMMARY, datamodel.getSummary());
        intent.putExtra(DATA_HUMIDITY, datamodel.getHumidity());
        intent.putExtra(DATA_SUNRISE, datamodel.getSunriseTime());
        intent.putExtra(DATA_SUNSET, datamodel.getSunsetTime());
        intent.putExtra(DATA_WINDSPEED, datamodel.getWindspeed());
        intent.putExtra(DATA_ICON, datamodel.getIcon());
        return intent;
    }

    @SuppressLint("SetTextI18n")
    private void getExtrasFromIntent() {

        txtdetailSummary = findViewById(R.id.txtdetailSummary);
        txtdetailSunrise = findViewById(R.id.txtdetailSunrise);
        txtdetailSunset = findViewById(R.id.txtdetailSunset);
        txtdetailHumidity = findViewById(R.id.txtdetailHumidity);
        txtdetailWindspeed = findViewById(R.id.txtdetailWindspeed);

        txtdetailSummary.setText(getIntent().getStringExtra(DATA_SUMMARY));
        txtdetailSunrise.setText("SUNRISE : " + AppConstants.dateConversion(getIntent().getStringExtra(DATA_SUNRISE), "TIME"));
        txtdetailSunset.setText("SUNSET : " + AppConstants.dateConversion(getIntent().getStringExtra(DATA_SUNSET), "TIME"));
        txtdetailHumidity.setText("HUMIDITY : " + getIntent().getStringExtra(DATA_HUMIDITY));
        txtdetailWindspeed.setText("WINDSPEED : " + getIntent().getStringExtra(DATA_WINDSPEED) + " m/sec");

        parentLayout = findViewById(R.id.parentLayout);
        setIcon(getIntent().getStringExtra(DATA_ICON),parentLayout,DetailActivity.this);
        Log.d("ICON==","ICON+++"+getIntent().getStringExtra(DATA_ICON));
    }

    /**
     * Set icon in RecycleView as well as in Detail Activity View
     *
     * @param strIcon  to check which icon should be shown by calling a library class and inflating it in a layout
     * @param parentLayout      layout in which view should be inflated
     * @param ctx         context
     */
    public static void setIcon(String strIcon, LinearLayout parentLayout, Context ctx){

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        if(strIcon.equalsIgnoreCase("PARTLY_CLOUDY_DAY")){
            //attributres include boolean isStatic,boolean isAnimated, int strokeColor , int backgroundColor
            CloudSunView iconView = new CloudSunView(ctx, true, false, Color.parseColor("#000000"), Color.parseColor("#ffffff"));
            iconView.setLayoutParams(params);
            parentLayout.addView(iconView);
        }else if(strIcon.equalsIgnoreCase("PARTLY_CLOUDY_NIGHT")){
            //attributres include boolean isStatic,boolean isAnimated, int strokeColor , int backgroundColor
            CloudMoonView iconView = new CloudMoonView(ctx, true, false, Color.parseColor("#000000"), Color.parseColor("#ffffff"));
            iconView.setLayoutParams(params);
            parentLayout.addView(iconView);
        }else if(strIcon.equalsIgnoreCase("WIND")){
            //attributres include boolean isStatic,boolean isAnimated, int strokeColor , int backgroundColor
            WindView iconView = new WindView(ctx, true, false, Color.parseColor("#000000"), Color.parseColor("#ffffff"));
            iconView.setLayoutParams(params);
            parentLayout.addView(iconView);
        }else if(strIcon.equalsIgnoreCase("CLOUD")){
            //attributres include boolean isStatic,boolean isAnimated, int strokeColor , int backgroundColor
            CloudView iconView = new CloudView(ctx, true, false, Color.parseColor("#000000"), Color.parseColor("#ffffff"));
            iconView.setLayoutParams(params);
            parentLayout.addView(iconView);
        }else if(strIcon.equalsIgnoreCase("SUNNY")||strIcon.equalsIgnoreCase("CLEAR_SKY")){
            //attributres include boolean isStatic,boolean isAnimated, int strokeColor , int backgroundColor
            SunView iconView = new SunView(ctx, true, false, Color.parseColor("#000000"), Color.parseColor("#ffffff"));
            iconView.setLayoutParams(params);
            parentLayout.addView(iconView);
        }else if(strIcon.equalsIgnoreCase("CLEAR_NIGHT")){
            //attributres include boolean isStatic,boolean isAnimated, int strokeColor , int backgroundColor
            MoonView iconView = new MoonView(ctx, true, false, Color.parseColor("#000000"), Color.parseColor("#ffffff"));
            iconView.setLayoutParams(params);
            parentLayout.addView(iconView);
        }else if(strIcon.equalsIgnoreCase("SNOW")){
            //attributres include boolean isStatic,boolean isAnimated, int strokeColor , int backgroundColor
            CloudSnowView iconView = new CloudSnowView(ctx, true, false, Color.parseColor("#000000"), Color.parseColor("#ffffff"));
            iconView.setLayoutParams(params);
            parentLayout.addView(iconView);
        }else if(strIcon.equalsIgnoreCase("FOG")){
            //attributres include boolean isStatic,boolean isAnimated, int strokeColor , int backgroundColor
            CloudFogView iconView = new CloudFogView(ctx, true, false, Color.parseColor("#000000"), Color.parseColor("#ffffff"));
            iconView.setLayoutParams(params);
            parentLayout.addView(iconView);
        }else if(strIcon.equalsIgnoreCase("THUNDER")){
            //attributres include boolean isStatic,boolean isAnimated, int strokeColor , int backgroundColor
            CloudThunderView iconView = new CloudThunderView(ctx, true, false, Color.parseColor("#000000"), Color.parseColor("#ffffff"));
            iconView.setLayoutParams(params);
            parentLayout.addView(iconView);
        }else{
            //attributres include boolean isStatic,boolean isAnimated, int strokeColor , int backgroundColor
            CloudView iconView = new CloudView(ctx, true, false, Color.parseColor("#000000"), Color.parseColor("#ffffff"));
            iconView.setLayoutParams(params);
            parentLayout.addView(iconView);
        }
    }
}
