package com.quyunshuo.ads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

public class NativeAdvertisingActivity extends AppCompatActivity {
    private AdLoader adLoader;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_advertising);
        initAd();
    }

    private void initAd() {
        adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        if (adLoader.isLoading()) {
                            Toast.makeText(NativeAdvertisingActivity.this, "原生广告加载成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(NativeAdvertisingActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(int i) {
                        super.onAdFailedToLoad(i);
                    }
                }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build();
    }
}
