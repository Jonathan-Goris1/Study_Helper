package com.zybooks.studyhelper.network;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    public static final String TAG = "Repository";

    ApiEndPoints apiService = RetrofitBuilder.getRetrofitInstance().create(ApiEndPoints.class);

    Call<List<SubjectDataModel>> response = apiService.getSubjects();

    public void getResponse() {
        response.enqueue(new Callback<List<SubjectDataModel>>() {
            @Override
            public void onResponse(Call<List<SubjectDataModel>> call, Response<List<SubjectDataModel>> response) {
                if (response.isSuccessful()) {
                    response.body();
                }
            }

            @Override
            public void onFailure(Call<List<SubjectDataModel>> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t);

            }
        });
    }
}
