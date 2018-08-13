package com.yu.app.activity;

import android.support.v7.widget.Toolbar;
import android.widget.Button;


import com.alibaba.android.arouter.launcher.ARouter;
import com.yu.app.R;
import com.yu.library.activity.base.BaseActivity;
import com.yu.library.beans.TestObj;


import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.app_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.button)
    Button button;

    @Override
    public int getLayoutId() {
        return R.layout.app_activity_main;
    }

    @Override
    protected void init() {
        initToolbar();
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(view -> {
            TestObj testObj = new TestObj();
            testObj.setId(1000);
            testObj.setName("nnnnn");
            ARouter.getInstance().build("/music/MainActivity").withObject("testObj",testObj).withString("name","111111111").navigation();
        });
    }
    /**
     * 初始化action bar
     */
    private void initToolbar() {
        this.setSupportActionBar(this.mToolbar);
        this.mActionBar = this.getSupportActionBar();
        this.mActionBar.setDisplayHomeAsUpEnabled(true);
        this.mActionBar.setDisplayShowTitleEnabled(false);
        this.mImmersionBar.titleBar(this.mToolbar);
    }

}
