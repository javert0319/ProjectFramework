package com.chia.app;

import android.content.Context;
import android.support.multidex.MultiDex;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lib.frame.view.BaseApp;
import com.nbhope.hopelauncher.lib.network.NetFacade;
import fm.qingting.qtsdk.QTSDK;

public class App extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){ //如果在debug模式下
            // 打印日志,默认关闭
            ARouter.openLog();
            // 开启调试模式，默认关闭(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
            // 打印日志的时候打印线程堆栈
            ARouter.printStackTrace();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(this);
        NetFacade.init(this);

        QTSDK.setHost("https://open.staging.qingting.fm");
        QTSDK.Debug = true;
        QTSDK.init(getApplicationContext(), "MmYxYThlY2EtYWMxMi0xMWU4LTkyM2YtMDAxNjNlMDAyMGFk");
        QTSDK.setAuthRedirectUrl("http://qttest.qingting.fm");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
