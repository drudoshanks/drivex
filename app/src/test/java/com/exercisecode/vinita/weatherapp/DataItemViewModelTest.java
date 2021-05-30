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

package com.exercisecode.vinita.weatherapp;

import com.drivexindia.model.DataModel;
import com.drivexindia.viewmodel.DataItemViewModel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *  unit test, for the DataItemViewModel class.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DataItemViewModelTest extends ViewModelTest<DataItemViewModel> {

    private DataModel dataModel;

    @Before
    public void setup(){
        dataModel = mock(DataModel.class);
    }

    @Test
    public void testViewModel() {

        when(dataModel.getSummary()).thenReturn("Summary");
        when(dataModel.getSunsetTime()).thenReturn("Sunset");
        when(dataModel.getSunriseTime()).thenReturn("Sunrise");
        when(dataModel.getHumidity()).thenReturn("Humidity");
        when(dataModel.getIcon()).thenReturn("Icon");
        when(dataModel.getTime()).thenReturn("Time");

        verifyChanged();
        assertEquals("Summary", dataModel.getSummary());
        assertEquals("Sunrise", dataModel.getSunriseTime());
        assertEquals("Sunset",dataModel.getSunsetTime());
        assertEquals("Humidity", dataModel.getHumidity());
        assertEquals("Icon", dataModel.getIcon());
        assertEquals("Time",dataModel.getTime());
    }
}
