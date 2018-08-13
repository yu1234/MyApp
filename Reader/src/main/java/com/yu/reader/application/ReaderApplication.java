package com.yu.reader.application;

import android.app.Application;

import com.yu.library.BuildConfig;
import com.yu.library.application.IApplication;

public class ReaderApplication implements IApplication {
    private static ReaderApplication instance = new ReaderApplication();

    private ReaderApplication() {
    }

    public static ReaderApplication getInstance() {
        return instance;
    }

    @Override
    public void init(Application application) {
        if (!BuildConfig.IS_DEBUG) {
            ReaderReleaseApplication.getInstance().init(application);
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.IS_DEBUG) {
            return ReaderDebugApplication.getInstance().getApplication();
        } else {
            return ReaderReleaseApplication.getInstance().getApplication();
        }

    }
}
