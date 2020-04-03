package com.quyunshuo.mvpdemo.mvp.model;

import com.google.gson.Gson;
import com.quyunshuo.mvpdemo.JsonTest;
import com.quyunshuo.mvpdemo.bean.ComicListInfo;
import com.quyunshuo.mvpdemo.mvp.ContractComic;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * @Author: MiYan
 * @Time: 2019/8/26 19:10
 * @Description: 描述：Model层的实现类
 */
public class ModelImpl implements ContractComic.Model {
    /**
     * @param iCallBack 回调
     */

    @Override
    public void requestList(final ContractComic.ICallBack iCallBack) {
        Observable.create(new ObservableOnSubscribe<ComicListInfo>() {
            @Override
            public void subscribe(ObservableEmitter<ComicListInfo> e) throws Exception {
                Gson gson = new Gson();
                ComicListInfo comicListInfo = gson.fromJson(JsonTest.home, ComicListInfo.class);
                e.onNext(comicListInfo);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ComicListInfo>() {
            @Override
            public void accept(ComicListInfo comicListInfo) throws Exception {
                iCallBack.ok(comicListInfo.getEntries());
            }
        });
    }
}
