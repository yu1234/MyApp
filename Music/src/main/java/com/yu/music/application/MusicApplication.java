package com.yu.music.application;

import android.app.Application;

import com.yu.library.BuildConfig;
import com.yu.library.application.IApplication;

public class MusicApplication implements IApplication {
    private static MusicApplication instance = new MusicApplication();

    private MusicApplication() {
    }

    public static MusicApplication getInstance() {
        return instance;
    }

    @Override
    public void init(Application application) {
        if (!BuildConfig.IS_DEBUG) {
            MusicReleaseApplication.getInstance().init(application);
        }
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.IS_DEBUG) {
            return MusicDebugApplication.getInstance().getApplication();
        } else {
            return MusicReleaseApplication.getInstance().getApplication();
        }

    }
}
