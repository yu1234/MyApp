package com.yu.library.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import com.blankj.utilcode.util.Utils;
import com.yu.library.BuildConfig;

public class LibraryApplication implements IApplication {
    private static LibraryApplication instance = new LibraryApplication();
    private Application mApplication;

    private LibraryApplication() {
    }

    public static LibraryApplication getInstance() {
        return instance;
    }


    @Override
    public void init(Application application) {
        this.mApplication = application;
        Utils.init(application);
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if(BuildConfig.IS_DEBUG){
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(mApplication); // 尽可能早，推荐在Application中初始化
    }

    @Override
    public Application getApplication() {
        return this.mApplication;
    }
}
