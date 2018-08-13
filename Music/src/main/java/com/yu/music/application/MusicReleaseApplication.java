package com.yu.music.application;

import android.app.Application;

import com.yu.library.application.IApplication;

public class MusicReleaseApplication implements IApplication {
    private static MusicReleaseApplication instance = new MusicReleaseApplication();
    private Application mApplication;

    private MusicReleaseApplication() {
    }

    public static MusicReleaseApplication getInstance() {
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
