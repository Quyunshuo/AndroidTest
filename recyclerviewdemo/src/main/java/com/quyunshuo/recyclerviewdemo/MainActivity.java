package com.quyunshuo.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mAlphaln;
    private Button mScaleln;
    private Button mSlidelnBottom;
    private Button mSlidelnLeft;
    private Button mSlidelnRight;
    private Button mCustom;
    private RecyclerView mRecyclerView;
    private AnimationAdapter mAnimationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();
    }


    /**
     * 初始化View
     */
    private void initView() {
        mAlphaln = findViewById(R.id.btn1);
        mScaleln = findViewById(R.id.btn2);
        mCustom = findViewById(R.id.btn3);
        mSlidelnRight = findViewById(R.id.btn4);
        mSlidelnLeft = findViewById(R.id.btn5);
        mSlidelnBottom = findViewById(R.id.btn6);
        mAlphaln.setOnClickListener(this);
        mScaleln.setOnClickListener(this);
        mCustom.setOnClickListener(this);
        mSlidelnLeft.setOnClickListener(this);
        mSlidelnRight.setOnClickListener(this);
        mSlidelnBottom.setOnClickListener(this);
        mRecyclerView = findViewById(R.id.recycler_view);
        //设置此RecyclerView要使用的LayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * 初始化数据
     */
    private void initData() {


    }

    /**
     * 初始化Adapter
     */
    private void initAdapter() {
        //获取适配器实例并传入item布局和数据
        mAnimationAdapter = new AnimationAdapter(R.layout.item1, getSampleData(100));
        //在加载时打开动画
        mAnimationAdapter.openLoadAnimation();
//        int mFirstPageItemCount = 3;
        //不做动画计数
//        mAnimationAdapter.setNotDoAnimationCount(mFirstPageItemCount);
        //设置条目的点击事件
        mAnimationAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.iv:
                        Toast.makeText(MainActivity.this, "ImageView:这是第" + position + 1 + "条数据。",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv:
                        Toast.makeText(MainActivity.this, "TextView:这是第" + position + 1 + "条数据。",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        //true是只在数据加载时显示动画 false时数据已经加载完毕在滑动的时候也会显示动画
        mAnimationAdapter.isFirstOnly(false);
        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setAdapter(mAnimationAdapter);
    }

    /**
     * Status数据
     *
     * @param lenth
     * @return
     */
    private List<Status> getSampleData(int lenth) {
        List<Status> list = new ArrayList<>();
        for (int i = 0; i < lenth; i++) {
            Status status = new Status();
            status.setTitle("That's number" + (i + 1));
            list.add(status);
        }
        return list;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                break;
            case R.id.btn2:
                mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                break;
            case R.id.btn3:
                mAnimationAdapter.openLoadAnimation(new CustomAnimation());
                break;
            case R.id.btn4:
                mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                break;
            case R.id.btn5:
                mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
                break;
            case R.id.btn6:
                mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                break;
            default:
                break;
        }
        //重新设置适配器，因为动画已更改
        mRecyclerView.setAdapter(mAnimationAdapter);
    }
}
