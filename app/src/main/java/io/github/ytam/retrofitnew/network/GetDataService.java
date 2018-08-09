package io.github.ytam.retrofitnew.network;


import java.util.List;

import io.github.ytam.retrofitnew.model.RetroPhoto;
import io.github.ytam.retrofitnew.model.RetroTodos;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();

    @GET("/todos")
    Call<List<RetroTodos>> getAllTodos();




}
