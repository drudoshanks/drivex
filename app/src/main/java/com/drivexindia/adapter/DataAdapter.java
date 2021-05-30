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
package com.drivexindia.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.drivexindia.R;
import com.drivexindia.model.DataModel;
import com.drivexindia.utils.AppConstants;
import com.drivexindia.view.DetailActivity;
import com.drivexindia.viewmodel.DataItemViewModel;
import com.drivexindia.databinding.ItemDataBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinita Jain on 7/26/17.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>{
    private List<DataModel> data;
    private LinearLayout layoutIcon;
    public DataAdapter() {
        this.data = new ArrayList<>();
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,
                new FrameLayout(parent.getContext()), false);
        layoutIcon = itemView.findViewById(R.id.layoutIcon);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataViewHolder holder, final int position) {
        DataModel dataModel = data.get(position);
        holder.setViewModel(new DataItemViewModel(dataModel));
        /* set icon in the list view using Skycon library */
        assert dataModel.getIcon() != null;
        DetailActivity.setIcon(dataModel.getIcon(),layoutIcon, AppConstants.context);
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull DataViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull DataViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<DataModel> data) {
        if (data == null || data.isEmpty()) {
            this.data.clear();
        } else {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

    /* package */ static class DataViewHolder extends RecyclerView.ViewHolder {
        /* package */ ItemDataBinding binding;

        /* package */ DataViewHolder(View itemView) {
            super(itemView);
            bind();
        }

        /* package */ void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        /* package */ void unbind() {
            if (binding != null) {
                binding.unbind();
            }
        }

        /* package */ void setViewModel(DataItemViewModel viewModel) {
            if (binding != null) {
                binding.setViewModel(viewModel);
            }
        }
    }
}
