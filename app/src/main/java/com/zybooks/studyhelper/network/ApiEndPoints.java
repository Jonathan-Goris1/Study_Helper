package com.zybooks.studyhelper.network;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoints {

    @GET("type=subjects")
    Call<List<SubjectDataModel>> getSubjects();
}
