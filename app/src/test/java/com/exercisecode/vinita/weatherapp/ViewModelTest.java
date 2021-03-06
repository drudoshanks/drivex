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

import android.databinding.Observable;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

public abstract class ViewModelTest<ViewModelT> {

    protected ViewModelT viewModel;
    protected Observable.OnPropertyChangedCallback onPropertyChangedCallback;


    protected final void verifyChanged() {
        verify(onPropertyChangedCallback)
                .onPropertyChanged(any(Observable.class), eq(0));
    }

    protected final void verifyPropertyChanged(int propertyId) {
        verify(onPropertyChangedCallback)
                .onPropertyChanged(any(Observable.class), eq(propertyId));
    }
}