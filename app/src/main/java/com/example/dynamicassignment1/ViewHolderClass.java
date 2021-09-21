package com.example.dynamicassignment1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ViewHolderClass extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView mTvSubTitle;
    private TextView mTvTitle;

    public ViewHolderClass(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        imageView=itemView.findViewById(R.id.imageView);
        mTvSubTitle=itemView.findViewById(R.id.textView1);
        mTvTitle=itemView.findViewById(R.id.textView2);
    }

    public void setData(ResponseDTO responseDTO){
        mTvTitle.setText(responseDTO.getTitle());
        mTvSubTitle.setText(responseDTO.getSubTitle());
        Glide.with(imageView).load(responseDTO.getImage()).into(imageView);
    }
}
