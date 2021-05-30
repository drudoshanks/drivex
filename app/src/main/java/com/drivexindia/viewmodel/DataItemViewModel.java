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
import android.text.TextUtils;
import android.view.View;
import com.drivexindia.model.DataModel;
import com.drivexindia.utils.AppConstants;
import com.drivexindia.view.DetailActivity;

/**
 * Created by Vinita Jain on 8/1/18.
 */

public class DataItemViewModel extends BaseObservable {
    private DataModel dataModel;

    public DataItemViewModel(DataModel dataModel) {
        //this.context = context;
        this.dataModel = dataModel;
    }

    @Bindable
    public String getSummary() {
        return !TextUtils.isEmpty(dataModel.getSummary()) ? dataModel.getSummary() : "";
    }

    @Bindable
    public String getTemperatureMin(){
        return "Min Temperature "+dataModel.getTemperatureMin();
    }

    @Bindable
    public String getTemperatureMax(){
        return "Max Temperature "+dataModel.getTemperatureMax();
    }

    @Bindable
    public String getTime(){
        return AppConstants.dateConversion(dataModel.getTime(),"DAY_DATE");
    }

    public void onItemClick(View v){
       v.getContext().startActivity(DetailActivity.fillDetail(v.getContext(), dataModel));
    }
}
