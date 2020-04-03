package com.quyunshuo.mvpdemo.mvp;

import com.quyunshuo.mvpdemo.bean.ComicListInfo;

import java.util.List;

/**
 * @Author: MiYan
 * @Time: 2019/8/26 18:54
 * @Description: 描述： 契约
 */
public interface ContractComic {
    //Model层
    interface Model {
        void requestList(ICallBack iCallBack);
    }

    //View层
    interface View {
        void showList(List<ComicListInfo.EntriesBean> comicListInfos);

        void showLoading();
    }


    //Model层的回掉接口
    interface ICallBack {
        void ok(List<ComicListInfo.EntriesBean> comicListInfos);
    }


}
