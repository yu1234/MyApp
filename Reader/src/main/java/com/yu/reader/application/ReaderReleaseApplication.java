package com.yu.reader.application;

import android.app.Application;

import com.yu.library.application.IApplication;

public class ReaderReleaseApplication implements IApplication {
    private static ReaderReleaseApplication instance = new ReaderReleaseApplication();
    private Application mApplication;

    private ReaderReleaseApplication() {
    }

    public static ReaderReleaseApplication getInstance() {
        return instance;
    }

    @Override
    public void init(Application application) {
        this.mApplication=application;
    }

    @Override
    public Application getApplication() {
        return  this.mApplication;
    }
}
