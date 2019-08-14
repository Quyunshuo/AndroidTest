package com.quyunshuo.brvahrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.quyunshuo.brvahrecyclerview.adapter.HomeAdapter;
import com.quyunshuo.brvahrecyclerview.data.HomeItem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        //千万不要忘记设置LayoutManager 本activity已经在布局文件中设置
        mRecyclerView = findViewById(R.id.main_recycler);
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void initData() {
        HomeAdapter homeAdapter = new HomeAdapter(R.layout.home_item_view, getHomeItemData());
        //在加载时打开动画
        homeAdapter.openLoadAnimation();
        //获取顶部布局的实例
        View top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) mRecyclerView.getParent(), false);
        //将View添加到标题布局的后面
        homeAdapter.addHeaderView(top);
        //设置条目的点击事件
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //获取当前的Item的数据类
                HomeItem item = (HomeItem) adapter.getItem(position);
                //使用Intent进行activity跳转
                Intent intent = new Intent(HomeActivity.this, item.getActivity());
                startActivity(intent);
            }
        });
        //给RecyclerView设置数据适配器
        mRecyclerView.setAdapter(homeAdapter);
    }

    //对List<HomeItem>数据进行初始化
    private List<HomeItem> getHomeItemData() {
        return Arrays.asList(
                new HomeItem("Animation", AnimationUseActivity.class, R.mipmap.gv_animation),
                new HomeItem("MultipleItem", ChooseMultipleItemUseTypeActivity.class, R.mipmap.gv_multipleltem),
                new HomeItem("Header/Footer", HeaderAndFooterUseActivity.class, R.mipmap.gv_header_and_footer),
                new HomeItem("PullToRefresh", PullToRefreshUseActivity.class, R.mipmap.gv_pulltorefresh),
                new HomeItem("Section", SectionUseActivity.class, R.mipmap.gv_section),
                new HomeItem("EmptyView", EmptyViewUseActivity.class, R.mipmap.gv_empty),
                new HomeItem("DragAndSwipe", ItemDragAndSwipeUseActivity.class, R.mipmap.gv_drag_and_swipe),
                new HomeItem("ItemClick", ItemClickActivity.class, R.mipmap.gv_item_click),
                new HomeItem("ExpandableItem", ExpandableUseActivity.class, R.mipmap.gv_expandable),
                new HomeItem("DataBinding", DataBindingUseActivity.class, R.mipmap.gv_databinding),
                new HomeItem("UpFetchData", UpFetchUseActivity.class, R.drawable.gv_up_fetch),
                new HomeItem("SectionMultipleItem", SectionMultipleItemUseActivity.class, R.mipmap.gv_multipleltem),
                new HomeItem("DiffUtil", DiffUtilActivity.class, R.mipmap.gv_databinding)
        );
    }
}
