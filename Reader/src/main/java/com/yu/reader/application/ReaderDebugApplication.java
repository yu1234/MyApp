package com.yu.reader.application;

import android.app.Application;

import com.yu.library.BuildConfig;
import com.yu.library.application.IApplication;
import com.yu.library.application.LibraryApplication;

public class ReaderDebugApplication extends Application implements IApplication {
    private static ReaderDebugApplication instance = null;


    public static ReaderDebugApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        this.init(this);
    }

    @Override
    public void init(Application application) {
        LibraryApplication.getInstance().init(application);
    }

    @Override
    public Application getApplication() {
        return this;
    }
}
