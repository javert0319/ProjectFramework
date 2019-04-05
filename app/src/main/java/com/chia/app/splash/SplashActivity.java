package com.chia.app.splash;

import android.content.Intent;
import android.os.Bundle;
import com.alibaba.android.arouter.launcher.ARouter;
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
        //setContentView(R.layout.activity_splash);
    }

    @Override
    public void initDoing() {
        super.initDoing();
        // 后台返回时可能启动这个页面 http://blog.csdn.net/jianiuqi/article/details/54091181
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        Flowable.timer(DELAY_TIME, TimeUnit.MILLISECONDS, Schedulers.io())
                .subscribeWith(new CommonSubscriber<Long>(this) {
                    @Override
                    public void onNext(Long aLong) {
                        ARouter.getInstance().build("/movie/main")
                                .withString("title", "首页")
                                .navigation();
                        /*Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();*/
                        overridePendingTransition(R.anim.screen_zoom_in, R.anim.screen_zoom_out);
                        finish();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
