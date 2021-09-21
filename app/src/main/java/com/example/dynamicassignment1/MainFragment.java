package com.example.dynamicassignment1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {

    private List<ResponseDTO> responseDTOList=new ArrayList<>();
    private RecyclerView recyclerView;
    private Button mBtnApi;
    private AdapterClass adapterClass;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setRecyclerData();

    }

    private void setRecyclerData() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterClass=new AdapterClass(responseDTOList);
        recyclerView.setAdapter(adapterClass);
    }

    private void initViews(View view) {
        recyclerView=view.findViewById(R.id.recyclerView);
        mBtnApi=view.findViewById(R.id.apiBtn);

        mBtnApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });

    }

    private void callApi() {
        ApiService apiService=Network.getInstance().create(ApiService.class);
        Call<List<ResponseDTO>> call=apiService.getData();
        call.enqueue(new Callback<List<ResponseDTO>>() {
            @Override
            public void onResponse(Call<List<ResponseDTO>> call, Response<List<ResponseDTO>> response) {
                if(response.body()!=null){
                    responseDTOList=response.body();
                    adapterClass.update(responseDTOList);
                }
            }

            @Override
            public void onFailure(Call<List<ResponseDTO>> call, Throwable t) {
                Toast.makeText(getActivity(),"Not Showing",Toast.LENGTH_SHORT).show();
            }
        });
    }
}