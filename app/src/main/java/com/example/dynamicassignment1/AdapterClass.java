package com.example.dynamicassignment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<ViewHolderClass> {

    private List<ResponseDTO> responseDTOList=new ArrayList<>();

    public AdapterClass(List<ResponseDTO> responseDTOList) {
        this.responseDTOList = responseDTOList;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        ResponseDTO data=responseDTOList.get(position);
        holder.setData(data);
    }

    @Override
    public int getItemCount() {
        return responseDTOList.size();
    }

    public void update(List<ResponseDTO> responseDTOList) {
        this.responseDTOList=responseDTOList;
        notifyDataSetChanged();
    }
}
