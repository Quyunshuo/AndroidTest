package com.quyunshuo.ads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private AdView mAdViewLarge;
    private AdView mAViewMedium;
    private AdView mAdViewSm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化广告
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        initView();
        //请求广告
        AdRequest adRequest = new AdRequest.Builder().build();
        //加载广告
        mAdView.loadAd(adRequest);
        mAdViewLarge.loadAd(adRequest);
        mAViewMedium.loadAd(adRequest);
        mAdViewSm.loadAd(adRequest);
    }

    private void initView() {
        mAdView = findViewById(R.id.adView);
        mAdViewLarge = findViewById(R.id.adView_large);
        mAViewMedium = findViewById(R.id.adView_medium);
        mAdViewSm = findViewById(R.id.adView_sm);
    }
}
