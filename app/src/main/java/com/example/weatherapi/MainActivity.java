package com.example.weatherapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.weatherapi.model.Data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView name;
    private TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.txt_name_city);
        description = findViewById(R.id.txt_temperature_current);
        getData();
    }

    private void getData(){
        RetrofitUtil.getApi().getListData("london","b6907d289e10d714a6e88b30761fae22").enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Log.i("rrrrrrrrrrrrr", "onResponse: link " + call.request().toString());
                name.setText(response.body().getName());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }
}
