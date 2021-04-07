package com.example.covid19reports;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointInterface
{
    @GET("dayone/country/IN")
 //   Call<String> getData();
    Call<ResponseDate> getData();
}
