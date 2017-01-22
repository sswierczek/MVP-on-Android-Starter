package com.intive.mvponandroidstarter;


import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImagesClient implements ImagesService {

    private final ImagesService service;

    public ImagesClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(" http://www.mocky.io/v2/")
                .build();

        service = retrofit.create(ImagesService.class);
    }

    @Override
    public Call<List<Image>> getImages() {
        return service.getImages();
    }
}
