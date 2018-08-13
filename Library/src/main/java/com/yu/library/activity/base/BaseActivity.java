package com.yu.library.activity.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.yu.library.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity extends AppCompatActivity {
    protected ImmersionBar mImmersionBar;
    protected Toolbar mToolbar;
    protected TextView mToolbarTitle;
    protected ActionBar mActionBar;
    private Unbinder unbinder;

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutId());
         com.alibaba.android.arouter.launcher.ARouter.getInstance().inject(this);
        //绑定初始化ButterKnife
        this.unbinder = ButterKnife.bind(this);
        if (isImmersionBarEnabled()) {
            /**
             * 沉浸式状态栏
             */
            mImmersionBar = ImmersionBar.with(this);  //状态栏透明度，不写默认0.0f
            mImmersionBar  //使用该属性,必须指定状态栏颜色
                    .statusBarColor(R.color.lib_bar_default_primary).statusBarDarkFont(true).keyboardEnable(true);
        }
        this.init();
        if (mImmersionBar != null) {
            mImmersionBar.init();
        }
        /*设置监听器*/
        this.setListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
            this.unbinder = null;
        }
        if (mImmersionBar != null) {
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
        }
        compositeDisposable.dispose();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void init() {
    }

    protected abstract int getLayoutId();


    protected void setListener() {

    }

    /**
     * 是否在Fragment使用沉浸式
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }


}
