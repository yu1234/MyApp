package com.yu.music.application;

import android.app.Application;

import com.yu.library.application.IApplication;
import com.yu.library.application.LibraryApplication;

public class MusicDebugApplication extends Application implements IApplication {
    private static MusicDebugApplication instance = null;


    public static MusicDebugApplication getInstance() {
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
