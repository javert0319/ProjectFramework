package com.chia.app.splash;

import android.content.Intent;
import android.os.Bundle;
import com.chia.app.MainActivity;
import com.chia.app.R;
import com.chia.app.common.CommonSubscriber;
import com.lib.frame.view.simple.BaseSimpleActivity;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class SplashActivity extends BaseSimpleActivity {

    private static final int DELAY_TIME = 3000;

    @Override
    public void initVarAndView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void initDoing() {
        super.initDoing();
        Flowable.timer(DELAY_TIME, TimeUnit.MILLISECONDS, Schedulers.io())
                .subscribeWith(new CommonSubscriber<Long>(this) {
                    @Override
                    public void onNext(Long aLong) {
                        /*ARouter.getInstance()
                                .build("/demo/main")
                                .navigation();*/
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }
}
