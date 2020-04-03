package com.quyunshuo.ads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialAdActivity extends AppCompatActivity {
    private Button button;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial_ad);
        initAd();
        initView();
    }

    private void initAd() {
        //插页式广告由InterstitialAd对象来请求和展示。第一步是将InterstitialAd实例化并设置其广告单元 ID。这可在 Activity 的 onCreate() 方法中完成
        //在 Activity 的整个生命周期内，只需使用一个InterstitialAd对象，即可请求并展示多个插页式广告，因此该对象只需构建一次
        mInterstitialAd = new InterstitialAd(this);
        //测试Id
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //广告的监听
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                //可以非常方便地使用 AdListener 类的 onAdClosed() 方法，在展示完上一个插页式广告后加载新的插页式广告
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }
        });
    }

    private void initView() {
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //插页式广告应在应用流程的自然停顿期间
                //例如，在游戏的不同关卡之间或者在用户完成一项任务之后展示。
                // 要展示插页式广告，请使用 isLoaded() 方法验证广告是否已完成加载，然后再调用 show()
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Toast.makeText(InterstitialAdActivity.this, "Error:请求失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
