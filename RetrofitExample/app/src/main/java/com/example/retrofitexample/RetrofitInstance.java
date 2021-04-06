package com.example.retrofitexample;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitInstance {
    /*1.Retrofit
    * 2.URL
   3.return the retrofit clas after inilize*/
    static Retrofit retrofit;
    public static final String URL=
            "https://api.covid19api.com/";

    public static Retrofit getRetrofit(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
