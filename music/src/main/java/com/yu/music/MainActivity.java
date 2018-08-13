package com.yu.music;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.yu.library.activity.base.BaseActivity;
import com.yu.library.beans.TestObj;
import com.yu.library.global.RouterMap;

@Route(path = "/music/MainActivity")
public class MainActivity extends BaseActivity {
    @Autowired
    public  TestObj testObj;
    @Autowired
    public   String name;
    @Override
    public int getLayoutId() {
        return R.layout.music_activity_main;
    }

    @Override
    protected void init() {
        ARouter.getInstance().inject(this);
        LogUtils.i(testObj);
        LogUtils.i(name);
    }
}
