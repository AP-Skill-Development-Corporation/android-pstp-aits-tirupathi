package com.example.retrofitexample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointInterface
{
    /*Call fun-->getThe Data from the Sub URL
    * @GET
    * */
    @GET("dayone/country/IN")
    Call<String> getData();
}
