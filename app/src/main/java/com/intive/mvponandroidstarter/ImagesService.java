package com.intive.mvponandroidstarter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Full URL of mocked data is http://www.mocky.io/v2/58852fe60f00000a16ff6516
 * <p>
 * Structure:
 * <p>
 * [
 * {"title" : "Img 1",
 * "imageUrl" : "https://placehold.it/1024/ffffff?text=img1"},
 * {"title" : "Img 2",
 * "imageUrl" : "https://placehold.it/1024/ff0000?text=img2"},
 * {"title" : "Img 3",
 * "imageUrl" : "https://placehold.it/1024/00ff00?text=img3"},
 * {"title" : "Img 4",
 * "imageUrl" : "https://placehold.it/1024/0000ff?text=img4"},
 * {"title" : "Img 5",
 * "imageUrl" : "https://placehold.it/1024/ff00ff?text=img5"},
 * {"title" : "Img 6",
 * "imageUrl" : "https://placehold.it/1024/ffff00?text=img6"},
 * {"title" : "Img 7",
 * "imageUrl" : "https://placehold.it/1024/00ffff?text=img7"},
 * {"title" : "Img 8",
 * "imageUrl" : "https://placehold.it/1024/ffAA22?text=img8"},
 * {"title" : "Img 9",
 * "imageUrl" : "https://placehold.it/1024/5555DD?text=img9"},
 * {"title" : "Img 10",
 * "imageUrl" : "https://placehold.it/1024/1111BB?text=img10"}
 * ]
 */

interface ImagesService {

    @GET("58852fe60f00000a16ff6516")
    Call<List<Image>> getImages();
}
