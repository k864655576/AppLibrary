package com.kwz.applibrary;


import com.kang.library.http.HttpResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface UserApi {
    @POST(HttpClient.USER_SYSTEM)
    Observable<HttpResponse> system(@QueryMap Map<String, Object> map);
}
