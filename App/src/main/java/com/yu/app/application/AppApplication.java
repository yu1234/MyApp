package com.yu.app.application;

import android.app.Application;

import com.yu.library.application.IApplication;
import com.yu.library.application.LibraryApplication;


public class AppApplication extends Application implements IApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
    }

    @Override
    public void init(Application application) {
        LibraryApplication.getInstance().init(this);
    }

    @Override
    public Application getApplication() {
        return this;
    }
}
