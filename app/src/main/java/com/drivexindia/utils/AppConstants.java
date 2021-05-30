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

package com.drivexindia.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Vinita Jain on 8/1/18.
 */

public class AppConstants {

    public static Context context;

    /**
     * Check the internet connectivity in the phone
     * @param context :  to get active network info
     */
    public static boolean isInternetConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI || activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE);
    }

    /* convert and format TimeStamp from GMT to PST */
    @SuppressLint("SimpleDateFormat")
    public static String dateConversion(String strDateTime, String strType){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat( "EEE MMM dd HH:mm:ss zzz yyyy" );
        format.setTimeZone( TimeZone.getTimeZone( "PST" ) );
        try {
            if(!strDateTime.equals( "" )){
                Date date = format.parse( strDateTime );

                switch (strType) {
                    case "DATE":
                        return new SimpleDateFormat("MMM dd, yyyy").format(date);
                    case "TIME":
                        return new SimpleDateFormat("H:mm:ss aa").format(date);
                    case "DAY_DATE":
                        return new SimpleDateFormat("E MMM dd, yyyy").format(date);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDateTime;
    }

}
