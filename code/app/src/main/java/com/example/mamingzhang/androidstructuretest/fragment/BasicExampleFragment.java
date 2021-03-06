package com.example.mamingzhang.androidstructuretest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieSubject;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.IHttpResultWithoutCodeMsg;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.ToastProgressSubscriber;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseMovieDisplayFragment;

import java.util.List;

/**
 * Created by mamingzhang on 16/12/16.
 *
 * 用于验证基本的Dagger2、Http封装等逻辑
 */

public class BasicExampleFragment extends BaseMovieDisplayFragment implements IHttpResultWithoutCodeMsg<List<MovieSubject>> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getHttpRequestMethod().getTopMovie(new ToastProgressSubscriber<List<MovieSubject>>(getContext(), this), 0 , 20);
    }

    @Override
    public void onHttpResult(List<MovieSubject> result) {
        refreshSource(result);
    }
}
