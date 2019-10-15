package com.quyunshuo.brvahrecyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.kyleduo.switchbutton.SwitchButton;
import com.quyunshuo.brvahrecyclerview.adapter.AnimationAdapter;
import com.quyunshuo.brvahrecyclerview.animation.CustomAnimation;
import com.quyunshuo.brvahrecyclerview.data.Status;

public class AnimationUseActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private AnimationAdapter mAdapter;
    private ImageView mImageBack;
    private MaterialSpinner mSpinner;
    private SwitchButton mSwitchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_use);
        initView();
        initData();
        initMenu();

    }

    private void initView() {
        mImageBack = findViewById(R.id.img_back);
        mSwitchButton = findViewById(R.id.switch_button);
        mRecyclerView = findViewById(R.id.recycler);
        mSpinner = findViewById(R.id.spinner);
        //设置LayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mImageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //初始化Menu
    private void initMenu() {
        //设置Menu的item
        mSpinner.setItems("AlphaIn", "ScaleIn", "SlideInBottom", "SlideInLeft", "SlideInRight", "Custom");
        mSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                switch (position) {
                    case 0:
                        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                        break;
                    case 1:
                        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                        break;
                    case 2:
                        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                        break;
                    case 3:
                        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
                        break;
                    case 4:
                        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
                        break;
                    case 5:
                        mAdapter.openLoadAnimation(new CustomAnimation());
                        break;
                    default:
                        break;
                }
                //设置完加载动画时重新设置适配器
                mRecyclerView.setAdapter(mAdapter);
            }
        });
        //init FirstOnly
        mAdapter.isFirstOnly(false);
        //
        mSwitchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    mAdapter.isFirstOnly(true);
                } else {
                    mAdapter.isFirstOnly(false);
                }
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initData() {
        mAdapter = new AnimationAdapter();
        //打开加载动画
        mAdapter.openLoadAnimation();
        //设置不做animation的个数
        mAdapter.setNotDoAnimationCount(3);
        //设置点击事件
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String content = null;
                Status status = (Status) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.imgView:
                        content = "imgView:" + status.getUserAvatar();
                        Toast.makeText(AnimationUseActivity.this, content, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.text:
                        content = "name:" + status.getUserName();
                        Toast.makeText(AnimationUseActivity.this, content, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.text2:
                        content = "tweetText:" + status.getUserName();
                        Toast.makeText(AnimationUseActivity.this, content, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }
}
